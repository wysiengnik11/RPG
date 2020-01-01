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

	/**
	 * Detects which way the velocity is pointing and sets current animation accordingly
	 * Down and up directions are inverted due to
	 */
	private void detectDirection() {
		double theta = getVelocity().getTheta();
		if(getVelocity().length() <= 1)
			setCurrentAnimation(IDLE);
		else if(theta >= 225 && theta <= 315 )
			setCurrentAnimation(UP);
		else if(theta >= 135 && theta <= 225)
			setCurrentAnimation(LEFT);
		else if(theta >= 45 && theta <= 135)
			setCurrentAnimation(DOWN);
		else if(theta >= 315 && theta <= 45 )
			setCurrentAnimation(RIGHT);
	}
}
