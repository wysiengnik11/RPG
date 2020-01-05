package rpgV2.model;

import org.newdawn.slick.SlickException;

public class Rpg {

	public Settings settings = new Settings();

	private Level level = null;
	protected int currentLevel = 0;

	Player player = null;
	Tile playerTile = null;

	public void init() throws SlickException {
		level = new Level( settings.savePath + "/Level" + currentLevel + "/level" + currentLevel + ".tmx" , settings);
		player = new Player();
		playerTile = null;
	}

	public void update(int delta) {
		level.update(delta);
	}

	public void movePlayer(int direction) throws SlickException {
		playerTile.moveMob(playerTile.getConnected(direction));
		playerTile = playerTile.getConnected(direction);
	}
}
