package fr.univnantes.alma.core.game.card;

public class DeveloppementCard implements Card {
	private Cards type;

	@Override
	public Cards getType() {
		return this.type;
	}
}