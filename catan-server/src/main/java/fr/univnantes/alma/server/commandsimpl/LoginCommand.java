package fr.univnantes.alma.server.commandsimpl;

import fr.univnantes.alma.core.game.entity.Player;
import org.springframework.lang.Nullable;

import java.util.Optional;
import java.util.Set;

public class LoginCommand extends JacksonCommandWithContext {

    @Nullable
    private Player player = null;

    public Optional<Player> getPlayer() {return Optional.ofNullable(player);}

    protected LoginCommand(Set<Player> recipient) {
        super(recipient);
    }

    @Override
    public void run() {
        player = context.gameController().addPlayer();
    }

}
