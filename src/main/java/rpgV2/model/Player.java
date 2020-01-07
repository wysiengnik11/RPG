package rpgV2.model;

import org.newdawn.slick.Renderable;

import java.util.ArrayList;

class Player extends Mob {

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

	@Override
	public Renderable getRenderable() {
		return null;
	}

	void removeItem(Item item) {
		items.remove(item);
	}
}
