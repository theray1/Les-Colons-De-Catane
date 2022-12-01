package fr.univnantes.alma.core.commands;

public interface Serializer {
    String serialize(Command command);
    Command deSerializer(String commandAsString);
}
