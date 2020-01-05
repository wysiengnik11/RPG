package rpgV2.model;

public class BlockingEntity extends Entity {

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
}
