package fr.univnantes.alma.server.commandsimpl;

import fr.univnantes.alma.core.commands.AbstractCommand;
import fr.univnantes.alma.core.game.entity.Player;

import java.util.Set;

public class LoginCommand extends AbstractCommand {

    protected LoginCommand(Set<Player> recipient) {
        super(recipient);
    }

    @Override
    public void run() {

    }

}
