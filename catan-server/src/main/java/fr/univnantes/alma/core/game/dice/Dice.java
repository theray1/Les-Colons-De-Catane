package fr.univnantes.alma.core.game.dice;

public interface Dice {

	/**
	 * Get the actual value of dice
	 * 
	 * @return an integer
	 */
	public int getValue();

	/**
	 * Do roll the dice
	 */
	public void roll();
}