package fr.univnantes.alma.core.game.map;

import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.coordinates.CoordinatesImpl;
import fr.univnantes.alma.core.game.map.harbor.Harbor;
import fr.univnantes.alma.core.game.map.harbor.HarborImpl;
import fr.univnantes.alma.core.game.map.harbor.HarborTrades;
import fr.univnantes.alma.core.game.map.tile.Edge;
import fr.univnantes.alma.core.game.map.tile.Tile;
import fr.univnantes.alma.core.game.map.tile.TileImpl;
import fr.univnantes.alma.core.game.map.tile.Tiles;
import fr.univnantes.alma.core.game.map.tile.Vertice;

public class MapImpl implements Map {
	private final int size;
	private Tile[][] tiles;

	public MapImpl(int size) {
		this.size = size;
		// Creating the tile array
		this.tiles = new Tile[size][];
		for (int i = 0; i < size; i++) {
			this.tiles[i] = new Tile[(i < size / 2 ? i + 4 : size - i + 3)];
		}
	}

	public void generateTiles() {
		boolean desertBuild = false;
		boolean validate = false;
		Tiles type = null;
		for (int i = 0; i < size; i++) {
			// First and last line
			if (i == 0 || i == size - 1) {
				tiles[i][1] = new TileImpl(new CoordinatesImpl(i, 1, 0), Tiles.SEA);
				tiles[i][2] = new TileImpl(new CoordinatesImpl(i, 2, 0), Tiles.SEA);
			} else {
				// Course of non-ocean tiles
				for (int y = 1; y < tiles[i].length - 1; y++) {
					validate = false;
					while (!validate) {

						validate = true;
						switch ((int) (Math.random() * Tiles.getMaxTypeOfTiles() - 1)) {
						case 0:
							type = Tiles.FOREST;
							break;
						case 1:
							type = Tiles.MOUNTAIN;
							break;
						case 2:
							type = Tiles.PASTURE;
							break;
						case 3:
							type = Tiles.FIELD;
							break;
						case 4:
							if (!desertBuild) {
								type = Tiles.HILL;
								desertBuild = true;
							} else {
								validate = false;
							}
							;
							break;
						default:
							validate = false;
							break;
						}

					}
					tiles[i][y] = new TileImpl(new CoordinatesImpl(i, y, 0), type);
				}
			}

			// The first and last tile of this line
			tiles[i][0] = new TileImpl(new CoordinatesImpl(i, 0, 0), Tiles.SEA);
			tiles[i][tiles[i].length - 1] = new TileImpl(new CoordinatesImpl(i, tiles[i].length - 1, 0), Tiles.SEA);
		}

	}

	public void generateEdgesVertices() {
		generateEdgesReccursive(new CoordinatesImpl(size / 2, size / 2));
	}

	private void generateEdgesReccursive(Coordinates c) {
		System.out.println(c.getRow() + " " + c.getColumn());
		if (!this.isValidCoordinates(c) || getTile(c).isComplete())
			return;

		Coordinates[] neighbors = new Coordinates[6];

		// Call the up left tile
		neighbors[0] = new CoordinatesImpl(c.getRow() - 1, c.getColumn(), 6);
		// Call the up right tile
		neighbors[1] = new CoordinatesImpl(c.getRow() - 1, c.getColumn() + 1, 1);
		// Call the left tile
		neighbors[2] = new CoordinatesImpl(c.getRow(), c.getColumn() - 1, 5);
		// Call the right tile
		neighbors[3] = new CoordinatesImpl(c.getRow(), c.getColumn() + 1, 2);
		// Call the down left tile
		neighbors[4] = new CoordinatesImpl(c.getRow() + 1, c.getColumn(), 3);
		// Call the down right tile
		neighbors[5] = new CoordinatesImpl(c.getRow() + 1, c.getColumn() + 1, 4);

		Tile actual = getTile(c), neighbor;
		Coordinates common;
		Vertice v;
		Edge e;
		for (int i = 1; i < size; i++) {
			if (!isValidCoordinates(neighbors[i - 1]))
				continue;
			neighbor = getTile(neighbors[i - 1]);
			common = new CoordinatesImpl(neighbors[i - 1].getRow(), neighbors[i - 1].getColumn(),
					1 + (neighbors[i - 1].getEnd() + 2) % 6);

			v = neighbor.getVertice(common);
			e = neighbor.getEdge(common);

			// Vertice
			if (v == null) {
				System.out.println("new");
				v = new Vertice(neighbors[i - 1], actual.getHarbor());
			}
			actual.setVertice(v);

			// Edge
			if (e == null) {
				System.out.println("new");
				e = new Edge(neighbors[i - 1], actual.getHarbor());
			}
			actual.setEdge(e);

		}

		for (Coordinates c2 : neighbors) {
			generateEdgesReccursive(c2);
		}

	}

	public void placeHarbors() {
		Tile tile;
		Harbor harbor;
		int nbHarbor = 6 + (int) (Math.random() * 6);
		for (int i = 0; i < nbHarbor; i++) {
			tile = getRandomTileSeaWithoutHarbor();
			harbor = new HarborImpl(HarborTrades.TWOTOONE);
			tile.placeHarbor(harbor);
		}
	}

	private Tile getRandomTileSeaWithoutHarbor() {
		Tile retour = null;
		int line = 0;
		while (retour == null) {
			line = (int) (Math.random() * size);
			retour = tiles[line][Math.random() > 0.5 ? 0 : tiles[line].length - 1];
			if (retour.containsHarbor())
				retour = null;
		}
		return retour;
	}

	@Override
	public Tile getTile(Coordinates coords) {
		if (!isValidCoordinates(coords))
			throw new IllegalArgumentException("Coords invalid");
		return tiles[coords.getRow()][coords.getColumn()];
	}

	@Override
	public boolean isValidCoordinates(Coordinates coords) {
		return coords.getRow() > 0 && coords.getRow() < tiles[coords.getRow()].length && coords.getColumn() > 0
				&& coords.getColumn() < size;
	}

	/**
	 * Methods for test
	 */
	public Tile[] getRow(int i) {
		return tiles[i];
	}
}