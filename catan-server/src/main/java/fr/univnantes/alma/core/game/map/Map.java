package fr.univnantes.alma.core.game.map;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.harbor.Harbor;
import fr.univnantes.alma.core.game.map.tile.Tile;

public interface Map {
	/**
	 * Generation of tiles
	 */
	public void generateTiles();

	/**
	 * Generation of vertices and edges
	 */
	public void generateEdgesVertices();

	/**
	 * Harbor generation
	 */
	public void placeHarbors();

	/**
	 * Getter of an Tile
	 * 
	 * @exception IllegalArgumentException Throw if the coordinates are not correct
	 * @param coords The coordinates
	 * @return The tile
	 */
	public Tile getTile(Coordinates coords);

	/**
	 * Test if coords are correct
	 * 
	 * @param coords The coords
	 * @return true or false
	 */
	public boolean isValidCoordinates(Coordinates coords);

	public void placeBuilding(Building b);

	public Harbor createRandomHarbor();

	public void placeRobber(Coordinates coords);
}