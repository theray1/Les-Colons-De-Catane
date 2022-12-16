package fr.univnantes.alma.core.game.map.coordinates;

public interface Coordinates {
	/**
	 * Get the line
	 * 
	 * @return An integer that represents the Row coordinate
	 */
	int getRow();

	/**
	 * Get the column
	 * 
	 * @return An integer that represents the Column coordinate
	 */
	int getColumn();

	/**
	 * Get the end (used for vertices and edges)
	 * 
	 * @return An integer that represents the End coordinate
	 */
	int getEnd();

	/**
	 * Comparison of row and column coordinates (Tile)
	 * 
	 * @param other The other Coordinates
	 * @return true if equals, false otherwise
	 */
	boolean equalsTile(Coordinates other);

	/**
	 * Overload of the equals method to compare 2 objects completely
	 * 
	 * @param other A supposed other object of type coordinate sImpl
	 * @return true if equals, false otherwise
	 */
	boolean equals(Object other);

}
