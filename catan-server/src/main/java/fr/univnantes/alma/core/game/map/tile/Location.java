package fr.univnantes.alma.core.game.map.tile;

import fr.univnantes.alma.core.game.map.coordinates.Coordinates;

public interface Location{
  public boolean isFree();
  public Coordinates getCoordinates();
  public void setCoordinates(Coordinates coords);
  public boolean containsHarbor();
}