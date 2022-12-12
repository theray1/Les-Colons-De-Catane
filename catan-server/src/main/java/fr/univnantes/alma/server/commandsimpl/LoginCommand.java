package fr.univnantes.alma.server.commandsimpl;

import fr.univnantes.alma.core.commands.CommandWithContext;
import fr.univnantes.alma.core.game.entity.Player;

import java.util.Set;

public class LoginCommand extends CommandWithContext {

    protected LoginCommand(Set<Player> recipient) {
        super(recipient);
    }

    @Override
    public void run() {

    }

}
