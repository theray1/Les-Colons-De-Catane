package fr.univnantes.alma.server.networkingimpl;


import fr.univnantes.alma.core.game.GameFacade;
import fr.univnantes.alma.core.networking.SerialiserException;
import fr.univnantes.alma.core.networking.Serializer;
import fr.univnantes.alma.server.commandsimpl.ImmutableCommandContext;
import fr.univnantes.alma.server.commandsimpl.JSONSerializer;
import fr.univnantes.alma.server.commandsimpl.LoginCommand;
import fr.univnantes.alma.core.commands.Command;

import fr.univnantes.alma.core.gamemager.ServerGameController;
import fr.univnantes.alma.core.game.GameController;
import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.networking.WsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;

@Controller
@ComponentScan("fr.univnantes.alma.server.controller")
public class CatanWebSocketHandler extends TextWebSocketHandler implements WsController {

    private static final Logger log = LoggerFactory.getLogger(CatanWebSocketHandler.class);
    private final Serializer<String> objectMapper = new JSONSerializer();

    private final ServerGameController serverGameController;

    public CatanWebSocketHandler(ServerGameController serverGameController) {
        this.serverGameController = serverGameController;
    }
    private final HashMap<Player,WebSocketSession> playerToConnection = new HashMap<>(4);
    private final HashMap<WebSocketSession, Player> connectionToPlayer = new HashMap<>(4);

    @Override
    public void sendCommand(GameController gameController, Command command) throws IOException {
        for(Player recipient: command.getRecipents()){
            WebSocketSession session = playerToConnection.get(recipient);
            session.sendMessage(new TextMessage(objectMapper.serialize(command)));
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        log.info("{} Connected", session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        dissociateWsAndPlayer(session);
        log.info("{} Disconnected", session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        try {
            Command command = objectMapper.deserialize(message.getPayload());
            if (command instanceof LoginCommand loginCommand) {
                interceptLoginCommand(session, loginCommand);
            }else {
                sendCommandToGame(session, command);
            }
        }catch (SerialiserException processingException){
            log.error(processingException.getMessage());
        }
    }

    private void sendCommandToGame(WebSocketSession session, Command command) {
        Player player = connectionToPlayer.get(session);
        if (player != null) {
            command.setContext(new ImmutableCommandContext(player.getGame().getFacade())); //rip demeter
            player.getGame().submit(command);
        }
    }

    private void interceptLoginCommand(WebSocketSession session, LoginCommand loginCommand) {
        GameFacade gameController = serverGameController.getGameWithSlot();
        gameController.submit(loginCommand);
        Player player = loginCommand.getPlayer().orElseThrow(()->
                new AssertionError("Missing player in command. This indicate a malformed command." +
                        "Make sure that command receive context"));
        associateWsAndPlayer(session, player);
    }

    private void associateWsAndPlayer(WebSocketSession session, Player player) {
        connectionToPlayer.put(session, player);
        playerToConnection.put(player, session);
    }
    private void dissociateWsAndPlayer(WebSocketSession session) {
        Player player = connectionToPlayer.remove(session);
        playerToConnection.remove(player);
    }
}
