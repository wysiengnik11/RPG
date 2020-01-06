package rpgV2.model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Renderable;

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

	@Override
	Renderable getRenderable() {
		return null;
	}

}
