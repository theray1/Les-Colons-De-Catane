package fr.univnantes.alma.server.commandsimpl;

import fr.univnantes.alma.core.game.entity.Player;

import java.util.Set;

public class AddResources extends JacksonCommandWithContext{

    public AddResources(Set<Player> recipient) {
        super(recipient);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
