package fr.univnantes.alma.core.game.building;

import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.tile.Edge;
import fr.univnantes.alma.core.game.map.tile.Vertice;

public interface Building {
	/**
	 * Get the Vertice this building is on. Or null if the building is not a
	 * verticeBuilding
	 * 
	 * @return The vertice or null
	 */
	public Vertice getVertice();

	/**
	 * Get the Edge this building is on. Or null if the building is not a
	 * edgeBuilding
	 * 
	 * @return The edge or null
	 */
	public Edge getEdge();

	/**
	 * Get the owner of this building
	 * 
	 * @return The Player owner
	 */
	public Player getOwner();

	/**
	 * Get the coordinates of this Building Cannot be null because a building is on
	 * a vertice/Edge
	 * 
	 * @return The coordinates
	 */
	public Coordinates getCoordinates();

	/**
	 * Get the type of this building
	 * 
	 * @return The type
	 */
	public Buildings getType();
}