package fr.univnantes.alma.core.game.building;

import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.tile.Edge;
import fr.univnantes.alma.core.game.map.tile.Vertice;

public abstract class BuildingAbstract implements Building {
	protected final Player owner;
	protected final Coordinates coords;

	protected BuildingAbstract(Coordinates coords, Player owner) {
		this.coords = coords;
		this.owner = owner;
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