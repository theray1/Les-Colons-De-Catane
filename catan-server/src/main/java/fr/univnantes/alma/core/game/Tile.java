package fr.univnantes.alma.core.game;

public interface Tile{
  public Resource getResource();
  public Coordinates getCoordinates();
  public boolean containsRobber();
  public void setBuilding(Building building);
}