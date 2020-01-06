package rpgV2.model;

import org.newdawn.slick.Image;

class SimpleItem extends Item {

	protected Image image;

	@Override
	void terminate(Tile tile) {
		tile.remove(this);
	}

	@Override
	void terminate(Player player) {
		player.removeItem(this);
	}

}
