package fr.univnantes.alma.core.game;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.gamemager.ServerGameController;
import fr.univnantes.alma.core.game.entity.Player;

public interface GameController {
    Player joinPlayer(Command command);
    boolean isFull();

    ServerGameController getGameController();

    void submit(Command command);

}