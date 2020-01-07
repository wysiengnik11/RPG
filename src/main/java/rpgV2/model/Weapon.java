package rpgV2.model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

abstract class Weapon extends SimpleItem {

	/**
	 * Animation played when attacking
	 * Passing this to rendering should be handled by owning object, as in mob or player
	 */
	Animation attackAnimation;
	/**
	 * Image intended to be displayed along with weapon's holder
	 * Passing this to rendering should be handled by owning object, as in mob or player
	 */
	Image idleImage;
	/** Indicates attack animation is playing */
	protected boolean attacking = false;

	Weapon(String ref) throws SlickException {
		super(ref);
		properties.put("Equipable", true);
		properties.put("Weapon", true);
	}

	/**
	 * Describes how exactly the weapon attacks
	 *
	 * @param tile Tile this weapon's holder is currently at
	 * @throws SlickException Thrown if there is a problem with connections between tiles
	 */
	abstract void attack(Tile tile) throws SlickException;

	void setAttackAnimation(Animation attackAnimation) {
		this.attackAnimation = attackAnimation;
		this.attackAnimation.setLooping(false);
		this.attackAnimation.setAutoUpdate(true);
	}

	void setIdleImage(Image idleImage) {
		this.idleImage = idleImage;
	}

}
