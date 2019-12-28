package rpg.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

/**
 * Class for holding map information
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
class Level extends Colliding {

	/** Map image */
	private Image mapImage = null;

	/** Default constructor */
	public Level() {
		super();
	}
	/**
	 * Constructs a map with an image attached
	 *
	 * @param mapImage Map image
	 */
	public Level(Image mapImage) {
		this(mapImage, false);
	}
	/**
	 * Constructs a map with an image and may set the collision to a basic rectangle around the image
	 *
	 * @param mapImage Map image
	 * @param setRectangleCollision If true, sets collision to a basic rectangle around the image
	 */
	public Level(Image mapImage, boolean setRectangleCollision) {
		super();
		if(setRectangleCollision)
			setBoundingBox(new Rectangle(0,0, mapImage.getWidth(), mapImage.getHeight()));
		this.mapImage = mapImage;
	}
	/**
	 * Constructs a map with an image
	 * Sets position
	 *
	 * @param mapImage Map image
	 * @param position Vector2f position
	 */
	public Level(Image mapImage, Vector2f position) {
		this(mapImage);
		setPosition(position);
	}
	/**
	 * Constructs a map with an image and sets collision of the map to a basic rectangle around the image
	 * Sets position
	 *
	 * @param mapImage Map image
	 * @param setRectangleCollision If true, sets collision to a basic rectangle around the image
	 * @param position Vector2f position
	 */
	public Level(Image mapImage, boolean setRectangleCollision, Vector2f position) {
		this(mapImage, setRectangleCollision);
		setPosition(position);
	}
	/**
	 * Constructs a map with an image
	 * Sets position
	 *
	 * @param mapImage Map image
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Level(Image mapImage, float x, float y) {
		this(mapImage, true,x,y);
	}
	/**
	 * Constructs a map with an image and may set the collision of the map to a basic rectangle around the image
	 * Sets position
	 *
	 * @param mapImage Map image
	 * @param setRectangleCollision If true, sets collision of the map to a basic rectangle around the image
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Level(Image mapImage, boolean setRectangleCollision, float x, float y) {
		this(mapImage, setRectangleCollision);
		this.setPosition(x,y);
	}
	/**
	 * Copy constructor
	 *
	 * @param other Object being copied
	 */
	public Level(Level other) {
		this(other.getMapImage(), false, other.getX(), other.getY());
		this.setBoundingBox(other.getBoundingBox());
	}
	/**
	 * Returns the map image
	 *
	 * @return Map image
	 */
	public Image getMapImage() {
		return mapImage;
	}
	/**
	 * Sets the map's image to image
	 *
	 * @param mapImage Image to set map's image to
	 */
	public void setMapImage(Image mapImage) {
		this.mapImage = mapImage;
	}
}
