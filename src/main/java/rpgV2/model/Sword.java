package rpgV2.model;

import org.newdawn.slick.SlickException;

public class Sword extends Weapon {

	Sword(String ref, int damage) throws SlickException {
		super(ref);
		properties.put("Sword", true);
		properties.put("Damage", damage);
	}

	@Override
	void attack(Tile tile) throws SlickException {
		Tile attacked = tile.getConnected(tile.getMob().facing);
		if(attacked.getMob() != null)
			attacked.getMob().takeDamage((int) properties.get("Damage"));
	}
}
