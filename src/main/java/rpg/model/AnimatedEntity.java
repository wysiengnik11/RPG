package rpg.model;

import org.newdawn.slick.Animation;

import java.util.ArrayList;
import java.util.Collections;

public class AnimatedEntity extends Entity {

	private Animation currentAnimation = null;

	private ArrayList<Animation> animations = null;

	public AnimatedEntity() {}
	public AnimatedEntity(Animation[] animations) {
		Collections.addAll(this.animations = new ArrayList<>(), animations);
		currentAnimation = this.animations.get(0);
	}
	public AnimatedEntity(ArrayList<Animation> animations) {
		this.animations = animations;
		currentAnimation = this.animations.get(0);
	}

	public void setCurrentAnimation(int i) {
		currentAnimation = animations.get(i);
	}

	public Animation getCurrentAnimation() {
		return currentAnimation;
	}

}
