package rpg.model;

import org.newdawn.slick.Animation;

import java.util.ArrayList;
import java.util.Collections;

class AnimatedEntity extends Entity {

	/** Currently used animation */
	private Animation currentAnimation = null;

	/** Array list of all object's animations */
	private ArrayList<Animation> animations = null;

	/** Default constructor */
	public AnimatedEntity() {}

	/**
	 * Creates the object out of an array of animations
	 *
	 * @param animations An array of animations to make the list
	 */
	public AnimatedEntity(Animation[] animations) {
		Collections.addAll(this.animations = new ArrayList<>(), animations);
		currentAnimation = this.animations.get(0);
	}

	/**
	 * Creates the object out of a list of animations
	 *
	 * @param animations List of animations to be used by this object
	 */
	public AnimatedEntity(ArrayList<Animation> animations) {
		this.animations = animations;
		currentAnimation = this.animations.get(0);
	}

	/**
	 * Sets currently used animation
	 *
	 * @param i Animation number in the animations list
	 */
	public void setCurrentAnimation(int i) {
		currentAnimation.stop();
		currentAnimation = animations.get(i);
		currentAnimation.start();
	}

	/**
	 * Returns currently used animation
	 *
	 * @return Currently used animation
	 */
	public Animation getCurrentAnimation() {
		return currentAnimation;
	}

}
