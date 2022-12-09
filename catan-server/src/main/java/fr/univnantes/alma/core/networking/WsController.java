package fr.univnantes.alma.core.networking;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.game.Game;

import java.io.IOException;

public interface WsController {

    void sendCommand(Game game, Command command) throws IOException;

}
