package fr.univnantes.alma.core.game.map;

import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.map.tile.Tile;

public interface Map {
	public Tile getTile(Coordinates coords);
}