package fr.univnantes.alma.core.game;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.game.map.coordinates.Coordinates;
import fr.univnantes.alma.core.game.resource.Resource;

public interface GameFacade {
    void start();
    void end();
    void endPlayerTurn();
    void addRessource(Player player, Resource[] resources);
    void removeResources(Player player, Resource[] resources);
    void moveRobber(Coordinates coordinates);
    boolean isFull();
    void submit(Command command);
    Player addPlayer();

}
