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

	@Override
	public void generateTiles() {
		boolean desertBuild = false;
		boolean validate = false;
		Tiles type = null;
		for (int i = 0; i < size; i++) {
			// First and last line
			if (i == 0 || i == size - 1) {
				tiles[i][1] = new TileImpl(new CoordinatesImpl(i, 1, 0), Tiles.SEA, this);
				tiles[i][2] = new TileImpl(new CoordinatesImpl(i, 2, 0), Tiles.SEA, this);
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
							type = Tiles.HILL;
							break;
						case 5:
							if (!desertBuild) {
								type = Tiles.DESERT;
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
					tiles[i][y] = new TileImpl(new CoordinatesImpl(i, y, 0), type, this);
				}
			}

			// The first and last tile of this line
			tiles[i][0] = new TileImpl(new CoordinatesImpl(i, 0, 0), Tiles.SEA, this);
			tiles[i][tiles[i].length - 1] = new TileImpl(new CoordinatesImpl(i, tiles[i].length - 1, 0), Tiles.SEA,
					this);
		}

	}

	public void generateEdgesVertices() {
		generateEdgesReccursive(new CoordinatesImpl(size / 2, size / 2));
	}

	private void generateEdgesReccursive(Coordinates c) {
		if (!this.isValidCoordinates(c))
			return;
		else if (getTile(c).isComplete()) {
			return;
		}
		System.out.println();

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
			if (!isValidCoordinates(neighbors[i - 1]))
				continue;
			neighbor = getTile(neighbors[i - 1]);

			if (neighbor.getType().equals(Tiles.SEA) && actual.getType().equals(Tiles.SEA))
				continue;

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
		int[] ends = { 3, 5, 4, 6, 5, 1, 2, 6, 3, 1, 2, 4 };
		for (int i = 1; i <= 6; i++) {
			c1 = new CoordinatesImpl(neighbors[(i - 1) % 6].getRow(), neighbors[(i - 1) % 6].getColumn(),
					ends[(i - 1) * 2]);
			c2 = new CoordinatesImpl(neighbors[i % 6].getRow(), neighbors[i % 6].getColumn(), ends[(i - 1) * 2 + 1]);

			if (isValidCoordinates(c1)) {
				t1 = getTile(c1);
				if (!t1.getType().equals(Tiles.SEA)) {
					v = t1.getVertice(c1);
					if (v == null) {
						actual.setVertice(new Vertice(actual.getHarbor()), new CoordinatesImpl(0, 0, i));
					} else {
						actual.setVertice(v, new CoordinatesImpl(0, 0, i));
					}
					continue;
				}
			}
			if (isValidCoordinates(c2)) {
				t2 = getTile(c2);
				if (!t2.getType().equals(Tiles.SEA)) {
					v = t2.getVertice(c2);
					if (v == null) {
						actual.setVertice(new Vertice(actual.getHarbor()), new CoordinatesImpl(0, 0, i));
					} else {
						actual.setVertice(v, new CoordinatesImpl(0, 0, i));
					}
					continue;
				}
			}
			if (!actual.getType().equals(Tiles.SEA)) {
				actual.setVertice(new Vertice(actual.getHarbor()), new CoordinatesImpl(0, 0, i));
			}

		}

		for (Coordinates cNext : neighbors) {
			generateEdgesReccursive(cNext);
		}

	}

	@Override
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
		return coords.getRow() >= 0 && coords.getRow() < size && coords.getColumn() >= 0
				&& coords.getColumn() < tiles[coords.getRow()].length;
	}

	/**
	 * Methods for test
	 */
	public Tile[] getRow(int i) {
		return tiles[i];
	}
}