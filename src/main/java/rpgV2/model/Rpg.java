package rpgV2.model;

import org.newdawn.slick.SlickException;

public class Rpg {

	public Settings settings = new Settings();

	private Level level = null;
	protected int currentLevel = 0;

	Player player = null;
	Tile playerTile = null;

	public void init() throws SlickException {
//		level = new Level(settings.savePath + "Level" + currentLevel + "/level" + currentLevel + ".tmx",settings);
		level = new Level("D:\\RPG\\src\\test\\resources\\desert.tmx",settings);
		player = new Player();
		playerTile = null;
		settings.saveSettings();
	}

	public void update(int delta) {
		level.update(delta);
	}

	public void movePlayer(int direction) throws SlickException {
		playerTile.moveMob(playerTile.getConnected(direction));
		playerTile = playerTile.getConnected(direction);
	}

	public Map getMap() {
		return level.map;
	}
}
