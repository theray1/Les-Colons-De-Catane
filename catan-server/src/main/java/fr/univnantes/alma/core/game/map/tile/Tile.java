package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.building.Buildings;
import fr.univnantes.alma.core.game.entity.Robber;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.harbor.Harbor;
import fr.univnantes.alma.core.game.resource.Resource;

public interface Tile {

	/**
	 * Get the resource of this tile
	 * 
	 * @return A Clone of the resource
	 */
	Resource getResource();

	/**
	 * Get the coordinates of this tile. A Tile must have coordinates
	 * 
	 * @return The coords of this tile
	 */
	Coordinates getCoordinates();

	/**
	 * Test if this Tile contains Robber
	 * 
	 * @return true if Yes, false otherwise
	 */
	boolean containsRobber();

	/**
	 * Place building on a Location of this tile
	 * 
	 * @param building The building to place
	 */
	void setBuilding(Building building);

	/**
	 * Place robber on this tile. This tile cannot be type of SEA
	 * 
	 * @param rob The Robber
	 */
	void placeRobber(Robber rob);

	/**
	 * Remove robber of this tile
	 * 
	 * @return The robber
	 */
	Robber removeRobber();

	/**
	 * Place harbor on this tile. This tile must be type of SEA
	 * 
	 * @param har The Harbor
	 */
	void placeHarbor(Harbor har);

	/**
	 * Get harbor on this tile.
	 * 
	 * @return harbor The Harbor
	 */
	Harbor getHarbor();

	/**
	 * Test if this Tile contains Harbor
	 * 
	 * @return true if Yes, false otherwise
	 */
	boolean containsHarbor();

	/**
	 * Get the edge corresponding to the coordinates.
	 * 
	 * @param coords The coordinates
	 * @return The edge
	 */
	Edge getEdge(Coordinates coords);

	/**
	 * Get the vertice corresponding to the coordinates.
	 * 
	 * @param coords The coordinates
	 * @return The vertice
	 */
	Vertice getVertice(Coordinates coords);

	/**
	 * Set the edge.
	 * 
	 * @param edge   The edge
	 * @param coords The coordinates
	 */
	void setEdge(Edge edge, Coordinates coords);

	/**
	 * Set the edge.
	 * 
	 * @param vertice The vertice
	 * @param coords The coordinates
	 */
	void setVertice(Vertice vertice, Coordinates coords);

	Location getLocation(Buildings type, Coordinates coords);

	/**
	 * Get the type of this tile
	 * 
	 * @return The type
	 */
	Tiles getType();

	/**
	 * Test if the tile instance is complete (all vertices, all edges)
	 * 
	 * @return true or false
	 */
	boolean isComplete();

	/**
	 * Sets the number of this tile
	 * 
	 * @param number
	 */
	void setNumber(int number);

	boolean canBuild(Building b);
}