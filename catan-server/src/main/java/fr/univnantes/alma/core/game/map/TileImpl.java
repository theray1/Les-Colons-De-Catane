package fr.univnantes.alma.core.game.map;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.resource.Resource;

public class TileImpl implements Tile {
	private final Coordinates coords;
	private boolean robber = false;
	private final Tiles type;

	public TileImpl(Coordinates coords, Tiles type) {
		this.coords = coords;
		this.type = type;
	}

	@Override
	public Resource getResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coordinates getCoordinates() {
		return this.coords;
	}

	@Override
	public boolean containsRobber() {
		// TODO Auto-generated method stub
		return this.robber;
	}

	@Override
	public void setBuilding(Building building) {
		// TODO Auto-generated method stub

	}

	@Override
	public void placeHarbor(Harbor harbor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void placeRobber() {
		this.robber = true;

	}

	@Override
	public void removeRobber() {
		this.robber = false;

	}

}
