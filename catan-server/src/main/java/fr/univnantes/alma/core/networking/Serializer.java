package fr.univnantes.alma.core.networking;

import fr.univnantes.alma.core.commands.Command;

public interface Serializer<T> {
    T serialize(Command command) throws SerialiserException;
    Command deserialize(T command) throws SerialiserException;
}
