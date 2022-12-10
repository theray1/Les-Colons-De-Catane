package fr.univnantes.alma.core.game.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.univnantes.alma.core.game.Game;
import fr.univnantes.alma.core.game.card.Card;
import fr.univnantes.alma.core.game.card.Cards;
import fr.univnantes.alma.core.game.resource.Resource;
import fr.univnantes.alma.core.game.resource.Resources;

public class PlayerImpl implements Player {

	private final Game game;

	private final String name;

	private int victoryPoints = 0;

	private Map<Resources, Integer> resources;

	private Map<Cards, Integer> cards;

	@Override
	public String getName() {
		return name;
	}

	public PlayerImpl(Game game, String name) {
		this.game = game;
		this.name = name;

		this.cards = new HashMap<Cards, Integer>();
		this.resources = new HashMap<Resources, Integer>();
		for (Resources r : Resources.values()) {
			if (!r.equals(Resources.NOTHING)) {
				this.resources.put(r, 0);
			}
		}
		for (Cards c : Cards.values()) {
			this.cards.put(c, 0);
		}
	}

	@Override
	public Game getGame() {
		return game;
	}

	@Override
	public void addResources(List<Resource> resources) {
		for (Resource r : resources) {
			this.resources.put(r.getType(), this.resources.get(r.getType()) + 1);
		}

	}

	@Override
	public boolean haveResources(List<Resource> resources) {
		HashMap<Resources, Integer> res = new HashMap<Resources, Integer>();
		for (Resources r : Resources.values()) {
			res.put(r, 0);
		}
		Resources type;
		for (Resource r : resources) {
			type = r.getType();
			res.put(type, res.get(type));
			if (res.get(type) > this.resources.get(type)) {
				return false;
			}
		}
		return true;

	}

	@Override
	public void removeResources(List<Resource> resources) throws NotEnoughResourcesException {
		if (haveResources(resources))
			throw new NotEnoughResourcesException("Not enough resources");

		for (Resource r : resources) {
			this.resources.put(r.getType(), this.resources.get(r.getType()) - 1);
		}

	}

	@Override
	public int getAmountOfResources() {
		return this.resources.values().stream().mapToInt(Integer::intValue).sum();
	}

	@Override
	public void addCard(List<Card> cards) {
		for (Card c : cards) {
			this.cards.put(c.getType(), this.cards.get(c.getType()) + 1);
			if (c.getType() == Cards.VP) {
				// You cannot "lose" a victory point card
				this.victoryPoints++;
			}
		}
	}

	@Override
	public int getAmountOfVictoryPoints() {
		return this.victoryPoints;
	}

	@Override
	public void givePoints(int amount) {
		this.victoryPoints += amount;

	}
}