package fr.univnantes.alma.core.game;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.gamemager.ServerGameController;
import fr.univnantes.alma.core.game.entity.Player;

public interface GameController {
    Player addPlayer();

    GameFacade getFacade();

    boolean isFull();
    void submit(Command command);



}