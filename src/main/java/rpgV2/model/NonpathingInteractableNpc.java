package rpgV2.model;

import java.util.Properties;

public class NonpathingInteractableNpc extends Mob implements Interactable {

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
}
