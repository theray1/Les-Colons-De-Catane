package fr.univnantes.alma.core.game.dice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class testDice {
	@Test
	public void testDiceRoll() {
		Dice d = new DiceImpl();
		d.roll();
		assertTrue(d.getValue() >= 2 && d.getValue() <= 12);
	}
}
