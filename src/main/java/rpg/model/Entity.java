package rpg.model;

import org.newdawn.slick.geom.Vector2f;

class Entity extends Colliding {

	/**
	 * Velocity of the entity
	 * By default set to <0,0>
	 */
	private Vector2f velocity = new Vector2f(0,0);

	Entity(){
		super();
	}

	/**
	 * Method for updating position of the object according to it's velocity and time since last update
	 */
	public void update(int delta) {
		setPosition( getPosition().add( velocity.getTheta() * delta ));
	}

	public Vector2f getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}

}
