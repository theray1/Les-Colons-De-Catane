package fr.univnantes.alma.core.game.entity;

import java.util.List;

import fr.univnantes.alma.core.game.GameController;
import fr.univnantes.alma.core.game.card.Card;
import fr.univnantes.alma.core.game.resource.Resource;
import jakarta.annotation.Nullable;

public interface Player {
	/**
	 * Get player name
	 * 
	 * @return His name
	 */
	String getName();

	/**
	 * Get player's game
	 * 
	 * @return The game
	 */
	@Nullable
	GameController getGame();

	/**
	 * Get the amount of victory points (cards + points)
	 * 
	 * @return the amount
	 */
	int getAmountOfVictoryPoints();

	/**
	 * Add resources to this player
	 * 
	 * @param resources The resources
	 */
	void addResources(List<Resource> resources);

	/**
	 * Test if the player has these resources in hand
	 * 
	 * @param resources The resources
	 */
	boolean haveResources(List<Resource> resources);

	/**
	 * Remove resources to this player
	 * 
	 * @param resources The resources
	 */
	void removeResources(List<Resource> resources) throws NotEnoughResourcesException;

	/**
	 * Allows to obtain the number of resources of a player
	 * 
	 * @return The amount of resources
	 */
	int getAmountOfResources();

	/**
	 * Give cards to player
	 * 
	 * @param cards
	 */
	void addCard(List<Card> cards);

	/**
	 * Give points to player
	 * 
	 * @param amount
	 */
	void givePoints(int amount);
}