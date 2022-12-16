package fr.univnantes.alma.core.game.map;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.building.Buildings;
import fr.univnantes.alma.core.game.entity.Robber;
import fr.univnantes.alma.core.game.entity.RobberImpl;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.coordinates.CoordinatesImpl;
import fr.univnantes.alma.core.game.map.harbor.Harbor;
import fr.univnantes.alma.core.game.map.harbor.HarborImpl;
import fr.univnantes.alma.core.game.map.harbor.HarborTrades;
import fr.univnantes.alma.core.game.map.tile.*;
import fr.univnantes.alma.core.game.resource.Resource;
import fr.univnantes.alma.core.game.resource.ResourceImpl;
import fr.univnantes.alma.core.game.resource.Resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CatanMapImpl implements CatanMap {
    private final int size;
    private final Tile[][] tiles;
    private final List<Building> buildings;
    private final Robber robber = new RobberImpl();

    public CatanMapImpl() {
        this.size = 7;
        this.buildings = new ArrayList<>();
        // Creating the tile array
        this.tiles = new Tile[size][];
        for (int i = 0; i < size; i++) {
            this.tiles[i] = new Tile[(i < size / 2 ? i + 4 : size - i + 3)];
        }
    }

    @Override
    public void generateTiles() {
        boolean validate = false;
        Tiles type = null;

        int row = 1 + (int) (Math.random() * 10) % 5;
        int column = 1 + (int) (Math.random() * tiles[row].length - 2);
        tiles[row][column] = new TileImpl(new CoordinatesImpl(row, column), Tiles.DESERT, this);
        tiles[row][column].placeRobber(robber);
        robber.setCoordinates(tiles[row][column].getCoordinates());

        for (int i = 0; i < size; i++) {
            // First and last line
            if (i == 0 || i == size - 1) {
                tiles[i][1] = new TileImpl(new CoordinatesImpl(i, 1), Tiles.SEA, this);
                tiles[i][2] = new TileImpl(new CoordinatesImpl(i, 2), Tiles.SEA, this);
            } else {
                // Course of non-ocean tiles
                for (int y = 1; y < tiles[i].length - 1; y++) {
                    if (tiles[i][y] != null) continue;
                    validate = false;
                    while (!validate) {

                        validate = true;
                        switch ((int) (Math.random() * Tiles.getMaxTypeOfTiles() - 3)) {
                            case 0 -> type = Tiles.FOREST;
                            case 1 -> type = Tiles.MOUNTAIN;
                            case 2 -> type = Tiles.PASTURE;
                            case 3 -> type = Tiles.FIELD;
                            case 4 -> type = Tiles.HILL;
                            default -> validate = false;
                        }

                    }
                    tiles[i][y] = new TileImpl(new CoordinatesImpl(i, y), type, this);
                }
            }

            // The first and last tile of this line
            tiles[i][0] = new TileImpl(new CoordinatesImpl(i, 0), Tiles.SEA, this);
            tiles[i][tiles[i].length - 1] = new TileImpl(new CoordinatesImpl(i, tiles[i].length - 1), Tiles.SEA, this);
        }

    }

    public void generateEdgesVertices() {
        generateEdgesVerticesReccursive(new CoordinatesImpl(size / 2, size / 2));
    }

    private void generateEdgesVerticesReccursive(Coordinates c) {
        if (!this.isValidCoordinates(c)) return;
        else if (getTile(c).isComplete()) {
            return;
        }

        Coordinates[] neighbors = new Coordinates[6];

        // Call the up left tile
        neighbors[0] = new CoordinatesImpl(c.getRow() - 1, c.getColumn() - 1, 1);
        // Call the up right tile
        neighbors[1] = new CoordinatesImpl(c.getRow() - 1, c.getColumn(), 2);
        // Call the right tile
        neighbors[2] = new CoordinatesImpl(c.getRow(), c.getColumn() + 1, 3);
        // Call the down right tile
        neighbors[3] = new CoordinatesImpl(c.getRow() + 1, c.getColumn() + 1, 4);
        // Call the down left tile
        neighbors[4] = new CoordinatesImpl(c.getRow() + 1, c.getColumn(), 5);
        // Call the left tile
        neighbors[5] = new CoordinatesImpl(c.getRow(), c.getColumn() - 1, 6);

        Tile actual = getTile(c), neighbor;
        Coordinates common;
        Edge e;

        // Connect edges
        for (int i = 1; i <= 6; i++) {
            if (!isValidCoordinates(neighbors[i - 1])) continue;
            neighbor = getTile(neighbors[i - 1]);

            if (neighbor.getType().equals(Tiles.SEA) && actual.getType().equals(Tiles.SEA)) continue;

            common = new CoordinatesImpl(0, 0, 1 + ((neighbors[i - 1].getEnd() + 2) % 6));
            e = neighbor.getEdge(common);

            if (e == null) {
                e = new Edge(actual.getHarbor());
            }
            actual.setEdge(e, neighbors[i - 1]);
        }

        // Connect Vertices
        Vertice v;
        Coordinates c1, c2;
        Tile t1, t2;
        int[] ends = {3, 5, 4, 6, 5, 1, 2, 6, 3, 1, 2, 4};
        for (int i = 1; i <= 6; i++) {
            c1 = new CoordinatesImpl(neighbors[(i - 1) % 6].getRow(), neighbors[(i - 1) % 6].getColumn(), ends[(i - 1) * 2]);
            c2 = new CoordinatesImpl(neighbors[i % 6].getRow(), neighbors[i % 6].getColumn(), ends[(i - 1) * 2 + 1]);

            if (isValidCoordinates(c1)) {
                t1 = getTile(c1);
                if (!t1.getType().equals(Tiles.SEA)) {
                    v = t1.getVertice(c1);
                    actual.setVertice(Objects.requireNonNullElseGet(v,
                            () -> new Vertice(actual.getHarbor())), new CoordinatesImpl(0, 0, i));
                    continue;
                }
            }
            if (isValidCoordinates(c2)) {
                t2 = getTile(c2);
                if (!t2.getType().equals(Tiles.SEA)) {
                    v = t2.getVertice(c2);
                    actual.setVertice(Objects.requireNonNullElseGet(v,
                            () -> new Vertice(actual.getHarbor())), new CoordinatesImpl(0, 0, i));
                    continue;
                }
            }
            if (!actual.getType().equals(Tiles.SEA)) {
                actual.setVertice(new Vertice(actual.getHarbor()), new CoordinatesImpl(0, 0, i));
            }
        }

        for (Coordinates cNext : neighbors) {
            generateEdgesVerticesReccursive(cNext);
        }

    }

    @Override
    public void placeHarbors() {
        Tile tile;
        Harbor harbor;
        int nbHarbor = 6 + (int) (Math.random() * 6);
        for (int i = 0; i < nbHarbor; i++) {
            tile = getRandomTileSeaWithoutHarbor();
            harbor = createRandomHarbor();
            tile.placeHarbor(harbor);
        }
    }

    @Override
    public Harbor createRandomHarbor() {
        HarborTrades[] trades = HarborTrades.values();
        HarborTrades trade = trades[(int) (Math.random() * trades.length)];
        Harbor b;
        if (trade.isRandom()) {
            b = new HarborImpl(trade, Collections.emptyList(), Collections.emptyList());
        } else {
            List<Resource> require = new ArrayList<>();
            List<Resource> given = new ArrayList<>();

            Resource requireResourceType = new ResourceImpl(Resources.values()[(int) (Math.random() * Resources.values().length)]);

            Resource givenResourceType = requireResourceType;
            while (givenResourceType == requireResourceType) {
                givenResourceType = new ResourceImpl(Resources.values()[(int) (Math.random() * Resources.values().length)]);
            }
            for (int i = 0; i < trade.getRequire(); i++) {
                require.add(new ResourceImpl(requireResourceType));
            }

            for (int i = 0; i < trade.getGiven(); i++) {
                given.add(new ResourceImpl(givenResourceType));
            }

            b = new HarborImpl(trade, require, given);
        }

        return b;

    }

    private Tile getRandomTileSeaWithoutHarbor() {
        Tile retour = null;
        int line = 0;
        while (retour == null) {
            line = (int) (Math.random() * size);
            retour = tiles[line][Math.random() > 0.5 ? 0 : tiles[line].length - 1];
            if (retour.containsHarbor()) retour = null;
        }
        return retour;
    }

    @Override
    public Tile getTile(Coordinates coords) {
        if (!isValidCoordinates(coords)) throw new IllegalArgumentException("Coords invalid");
        return tiles[coords.getRow()][coords.getColumn()];
    }

    @Override
    public boolean isValidCoordinates(Coordinates coords) {
        return coords.getRow() >= 0 && coords.getRow() < size && coords.getColumn() >= 0 && coords.getColumn() < tiles[coords.getRow()].length;
    }

    @Override
    public void placeBuilding(Building b) {
        Tile t = getTile(b.getCoordinates());
        Buildings typeB = b.getType();

        // Is it an edge type building?
        if (typeB == Buildings.EDGE) {

        }
    }

    @Override
    public void placeRobber(Coordinates coords) {
        this.getTile(robber.getCoordinates()).placeRobber(null);
        this.getTile(coords).placeRobber(robber);
    }

    /**
     * Methods for test
     */
    public Tile[] getRow(int i) {
        return tiles[i];
    }

}