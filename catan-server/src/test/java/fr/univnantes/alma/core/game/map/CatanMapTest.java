package fr.univnantes.alma.core.game.map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.coordinates.CoordinatesImpl;
import fr.univnantes.alma.core.game.map.tile.Tile;

public class CatanMapTest {

	@Test
	public void testGenerateTile() {
		CatanMapImpl map = new CatanMapImpl();
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
		CatanMapImpl map = new CatanMapImpl();
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
		CatanMapImpl map = new CatanMapImpl();
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
		CatanMap maps = new CatanMapImpl();
		maps.generateTiles();
		Coordinates coords = new CoordinatesImpl(2, 3, 0);
		assertTrue(maps.getTile(coords).getCoordinates().equalsTile(coords));
	}

	@Test
	public void testIsValidCoordinates() {
		CatanMap catanMap = new CatanMapImpl();

		assertTrue(catanMap.isValidCoordinates(new CoordinatesImpl(0, 0)));
		assertTrue(catanMap.isValidCoordinates(new CoordinatesImpl(3, 3)));
		assertFalse(catanMap.isValidCoordinates(new CoordinatesImpl(-1, 0)));
		assertFalse(catanMap.isValidCoordinates(new CoordinatesImpl(-3, 0)));
		assertFalse(catanMap.isValidCoordinates(new CoordinatesImpl(1, -3)));
		assertFalse(catanMap.isValidCoordinates(new CoordinatesImpl(-3, -3)));
		assertFalse(catanMap.isValidCoordinates(new CoordinatesImpl(7, 7)));
	}

}
