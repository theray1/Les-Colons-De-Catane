package fr.univnantes.alma.core.game.dice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDice {
	@Test
	public void testDiceRoll() {
		Dice d = new DiceImpl();
		d.roll();
		assertTrue(d.getValue() >= 2 && d.getValue() <= 12);
	}
}
