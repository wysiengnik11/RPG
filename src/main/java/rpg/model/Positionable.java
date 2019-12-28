package rpg.model;

import org.newdawn.slick.geom.Vector2f;

/**
 * This class holds position of an object from top left corner of the screen
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
class Positionable {
	private Vector2f position = null;

	/** Default constructor */
	public Positionable() {}
	/**
	 * Constructor taking position
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Positionable(float x, float y) {
		this.position = new Vector2f(x,y);
	}
	public Positionable(Vector2f position) {
		this.position = position.copy();
	}
	/**
	 * Copy constructor
	 * @param other Object being copied
	 */
	public Positionable(final Positionable other) {
		this.position = other.getPosition();
	}

	public float getX() {
		return position.x;
	}

	public void setX(float x) {
		position.x = x;
	}

	public float getY() {
		return position.y;
	}

	public void setY(float y) {
		position.y = y;
	}

	public void setPosition(float x, float y) {
		this.position = new Vector2f(x,y);
	}
	public void setPosition(Vector2f position) {
		this.position = position.copy();
	}
	public Vector2f getPosition() {
		return new Vector2f(position);
	}
}