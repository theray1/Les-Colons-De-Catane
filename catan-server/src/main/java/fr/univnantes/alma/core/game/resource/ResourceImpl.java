package fr.univnantes.alma.core.game.resource;

public class ResourceImpl implements Resource {
	private final Resources type;

	public ResourceImpl(Resources type) {
		this.type = type;
	}

	public ResourceImpl(Resource resource) {
		this.type = resource.getType();
	}

	@Override
	public Resources getType() {
		return this.type;
	}

}