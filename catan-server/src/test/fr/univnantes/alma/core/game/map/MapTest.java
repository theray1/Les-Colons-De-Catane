package fr.univnantes.alma.core.game.map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.coordinates.CoordinatesImpl;
import fr.univnantes.alma.core.game.map.tile.Tile;

public class MapTest {

	@Test
	public void testGenerateTile() {
		MapImpl map = new MapImpl(7);
		map.generateTiles();
		Tile[] rowTile;

		for (int row = 0; row < 7; row++) {
			rowTile = map.getRow(row);
			for (Tile t : rowTile) {
				assertNotNull(t);
			}
		}
	}

	@Test
	public void testPlaceHarbors() {
		MapImpl map = new MapImpl(7);
		map.generateTiles();
		map.placeHarbors();
		Tile[] rowTile;

		int harbors = 0;
		for (int row = 0; row < 7; row++) {
			rowTile = map.getRow(row);
			if (rowTile[0].containsHarbor())
				harbors++;
			if (rowTile[rowTile.length - 1].containsHarbor())
				harbors++;
		}
		// Min 6 harbor
		assertTrue(harbors >= 6);
	}

	@Test
	public void testGenerateEdgesVertices() {
		MapImpl map = new MapImpl(7);
		map.generateTiles();
		map.generateEdgesVertices();

		Tile[] rowTile;

		for (int row = 0; row < 7; row++) {
			rowTile = map.getRow(row);
			for (Tile t : rowTile) {
				assertTrue(t.isComplete());
			}
		}

	}

	@Test
	public void testGetTile() {
		// Creating a size 6 map (Normal size)
		Map maps = new MapImpl(7);
		maps.generateTiles();
		Coordinates coords = new CoordinatesImpl(2, 3, 0);
		assertTrue(maps.getTile(coords).getCoordinates().equalsTile(coords));
	}

	@Test
	public void testIsValidCoordinates() {
		Map map = new MapImpl(7);

		assertTrue(map.isValidCoordinates(new CoordinatesImpl(0, 0)));
		assertTrue(map.isValidCoordinates(new CoordinatesImpl(3, 3)));
		assertFalse(map.isValidCoordinates(new CoordinatesImpl(-1, 0)));
		assertFalse(map.isValidCoordinates(new CoordinatesImpl(-3, 0)));
		assertFalse(map.isValidCoordinates(new CoordinatesImpl(1, -3)));
		assertFalse(map.isValidCoordinates(new CoordinatesImpl(-3, -3)));
		assertFalse(map.isValidCoordinates(new CoordinatesImpl(7, 7)));
	}

}
