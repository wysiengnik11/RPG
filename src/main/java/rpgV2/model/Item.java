package rpgV2.model;

import org.newdawn.slick.Renderable;

import java.io.Serializable;
import java.util.Properties;

abstract class Item implements Serializable {

	Properties properties = new Properties();

	void pickUp(Tile tile, Player player) {
		player.addItem(this);
		tile.remove(this);
	}

	abstract void terminate(Tile tile);
	abstract void terminate(Player player);

	abstract Renderable getRenderable();
}
