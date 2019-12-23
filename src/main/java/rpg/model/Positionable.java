package rpg.model;

/**
 * This class holds position of an object from top left corner of the screen
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
class Positionable {
	/** X position */
	private int x;
	/** Y position */
	private int y;

	/** Default constructor */
	public Positionable() {
		this(0,0);
	}

	/**
	 * Constructor taking position
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Positionable(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * Copy constructor
	 * @param other Object being copied
	 */
	public Positionable(final Positionable other) {
		this.x = other.getX();
		this.y = other.getY();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}