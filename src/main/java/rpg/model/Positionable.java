package rpg.model;

/**
 * This class holds position of an object from top left corner of the screen
 * The position is tile-based - it cannot be used to directly draw onto the screen
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
class Positionable {
	private int[] position = new int[] {0,0};

	/** Default constructor */
	public Positionable() {}
	/**
	 * Constructor taking position
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Positionable(int x, int y) {
		this.position = new int[]{x,y};
	}
	public Positionable(int[] position) {
		if(position.length == 2)
			this.position = position;
	}
	/**
	 * Copy constructor
	 * @param other Object being copied
	 */
	public Positionable(final Positionable other) {
		this.position = other.getPosition().clone();
	}

	public int getX() {
		return position[0];
	}

	public void setX(int x) {
			position[0] = x;
	}

	public int getY() {
		return position[1];
	}

	public void setY(int y) {
			position[1] = y;
	}

	public void setPosition(int x, int y) {
		this.position = new int[]{x,y};
	}
	public void setPosition(int[] position) {
		if(position.length == 2)
			this.position = position;
	}
	public int[] getPosition() {
		return position;
	}
}