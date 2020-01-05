package rpgV2.model;

import java.util.ArrayList;

public class Player extends Mob {

	private ArrayList<Item> items;
	private int equippedItemID;

	@Override
	void update(int delta, Tile tile, Level level) {

	}

	@Override
	boolean moveFailed() {
		return false;
	}

	@Override
	void terminate(Tile tile) {
		//TODO game over
	}

}
