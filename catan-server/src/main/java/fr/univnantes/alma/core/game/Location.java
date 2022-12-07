package fr.univnantes.alma.core.game;

public interface Location{
  public boolean isFree();
  public Coordinates getCoordinates();
  public void setCoordinates(Coordinates coords);
  public boolean containsHarbor();
}