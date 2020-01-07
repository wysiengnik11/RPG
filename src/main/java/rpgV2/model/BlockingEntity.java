package rpgV2.model;

import org.newdawn.slick.Renderable;

public class BlockingEntity extends Entity {

	BlockingEntity() {
		properties.put("Blocking", true);
	}

	@Override
	void update(int delta, Tile tile, Level level) {
		if(!tile.isBlocked())
			tile.setBlocked(true);
	}

	@Override
	boolean moveFailed() {
		return false;
	}

	@Override
	void terminate(Tile tile) {
		tile.setBlocked(false);
		tile.remove(this);
	}

	@Override
	public Renderable getRenderable() {
		return null;
	}
}
