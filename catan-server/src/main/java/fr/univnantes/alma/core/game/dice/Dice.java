package fr.univnantes.alma.core.game.dice;

public interface Dice {

	/**
	 * Get the actual value of dice
	 * 
	 * @return an integer
	 */
	int getValue();

	/**
	 * Do roll the dice
	 */
	void roll();
}