package fr.univnantes.alma.core.game.entity;

import fr.univnantes.alma.core.game.map.coordinates.Coordinates;

public class RobberImpl implements Robber {
	private Coordinates coords;

	@Override
	public Coordinates getCoordinates() {
		return coords;
	}

	@Override
	public void setCoordinates(Coordinates coords) {
		this.coords = coords;

	}

}
