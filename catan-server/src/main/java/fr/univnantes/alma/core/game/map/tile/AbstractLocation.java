package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.harbor.Harbor;

public abstract class AbstractLocation implements Location {
	protected final Coordinates coordinates;
	protected Building building;
	protected final Harbor harbor;

	protected AbstractLocation(Coordinates coords, Harbor harbor) {
		this.harbor = harbor;
		this.coordinates = coords;
	}

	@Override
	public boolean isFree() {
		return building != null;
	}

	@Override
	public Coordinates getCoordinates() {
		return this.coordinates;
	}

	@Override
	public boolean containsHarbor() {
		return harbor != null;
	}

	@Override
	public void setBuilding(Building b) {
		this.building = b;

	}

}
