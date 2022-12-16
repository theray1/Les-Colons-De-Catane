package fr.univnantes.alma.core.game.entity;

import fr.univnantes.alma.core.game.map.coordinates.Coordinates;

public interface Robber {
	Coordinates getCoordinates();

	void setCoordinates(Coordinates coords);
}
