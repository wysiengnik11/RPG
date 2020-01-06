package rpgV2.model;

import java.util.ArrayList;

public class Player extends Mob {

	private ArrayList<Item> items = new ArrayList<>();
	private int equippedItemID;

	protected void addItem(Item item) {
		items.add(item);
	}

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

	void removeItem(Item item) {
		items.remove(item);
	}
}
