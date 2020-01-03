package rpg.model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.util.pathfinding.Mover;

import java.util.ArrayList;

class Mob extends AnimatedEntity implements Mover {
	/** Idle animation id number in animations list */
	static final int IDLE = 0;
	/** Down animation id number in animations list */
	static final int DOWN = 1;
	/** Left animation id number in animations list */
	static final int LEFT = 2;
	/** Up animation id number in animations list */
	static final int UP = 3;
	/** Right animation id number in animations list */
	static final int RIGHT = 4;
	/** Death animation id number in animations list */
	static final int DYING = 5;
	/** Idle dead animation id number in animations list */
	static final int DEAD = 6;
	/** Indicates the mob has died and appropriate animations need to be played */
	private boolean dead = false;

	/** Default constructor */
	Mob() {}
	/**
	 * @see AnimatedEntity
	 * @param animations Array of animations to use
	 */
	Mob(Animation[] animations) {
		super(animations);
	}
	/**
	 * @see AnimatedEntity
	 * @param animations Array list of animations to use
	 */
	Mob(ArrayList<Animation> animations) {
		super(animations);
	}

	void tempupdate() {
			this.setVelocity(this.getVelocity().add(90.d));
	}

	/**
	 * @see Entity
	 * @param delta Time since last update in milliseconds
	 */
	@Override
	public void update(int delta) {
		if(dead) {
			if (getCurrentAnimation().isStopped()) {
				setCurrentAnimation(DEAD);
			}
		}
		else {
			super.update(delta);
			detectDirection();
		}
	}

	/**
	 * Detects which way the velocity is pointing and sets current animation accordingly
	 * Down and up directions are inverted due to
	 */
	private void detectDirection() {
		double theta = getVelocity().getTheta();
		if(getVelocity().length() <= 1.f)
			setCurrentAnimation(IDLE);
		else if(theta > 225.f && theta < 315.f)
			setCurrentAnimation(UP);
		else if(theta >= 135.f && theta <= 225.f)
			setCurrentAnimation(LEFT);
		else if(theta > 45.f && theta < 135.f)
			setCurrentAnimation(DOWN);
		else if((theta >= 315.f && theta <=360) || (theta <= 45.f && theta >= 0))
			setCurrentAnimation(RIGHT);
	}

	public boolean isDead() {
		return dead;
	}

	/**
	 * Method for when the mob is killed
	 */
	void kill() {
		dead = true;
		setCurrentAnimation(DYING);
		getCurrentAnimation().setLooping(false);
	}
}
