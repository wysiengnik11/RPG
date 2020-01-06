package rpgV2.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;

class SimpleItem extends Item {

	protected Image image;

	SimpleItem(String ref) throws SlickException {
		properties.put("Renderable", true);
		image = new Image(ref);
	}

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
		return image;
	}

}
