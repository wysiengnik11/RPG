package rpgV2.model;

import org.newdawn.slick.Animation;

class AnimatedItem extends Item {

	protected Animation animation;

	@Override
	void terminate(Tile tile) {
		tile.remove(this);
	}

	@Override
	void terminate(Player player) {
		player.removeItem(this);
	}

}
