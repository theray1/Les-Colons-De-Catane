package fr.univnantes.alma.core.game.tile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.coordinates.CoordinatesImpl;
import fr.univnantes.alma.core.game.map.harbor.Harbor;
import fr.univnantes.alma.core.game.map.harbor.HarborImpl;
import fr.univnantes.alma.core.game.map.tile.Edge;
import fr.univnantes.alma.core.game.map.tile.Tile;
import fr.univnantes.alma.core.game.map.tile.TileImpl;
import fr.univnantes.alma.core.game.map.tile.Tiles;

public class TileTest {
	Tile t;

	@Test
	public void testGetType() {
		Coordinates c = new CoordinatesImpl(1, 2);
		Tiles type = Tiles.FIELD;
		t = new TileImpl(c, type);

		assertEquals(type, t.getType());
	}

	@Test
	public void testGetCoordinates() {
		Coordinates c = new CoordinatesImpl(1, 2);
		t = new TileImpl(c, Tiles.FIELD);

		assertEquals(c, t.getCoordinates());
	}

	@Test
	public void testPlaceHarbor() {
		Tiles type = Tiles.PASTURE;
		Coordinates c = new CoordinatesImpl(1, 2);
		t = new TileImpl(c, type);
		Harbor hb = new HarborImpl(null);

		assertThrows(IllegalStateException.class, () -> t.placeHarbor(hb));
	}

	@Test
	public void testEdge() {
		Harbor hb = new HarborImpl(null);
		Coordinates c = new CoordinatesImpl(1, 2);
		Tiles type = Tiles.SEA;
		t = new TileImpl(c, type);
		t.placeHarbor(hb);

		Coordinates c2 = new CoordinatesImpl(1, 2, 3);
		Edge e = new Edge(c2, hb);

		t.setEdge(e);

	}
}
