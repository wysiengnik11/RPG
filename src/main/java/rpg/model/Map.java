package rpg.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

/**
 * Class for holding map information
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
class Map extends Colliding {
	/** Map image */
	private Image image = null;

	/** Default constructor */
	public Map() {
		super();
	}
	public Map(Image image) {
		this(image, true);
	}
	public Map(Image image, boolean setRectangleCollision) {
		super();
		if(setRectangleCollision)
			setBoundingBox(new Rectangle(0,0, image.getWidth(), image.getHeight()));
		this.image = image;
	}
	public Map(Image image, float x, float y) {
		this(image, true,x,y);
	}
	public Map(Image image, boolean setCollision, float x, float y) {
		this(image, setCollision);
		this.setX(x);
		this.setY(y);
	}
	/**
	 * Copy constructor
	 *
	 * @param other Object being copied
	 */
	public Map(Map other) {
		this(other.getImage(), other.hasBoundingBox(), other.getX(), other.getY());
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
