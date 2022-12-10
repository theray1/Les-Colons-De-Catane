package fr.univnantes.alma.core.game.entity;

public class NotEnoughResourcesException extends Exception {
	public NotEnoughResourcesException(String msg) {
		super(msg);
	}
}
