package rpg.model;

import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * This class implements collision detection
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
class Colliding extends Positionable {
	/** Bounding box shape used for detection */
	private Shape boundingBox = null;
	/**
	 * Default constructor
	 * Does nothing for Colliding, default Positionable()
	 *
	 * @see Positionable
	 */
	public Colliding() { super(); }

	/**
	 * Constructor taking in shape for collision detection
	 *
	 * @param boundingBox Shape for collision detection
	 */
	public Colliding(Shape boundingBox) {
		super();
		this.boundingBox = boundingBox;
	}
	/**
	 * Constructor taking position
	 *
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Colliding(float x, float y) {
		super(x,y);
	}
	/**
	 * Constructor taking position
	 *
	 * @param position Vector2f position
	 */
	public Colliding(Vector2f position) {
		super(position);
	}
	/**
	 * Constructor taking collision detection shape and position
	 *
	 * @param boundingBox Shape used for collision detection
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Colliding(Shape boundingBox, float x, float y) {
		super(x,y);
		this.setBoundingBox(boundingBox);
	}
	/**
	 * Constructor taking collision detection shape and position
	 *
	 * @param boundingBox Shape used for collision detection
	 * @param position Vector2f position
	 */
	public Colliding(Shape boundingBox, Vector2f position) {
		super(position);
		this.setBoundingBox(boundingBox);
	}
	/**
	 * Constructor loading a shape from a file as a bounding box
	 *
	 * @param shapePath Path to the shape file (serializable)
	 */
	public Colliding(String shapePath) {
		super();
		try {
			FileInputStream inp = new FileInputStream(shapePath);
			ObjectInputStream save = new ObjectInputStream(inp);
			boundingBox = (Shape) save.readObject();
			boundingBox.setLocation(0,0);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Constructor loading a shape from a file as a bounding box
	 * Sets position to x and y
	 *
	 * @param shapePath Path to the shape file (Shape is serializable)
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Colliding(String shapePath, float x ,float y) {
		super(x,y);
		try {
			FileInputStream inp = new FileInputStream(shapePath);
			ObjectInputStream save = new ObjectInputStream(inp);
			boundingBox = (Shape) save.readObject();
			boundingBox.setLocation(x,y);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Constructor loading a shape from a file as a bounding box
	 * Sets position to Vector2f position
	 *
	 * @param shapePath Path to the shape file (Shape is serializable)
	 * @param position Vector2f position
	 */
	public Colliding(String shapePath, Vector2f position) {
		super(position);
		try {
			FileInputStream inp = new FileInputStream(shapePath);
			ObjectInputStream save = new ObjectInputStream(inp);
			boundingBox = (Shape) save.readObject();
			boundingBox.setLocation(position);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Copy constructor
	 *
	 * @param other Object being copied
	 */
	public Colliding(final Colliding other) {
		this(other.getBoundingBox(), other.getX(), other.getY());
	}
	/**
	 * Checks collision with Shape.intersects() method
	 * Works as expected with Polygon shape, does not with circle and rectangle, for which it works like collides method from this class
	 *
	 * @see Shape
	 * @param other An object being checked for collision
	 * @return Returns slick2d's Shape method intersects() or false if both objects' boundingBox's are null
	 */
	public boolean intersects(Colliding other) {
		if(hasBoundingBox() && other.hasBoundingBox()) {
			return this.getBoundingBox().intersects(other.getBoundingBox());
		}
		return false;
	}
	/**
	 * Checks collision with Shape.contains() method
	 * Works as expected with Polygon shape, does not with circle and rectangle, for which it's always false it seems
	 *
	 * @see Shape
	 * @param other An object being checked for collision
	 * @return Returns slick2d's Shape method contains() or false if both objects' boundingBox's are null
	 */
	public boolean contains(Colliding other) {
		if(hasBoundingBox() && other.hasBoundingBox()) {
			return this.getBoundingBox().contains(other.getBoundingBox());
		}
		return false;
	}
	/**
	 * Checks collision with both Shape.intersects() and Shape.contains() methods
	 *
	 * @see Shape
	 * @param other An object being checked for collision
	 * @return Returns true if either intersects or contains method would return true, or false if neither would or both objects' boundingBox's are null
	 */
	public boolean collides(Colliding other) {
		if (hasBoundingBox() && other.hasBoundingBox()) {
			return this.getBoundingBox().contains(other.getBoundingBox()) || this.getBoundingBox().intersects(other.getBoundingBox());
		}
		return false;
	}
	/**
	 * Get bounding box Shape used for collision detection
	 *
	 * @return Returns the bounding box Shape
	 */
	public Shape getBoundingBox() {
		return boundingBox;
	}
	/**
	 * Sets bounding box Shape for collision detection
	 * Sets bounding box Location to this object's
	 *
	 * @param boundingBox Shape to be set as the new bounding box
	 */
	public void setBoundingBox(Shape boundingBox) {
		this.boundingBox = boundingBox;
		this.boundingBox.setLocation(getX(),getY());
	}
	/**
	 * Sets bounding box Shape for collision detection
	 * Sets bounding box Location to this object's
	 *
	 * @param shapePath Path to the shape file (Shape is serializable)
	 */
	public void setBoundingBox(String shapePath) {
		try {
			FileInputStream inp = new FileInputStream(shapePath);
			ObjectInputStream save = new ObjectInputStream(inp);
			boundingBox = (Shape) save.readObject();
			boundingBox.setLocation(getX(),getY());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see Positionable
	 */
	@Override
	public void setX(float x) {
		super.setX(x);
		if(hasBoundingBox())
			boundingBox.setX(x);
	}
	/**
	 * @see Positionable
	 */
	@Override
	public void setY(float y) {
		super.setY(y);
		if(hasBoundingBox())
			boundingBox.setY(y);
	}
	/**
	 * Sets position
	 *
	 * @see Positionable
	 */
	@Override
	public void setPosition(float x, float y) {
		super.setPosition(x,y);
		if(hasBoundingBox())
			boundingBox.setLocation(x,y);
	}
	/**
	 * Sets position
	 *
	 * @see Positionable
	 * @param position Vector2f position
	 */
	@Override
	public void setPosition(Vector2f position) {
		super.setPosition(position);
		if(hasBoundingBox())
			boundingBox.setLocation(position);
	}
	/**
	 * Checks if the bounding box Shape is present
	 *
	 * @return true if boundingBox != null
	 */
	public boolean hasBoundingBox() {
		return boundingBox != null;
	}
}
