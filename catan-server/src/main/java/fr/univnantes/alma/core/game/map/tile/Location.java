package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.building.Building;

public interface Location {

	/**
	 * Test if this Location contain a building
	 * 
	 * @return True if Free, false otherwise
	 */
	boolean isFree();

	/**
	 * Place building on this Location
	 * 
	 * @param b The Building
	 */
	void setBuilding(Building b);

	Building getBuilding();

	/**
	 * Test if this location contain a harbor
	 * 
	 * @return
	 */
	boolean containsHarbor();

}