package fr.univnantes.alma.core.game;

public interface GameFacade {
    void start();
    void end();
    void endPlayerTurn();
    void addRessource(Player player, Resource[] resources);
    void removeResources(Player player, Resource[] resources);
    void moveRobber(Coordinates coordinates);

}
