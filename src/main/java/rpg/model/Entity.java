package rpg.model;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.pathfinding.Mover;

class Entity extends Colliding {

	/**
	 * Velocity of the entity
	 * By default set to <0,0>
	 */
	private Vector2f velocity = new Vector2f(0,0);

	public Entity(){}
	public Entity(Vector2f velocity) {
		this.velocity = velocity;
	}
	public Entity(Vector2f velocity, Vector2f position) {
		super(position);
		this.velocity = velocity;
	}
	public Entity(Vector2f velocity, float x, float y) {
		super(x,y);
		this.velocity = velocity;
	}
	public Entity(float xVel, float yVel, float x, float y) {
		super(x,y);
		this.velocity.set(xVel,yVel);
	}

	/**
	 * Method for updating position of the object according to it's velocity and time since last update
	 */
	public void update(int delta) {
		Vector2f posDelta = velocity.copy();
		posDelta.x *= delta/1000.f;
		posDelta.y *= delta/1000.f;
		setPosition(getPosition().add(posDelta));
	}

	public Vector2f getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}

}
