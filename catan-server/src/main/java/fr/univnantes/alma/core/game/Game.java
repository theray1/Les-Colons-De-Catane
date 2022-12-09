package fr.univnantes.alma.core.game;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.controler.ServerGameController;
import fr.univnantes.alma.core.game.entity.Player;

import java.util.List;

public interface Game{
    Player joinPlayer(Command command);
    boolean isFull();

    ServerGameController getGameController();

    void submit(Command command);

}