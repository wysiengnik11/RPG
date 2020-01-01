package rpg.model;

import org.newdawn.slick.Image;

public class StaticImageEntity extends Entity {

	/** The image to be displayed */
	private Image image = null;
	/** Empty constructor */
	public StaticImageEntity() {}

	/**
	 * Constructor with provided image
	 *
	 * @param image image to be set as this object's image
	 */
	public StaticImageEntity(Image image) {
		this.image = image;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
