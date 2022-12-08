package fr.univnantes.alma.core.game.building;

import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.map.Coordinates;
import fr.univnantes.alma.core.game.map.Edge;
import fr.univnantes.alma.core.game.map.Vertice;

public abstract class BuildingAbstract implements Building {
	private Player owner;
	private final Coordinates coords;

	protected BuildingAbstract(Coordinates coords) {
		this.coords = coords;
	}

	@Override
	public Player getOwner() {
		return this.owner;
	}

	@Override
	public abstract Vertice getVertice();

	@Override
	public abstract Edge getEdge();

	@Override
	public Coordinates getCoordinates() {
		return this.coords;
	}
}