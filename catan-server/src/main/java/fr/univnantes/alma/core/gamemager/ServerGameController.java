package fr.univnantes.alma.core.gamemager;

import fr.univnantes.alma.core.game.GameController;
import fr.univnantes.alma.core.game.GameFacade;

import java.util.List;

public interface ServerGameController {
    List<GameFacade> getAllGames();

    GameFacade getGameWithSlot();
}
