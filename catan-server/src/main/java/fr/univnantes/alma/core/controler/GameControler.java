package fr.univnantes.alma.core.controler;

import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.game.Player;

public interface GameControler {
    void receiveCommand(Command command);


    //void addParticipant(Login login, Player player);
    void addPlayer(Player player);
}
