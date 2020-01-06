package rpgV2.model;

class Npc extends PathFindingMob {



	@Override
	void update(int delta, Tile tile, Level level) {
		super.update(delta,tile,level);
	}

	@Override
	boolean moveFailed() {
		return super.moveFailed();
	}

	@Override
	void terminate(Tile tile) {
		super.terminate(tile);
	}
}
