package fr.univnantes.alma.server.controller;

import fr.univnantes.alma.core.game.GameControllerImpl;
import fr.univnantes.alma.core.game.GameFacade;
import fr.univnantes.alma.core.game.GameFacadeImpl;
import fr.univnantes.alma.core.gamemager.ServerGameController;
import fr.univnantes.alma.core.game.GameController;
import org.springframework.stereotype.Component;
import java.util.*;


@Component("Default Server Game Controller")
public class ServerGamesControllerImpl implements ServerGameController {

    private final LinkedList<GameFacade> gameFacades = new LinkedList<>();

    @Override
    public List<GameFacade> getAllGames() {
        return gameFacades;
    }

    @Override
    public GameFacade getGameWithSlot(){
        GameFacade lastGameController = gameFacades.getLast();
        if(lastGameController == null || lastGameController.isFull()) {
           return addNewGame();
        }
        return lastGameController;
    }

    private GameFacade addNewGame() {
        GameFacade gameFacade = new GameControllerImpl().getFacade();
        gameFacades.addLast(gameFacade);
        return gameFacade;

    }
}
