package fr.univnantes.alma.core.networking;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.game.entity.Player;

public interface ConnectionHandler {
    void BroadCast(Command command);
    void sendCommand(Command command);
    boolean isEnabled();
    //Login not added yet
    //void addParticipant(Login login, Player player);
}
