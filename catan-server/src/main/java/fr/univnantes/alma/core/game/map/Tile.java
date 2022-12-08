package fr.univnantes.alma.core.game.map;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.resource.Resource;

public interface Tile {
	public Resource getResource();

	public Coordinates getCoordinates();

	public boolean containsRobber();

	public void setBuilding(Building building);

	public void placeHarbor(Harbor harbor);

	public void placeRobber();

	public void removeRobber();
}