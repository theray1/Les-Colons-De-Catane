package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;

public interface Location {

	/**
	 * Test if this Location contain a building
	 * 
	 * @return True if Free, false otherwise
	 */
	public boolean isFree();

	/**
	 * Place building on this Location
	 * 
	 * @param b The Building
	 */
	public void setBuilding(Building b);

	/**
	 * Get his coodinates A Location cannot instanciate after the start of the game
	 * => a Location must have coordinates
	 * 
	 * @return Coordinates
	 */
	public Coordinates getCoordinates();

	/**
	 * Test if this location contain a harbor
	 * 
	 * @return
	 */
	public boolean containsHarbor();
}