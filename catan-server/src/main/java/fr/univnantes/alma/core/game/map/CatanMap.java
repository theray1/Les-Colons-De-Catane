package fr.univnantes.alma.core.game.map;

import fr.univnantes.alma.core.game.building.Building;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.harbor.Harbor;
import fr.univnantes.alma.core.game.map.tile.Tile;

public interface CatanMap {
	/**
	 * Generation of tiles
	 */
	void generateTiles();

	/**
	 * Generation of vertices and edges
	 */
	void generateEdgesVertices();

	/**
	 * Harbor generation
	 */
	void placeHarbors();

	/**
	 * Tile getter
	 * 
	 * @exception IllegalArgumentException Throw if the coordinates are not correct
	 * @param coords The coordinates
	 * @return The tile
	 */
	Tile getTile(Coordinates coords);

	/**
	 * Test if coords are correct
	 * 
	 * @param coords The coords
	 * @return true or false
	 */
	boolean isValidCoordinates(Coordinates coords);

	void placeBuilding(Building b);

	Harbor createRandomHarbor();

	void placeRobber(Coordinates coords);
}