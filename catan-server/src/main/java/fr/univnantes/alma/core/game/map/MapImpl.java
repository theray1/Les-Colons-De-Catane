package fr.univnantes.alma.core.game.map;

public class MapImpl implements Map {
	private final int SIZE = 6;
	private Tile[][] tiles;

	public MapImpl() {
		// Creating the tile array
		for (int i = 0; i <= SIZE; i++) {
			this.tiles = new Tile[(i < SIZE / 2 ? i + 4 : SIZE - i + 4)][];
		}
		// Map generation
		generateTiles();
		placeHarbors();
	}

	private void generateTiles() {
		boolean desertBuild = false;
		boolean validate = false;
		Tiles type = null;
		for (int i = 0; i <= SIZE; i++) {
			// First and last line
			if (tiles[i].length == 4) {
				tiles[i][1] = new TileImpl(new CoordinatesImpl(i, 1, 0), Tiles.SEA);
				tiles[i][2] = new TileImpl(new CoordinatesImpl(i, 2, 0), Tiles.SEA);
			} else {
				// Course of non-ocean tiles
				for (int y = 1; y <= tiles[i].length - 2; i++) {
					validate = false;
					while (!validate) {
						validate = true;
						switch ((int) Math.random() * Tiles.getMaxTypeOfTiles() - 1) {
						case 0:
							type = Tiles.HILL;
							break;
						case 1:
							type = Tiles.FOREST;
							break;
						case 2:
							type = Tiles.MOUNTAIN;
							break;
						case 3:
							type = Tiles.PASTURE;
							break;
						case 4:
							type = Tiles.FIELD;
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

	private void placeHarbors() {

	}

	@Override
	public Tile getTile(Coordinates coords) {
		// TODO Auto-generated method stub
		return null;
	}
}