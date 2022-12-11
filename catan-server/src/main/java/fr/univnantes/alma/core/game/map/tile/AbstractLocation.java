package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.map.harbor.Harbor;

public abstract class AbstractLocation implements Location {
	protected Building building;
	protected final Harbor harbor;

	protected AbstractLocation(Harbor harbor) {
		this.harbor = harbor;
	}

	@Override
	public boolean isFree() {
		return building != null;
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
