package fr.univnantes.alma.server.networkingimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.univnantes.alma.core.commands.Command;
import fr.univnantes.alma.core.networking.SerialiserException;
import fr.univnantes.alma.core.networking.Serializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public class JSONSerializer implements Serializer<String> {

    private static final ObjectMapper mapper = Jackson2ObjectMapperBuilder.json().build();

    @Override
    public String serialize(Command command) {
        try {
            return mapper.writeValueAsString(command);
        }catch (JsonProcessingException e){
            throw new SerialiserException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public Command deserialize(String command) {
        try {
            return mapper.readValue(command, Command.class);
        }catch (JsonProcessingException e){
            throw new SerialiserException(e.getMessage(), e.getCause());
        }
    }
}
