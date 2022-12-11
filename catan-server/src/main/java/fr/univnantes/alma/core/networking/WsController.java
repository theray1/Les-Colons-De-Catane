package fr.univnantes.alma.core.networking;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.game.GameController;

import java.io.IOException;

public interface WsController {

    void sendCommand(GameController gameController, Command command) throws IOException;

}
