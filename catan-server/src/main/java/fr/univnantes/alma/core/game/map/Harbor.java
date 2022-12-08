package fr.univnantes.alma.core.game.map;

import java.util.Collection;

import fr.univnantes.alma.core.game.resource.Resource;

public interface Harbor {
	public Collection<Resource> getRequireResources();

	public Collection<Resource> getGivenResources();
}