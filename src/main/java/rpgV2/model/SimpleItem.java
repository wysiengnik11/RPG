package rpgV2.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;

class SimpleItem extends Item {

	/** Image to be displayed when the item's on the ground or in inventory */
	Image image;

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
	public Renderable getRenderable() {
		return image;
	}
}
