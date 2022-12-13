package fr.univnantes.alma.core.game.tile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import fr.univnantes.alma.core.game.map.CatanMap;
import fr.univnantes.alma.core.game.map.CatanMapImpl;
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

public class TileTest {
	Tile t;

	@Test
	public void testGetType() {
		Coordinates c = new CoordinatesImpl(1, 2);
		Tiles type = Tiles.FIELD;
		t = new TileImpl(c, type, null);

		assertEquals(type, t.getType());
	}

	@Test
	public void testGetCoordinates() {
		Coordinates c = new CoordinatesImpl(1, 2);
		t = new TileImpl(c, Tiles.FIELD, null);

		assertEquals(c, t.getCoordinates());
	}

	@Test
	public void testPlaceHarbor() {
		Tiles type = Tiles.PASTURE;
		Coordinates c = new CoordinatesImpl(1, 2);
		t = new TileImpl(c, type, null);
		Harbor hb = new HarborImpl(HarborTrades.FOURTOONE, null, null);

		assertThrows(IllegalStateException.class, () -> t.placeHarbor(hb));
	}

	@Test
	public void testCreateRandomHarbor() {
		CatanMap m = new CatanMapImpl();
		Harbor h = m.createRandomHarbor();

		if (h.isRandomTrade()) {
			assertEquals(h.getRequireResources(), Collections.emptyList());
			assertEquals(h.getGivenResources(), Collections.emptyList());
		} else {
			System.out.println(h.getRequireResources().size() + " " + h.getType().getRequire());
			assertEquals(h.getRequireResources().size(), h.getType().getRequire());
			assertEquals(h.getGivenResources().size(), h.getType().getGiven());
		}
	}

	@Test
	public void testIsComplete() {
		CatanMap catanMap = new CatanMapImpl();
		catanMap.generateTiles();
		Tile t;

		// Case Center Tile
		t = catanMap.getTile(new CoordinatesImpl(3, 3));
		assertFalse(t.isComplete());
		for (int i = 1; i < 7; i++) {
			t.setVertice(new Vertice(), new CoordinatesImpl(0, 0, i));
			t.setEdge(new Edge(), new CoordinatesImpl(0, 0, i));
		}

		assertTrue(t.isComplete());

		catanMap = new CatanMapImpl();
		catanMap.generateTiles();

		// Case Center Tile 0;0
		t = catanMap.getTile(new CoordinatesImpl(0, 0));
		assertFalse(t.isComplete());
		t.setVertice(new Vertice(), new CoordinatesImpl(0, 0, 3));
		t.setVertice(new Vertice(), new CoordinatesImpl(0, 0, 4));
		t.setEdge(new Edge(), new CoordinatesImpl(0, 0, 4));

		assertTrue(t.isComplete());

		catanMap = new CatanMapImpl();
		catanMap.generateTiles();

		// Case Center Tile 1;0
		t = catanMap.getTile(new CoordinatesImpl(1, 0));
		assertFalse(t.isComplete());
		t.setVertice(new Vertice(), new CoordinatesImpl(0, 0, 2));
		t.setVertice(new Vertice(), new CoordinatesImpl(0, 0, 3));
		t.setVertice(new Vertice(), new CoordinatesImpl(0, 0, 4));
		t.setEdge(new Edge(), new CoordinatesImpl(0, 0, 3));
		t.setEdge(new Edge(), new CoordinatesImpl(0, 0, 4));

		assertTrue(t.isComplete());

		catanMap = new CatanMapImpl();
		catanMap.generateTiles();

		// Case Center Tile 0;3
		t = catanMap.getTile(new CoordinatesImpl(0, 3));
		assertFalse(t.isComplete());
		t.setVertice(new Vertice(), new CoordinatesImpl(0, 0, 4));
		t.setVertice(new Vertice(), new CoordinatesImpl(0, 0, 5));
		t.setEdge(new Edge(), new CoordinatesImpl(0, 0, 5));

		assertTrue(t.isComplete());

		catanMap = new CatanMapImpl();
		catanMap.generateTiles();

		// Case Center Tile 2;4
		t = catanMap.getTile(new CoordinatesImpl(2, 4));
		assertFalse(t.isComplete());
		for (int i = 1; i < 7; i++) {
			t.setVertice(new Vertice(), new CoordinatesImpl(0, 0, i));
			t.setEdge(new Edge(), new CoordinatesImpl(0, 0, i));
		}

		assertTrue(t.isComplete());

		catanMap = new CatanMapImpl();
		catanMap.generateTiles();

		// Case Center Tile 1;3
		t = catanMap.getTile(new CoordinatesImpl(1, 3));
		assertFalse(t.isComplete());
		for (int i = 1; i < 7; i++) {
			t.setVertice(new Vertice(), new CoordinatesImpl(0, 0, i));
			t.setEdge(new Edge(), new CoordinatesImpl(0, 0, i));
		}

		assertTrue(t.isComplete());

		catanMap = new CatanMapImpl();
		catanMap.generateTiles();

		// Case Center Tile 1;1
		t = catanMap.getTile(new CoordinatesImpl(1, 1));
		assertFalse(t.isComplete());
		for (int i = 1; i < 7; i++) {
			t.setVertice(new Vertice(), new CoordinatesImpl(0, 0, i));
			t.setEdge(new Edge(), new CoordinatesImpl(0, 0, i));
		}
		assertTrue(t.isComplete());

		catanMap = new CatanMapImpl();
		catanMap.generateTiles();

		// Case Center Tile 3;6
		t = catanMap.getTile(new CoordinatesImpl(3, 6));
		assertFalse(t.isComplete());
		for (int i = 1; i < 7; i++) {
			t.setVertice(new Vertice(), new CoordinatesImpl(0, 0, i));
			t.setEdge(new Edge(), new CoordinatesImpl(0, 0, i));
		}
		assertTrue(t.isComplete());

	}
}
