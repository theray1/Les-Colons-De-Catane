package fr.univnantes.alma.core.game.map;

public interface Location{
  public boolean isFree();
  public Coordinates getCoordinates();
  public void setCoordinates(Coordinates coords);
  public boolean containsHarbor();
}