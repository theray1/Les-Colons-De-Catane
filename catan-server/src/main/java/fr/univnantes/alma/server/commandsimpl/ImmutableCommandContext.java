package fr.univnantes.alma.server.commandsimpl;

import fr.univnantes.alma.core.commands.CommandContext;
import fr.univnantes.alma.core.game.GameFacade;

public record ImmutableCommandContext(GameFacade gameFacade) implements CommandContext {
    @Override
    public GameFacade gameController() {
        return gameFacade;
    }
}
