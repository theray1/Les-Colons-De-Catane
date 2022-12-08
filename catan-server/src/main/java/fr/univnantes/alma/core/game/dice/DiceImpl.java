package fr.univnantes.alma.core.game.dice;

public class DiceImpl implements Dice {
	private int value;

	@Override
	public int getValue() {
		return this.value;
	}

	@Override
	public void roll() {
		this.value = (int) (1 + (Math.random() * 12)); // 12 => 2 Dices
	}
}