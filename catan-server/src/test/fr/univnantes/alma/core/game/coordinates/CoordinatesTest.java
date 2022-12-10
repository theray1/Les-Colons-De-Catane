package fr.univnantes.alma.core.game.coordinates;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.coordinates.CoordinatesImpl;

public class CoordinatesTest {
	@Test
	public void testEqualsTile() {
		Coordinates co1 = new CoordinatesImpl(0, 1, 2);
		Coordinates co2 = new CoordinatesImpl(0, 1, 3);
		Coordinates co3 = new CoordinatesImpl(1, 1, 2);

		assertTrue(co1.equalsTile(co2));
		assertFalse(co1.equalsTile(co3));
	}

	@Test
	public void testEquals() {
		Coordinates co1 = new CoordinatesImpl(0, 1, 2);
		Coordinates co2 = new CoordinatesImpl(0, 1, 3);
		Coordinates co3 = new CoordinatesImpl(0, 1, 2);

		assertTrue(co1.equals(co3));
		assertFalse(co1.equals(co2));
	}
}
