package rpgV2.model;

import org.newdawn.slick.Renderable;

import java.util.Properties;

class NonpathingInteractableNpc extends Mob implements Interactable {

	protected String name;
	protected Properties dialog;

	NonpathingInteractableNpc(String name, Properties dialog) {
		this.name = name;
		this.dialog = dialog;
	}

	@Override
	public void interact() {

	}

	@Override
	void update(int delta, Tile tile, Level level) {

	}

	@Override
	boolean moveFailed() {
		return false;
	}

	@Override
	void terminate(Tile tile) {

	}

	@Override
	public Renderable getRenderable() {
		return null;
	}
}
