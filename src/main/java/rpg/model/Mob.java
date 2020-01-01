package rpg.model;

import org.newdawn.slick.Animation;

import java.util.ArrayList;

class Mob extends AnimatedEntity {
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
	static final int DEATH = 5;

	/** Default constructor */
	Mob() {}
	Mob(Animation[] animations) {
		super(animations);
	}
	Mob(ArrayList<Animation> animations) {
		super(animations);
	}

	void tempupdate() {
			this.setVelocity(this.getVelocity().add(90.d));
	}

	@Override
	public void update(int delta) {
		super.update(delta);
		detectDirection();
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
		else if(theta >= 315.f || theta <= 45.f)
			setCurrentAnimation(RIGHT);
	}
}
