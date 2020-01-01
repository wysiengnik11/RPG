package rpg.model;

import org.newdawn.slick.Animation;

import java.util.ArrayList;
import java.util.Collections;

class AnimatedEntity extends Entity {

	/** True if object is to be rendered and displayed */
	private boolean displayed = true;

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
		super();
		setAnimations(animations);
	}

	/**
	 * Creates the object out of a list of animations
	 *
	 * @param animations List of animations to be used by this object
	 */
	public AnimatedEntity(ArrayList<Animation> animations) {
		super();
		setAnimations(animations);
	}

	public void setAnimations(Animation[] animations) {
		Collections.addAll(this.animations = new ArrayList<>(), animations);
		currentAnimation = this.animations.get(0);
	}

	public void setAnimations(ArrayList<Animation> animations) {
		this.animations = animations;
		currentAnimation = this.animations.get(0);
	}

	public void addAnimation(Animation animation) {
		if(this.animations == null)
			this.animations = new ArrayList<>();
		this.animations.add(animation);
		if(this.currentAnimation == null)
			setCurrentAnimation(0);
	}

	public void addAnimation(int index, Animation animation) {
		if(this.animations == null)
			this.animations = new ArrayList<>();
		this.animations.add(index, animation);
		if(this.currentAnimation == null)
			setCurrentAnimation(0);
	}

	public void addAnimations(Animation[] animations) {
		if(this.animations == null)
			this.animations = new ArrayList<>();
		Collections.addAll(this.animations, animations);
		if(this.currentAnimation == null)
			setCurrentAnimation(0);
	}

	public void addAnimations(ArrayList<Animation> animations) {
		if(this.animations == null)
			this.animations = new ArrayList<>();
		this.animations.addAll(animations);
		if(this.currentAnimation == null)
			setCurrentAnimation(0);
	}

	/**
	 * Sets currently used animation
	 *
	 * @param i Animation number in the animations list
	 */
	public void setCurrentAnimation(int i) {
		if(currentAnimation == null)
			currentAnimation = new Animation();
		currentAnimation = animations.get(i);
	}

	/**
	 * Returns currently used animation
	 *
	 * @return Currently used animation
	 */
	public Animation getCurrentAnimation() {
		return currentAnimation;
	}

	public boolean isDisplayed() {
		return displayed;
	}
}
