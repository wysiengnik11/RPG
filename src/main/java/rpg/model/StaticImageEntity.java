package rpg.model;

import org.newdawn.slick.Image;

public class StaticImageEntity extends Entity {

	private Image image = null;
	public StaticImageEntity() {}
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
