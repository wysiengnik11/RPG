package rpg.model;

import org.newdawn.slick.Image;

public class StaticImageEntity extends Entity {
	private Image image;
	public StaticImageEntity(Image image) {
		this.image = image;
	}
}
