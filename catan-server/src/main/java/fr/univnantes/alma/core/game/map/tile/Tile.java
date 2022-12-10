package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.entity.Robber;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.harbor.Harbor;
import fr.univnantes.alma.core.game.resource.Resource;

public interface Tile {

	/**
	 * Get the resource of this tile
	 * 
	 * @return An Clone of the resource
	 */
	public Resource getResource();

	/**
	 * Get the coordinates of this tile. An Tile must have coordinates
	 * 
	 * @return The coords of this tile
	 */
	public Coordinates getCoordinates();

	/**
	 * Test if this Tile contains Robber
	 * 
	 * @return true if Yes, false otherwise
	 */
	public boolean containsRobber();

	/**
	 * Place building on an Location of this tile
	 * 
	 * @param building The building to place
	 */
	public void setBuilding(Building building);

	/**
	 * Place robber on this tile. This tile cannot be type of SEA
	 * 
	 * @param rob The Robber
	 */
	public void placeRobber(Robber rob);

	/**
	 * Remove robber of this tile
	 * 
	 * @return The robber
	 */
	public Robber removeRobber();

	/**
	 * Place harbor on this tile. This tile must be type of SEA
	 * 
	 * @param harbor The Harbor
	 */
	public void placeHarbor(Harbor har);

	/**
	 * Get harbor on this tile.
	 * 
	 * @return harbor The Harbor
	 */
	public Harbor getHarbor();

	/**
	 * Test if this Tile contains Harbor
	 * 
	 * @return true if Yes, false otherwise
	 */
	public boolean containsHarbor();

	/**
	 * Get the edge corresponding to the coordinates.
	 * 
	 * @param coords The coordinates
	 * @return The edge
	 */
	public Edge getEdge(Coordinates coords);

	/**
	 * Get the vertice corresponding to the coordinates.
	 * 
	 * @param coords The coordinates
	 * @return The vertice
	 */
	public Vertice getVertice(Coordinates coords);

	/**
	 * Set the edge.
	 * 
	 * @param edge The edge
	 */
	public void setEdge(Edge edge);

	/**
	 * Set the edge.
	 * 
	 * @param edge The vertice
	 */
	public void setVertice(Vertice vertice);

	/**
	 * Get the type of this tile
	 * 
	 * @return The type
	 */
	public Tiles getType();

	/**
	 * Test if the tile instance is complete (all vertices, all edges)
	 * 
	 * @return true or false
	 */
	public boolean isComplete();
}