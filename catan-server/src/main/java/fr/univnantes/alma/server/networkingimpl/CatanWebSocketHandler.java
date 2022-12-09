package fr.univnantes.alma.server.networkingimpl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univnantes.alma.server.commandsimpl.LoginCommand;
import fr.univnantes.alma.core.commands.Command;

import fr.univnantes.alma.core.controler.ServerGameController;
import fr.univnantes.alma.core.game.Game;
import fr.univnantes.alma.core.game.entity.Player;
import fr.univnantes.alma.core.networking.WsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
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
    private final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();

    private final ServerGameController serverGameController;

    public CatanWebSocketHandler(ServerGameController serverGameController) {
        this.serverGameController = serverGameController;
    }

    private final HashMap<Player,WebSocketSession> playerToConnection = new HashMap<>(4);
    private final HashMap<WebSocketSession, Player> connectionToPlayer = new HashMap<>(4);

    @Override
    public void sendCommand(Game game, Command command) throws IOException {
        for(Player recipient: command.getRecipents()){
            WebSocketSession session = playerToConnection.get(recipient);
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(command)));
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        log.info("{} Connected", session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        try {
            Command command = objectMapper.readValue(message.getPayload(), Command.class);
            if (command instanceof LoginCommand) {
                Game game = serverGameController.getGameWithSlot();
                Player player = game.joinPlayer(command);

                connectionToPlayer.put(session, player);
                playerToConnection.put(player, session);
            }
            connectionToPlayer.get(session).getGame().submit(command);
        }catch (JsonProcessingException processingException){
            log.error(processingException.getMessage());
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        log.info("{} Disconnected", session.getId());
    }
}
