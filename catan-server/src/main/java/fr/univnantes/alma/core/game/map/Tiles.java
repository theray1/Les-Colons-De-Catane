package fr.univnantes.alma.core.game.map;

public enum Tiles {
	HILL, FOREST, MOUNTAIN, PASTURE, FIELD, DESERT, SEA;

	public static int getMaxTypeOfTiles() {
		return 7;
	}
}