package rpg.model;

import org.newdawn.slick.geom.Shape;

/**
 * This class implements collision detection
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
public class Colliding extends Positionable {
	/** Bounding box shape used for detection */
	private Shape boundingBox = null;
	/**
	 * Default constructor
	 * @see Positionable
	 */
	public Colliding() { super(); }

	/**
	 * Constructor taking in shape for collision detection
	 * @param boundingBox Shape for collision detection
	 */
	public Colliding(Shape boundingBox) {
		super();
		this.boundingBox = boundingBox;
	}
	/**
	 * Constructor taking position
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Colliding(int x, int y) {
		super(x,y);
	}
	/**
	 * Constructor taking collision detection shape and position
	 * @param boundingBox Shape used for collision detection
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Colliding(Shape boundingBox, int x, int y) {
		super(x,y);
		this.boundingBox = boundingBox;
	}

	/**
	 * Copy constructor
	 * @param other Object being copied
	 */
	public Colliding(final Colliding other) {
		this(other.getBoundingBox(), other.getX(), other.getY());
	}

	/**
	 * Method for checking collision
	 * @param other An object being checked for collision
	 * @return Returns slick2d's Shape method intersects() or false if boundingBox is null
	 */
	public boolean isColliding(Colliding other) {
		if(hasBoundingBox()) {
			return this.getBoundingBox().intersects(other.getBoundingBox());
		}
		return false;
	}

	public Shape getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(Shape boundingBox) {
		this.boundingBox = boundingBox;
	}

	@Override
	public void setX(int x) {
		super.setX(x);
		if(hasBoundingBox())
			boundingBox.setX(x);
	}

	@Override
	public void setY(int y) {
		super.setY(y);
		if(hasBoundingBox())
			boundingBox.setY(y);
	}

	public boolean hasBoundingBox() {
		return boundingBox != null;
	}
}
