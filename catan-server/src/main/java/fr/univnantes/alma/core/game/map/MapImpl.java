package fr.univnantes.alma.core.game.map;

import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.coordinates.CoordinatesImpl;
import fr.univnantes.alma.core.game.map.harbor.Harbor;
import fr.univnantes.alma.core.game.map.harbor.HarborImpl;
import fr.univnantes.alma.core.game.map.harbor.HarborTrades;
import fr.univnantes.alma.core.game.map.tile.Tile;
import fr.univnantes.alma.core.game.map.tile.TileImpl;
import fr.univnantes.alma.core.game.map.tile.Tiles;

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
			line = (int) (Math.random() * SIZE + 1);
			retour = tiles[line][Math.random() > 0.5 ? 0 : 1];
			if (retour.containsHarbor())
				retour = null;
		}
		return retour;
	}

	@Override
	public Tile getTile(Coordinates coords) {
		return null;
	}
}