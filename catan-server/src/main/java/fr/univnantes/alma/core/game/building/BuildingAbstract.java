package fr.univnantes.alma.core.game.building;

import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;

public abstract class BuildingAbstract implements Building {
	protected final Player owner;
	protected final Coordinates coords;
	protected final Buildings type;

	protected BuildingAbstract(Coordinates coords, Buildings type, Player owner) {
		this.coords = coords;
		this.owner = owner;
		this.type = type;
	}

	@Override
	public Player getOwner() {
		return this.owner;
	}


	@Override
	public Coordinates getCoordinates() {
		return this.coords;
	}

	@Override
	public Buildings getType() {
		return this.type;
	}
}