package fr.univnantes.alma.server.commandsimpl;

import fr.univnantes.alma.core.commands.CommandWithContext;
import fr.univnantes.alma.core.game.entity.Player;

import java.util.Optional;
import java.util.Set;

public class LoginCommand extends CommandWithContext {

    private Optional<Player> player = Optional.empty();

    public Optional<Player> getPlayer() {
        return player;
    }

    protected LoginCommand(Set<Player> recipient) {
        super(recipient);
    }

    @Override
    public void run() {
        player = Optional.of(context.gameController().addPlayer());
    }

}
