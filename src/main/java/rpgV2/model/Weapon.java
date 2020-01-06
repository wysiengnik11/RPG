package rpgV2.model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

abstract class Weapon extends SimpleItem {

	protected Animation attackAnimation;

	Weapon() {
		properties.put("Equipable", true);
		properties.put("Weapon", true);
	}

	abstract void attack(Tile tile) throws SlickException;
}
