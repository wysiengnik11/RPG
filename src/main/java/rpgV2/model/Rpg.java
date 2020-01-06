package rpgV2.model;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;

public class Rpg {

	public Settings settings = new Settings();

	private Level level = null;
	private int currentLevel = 0;

	Player player = null;
	Tile playerTile = null;

	public void init() throws SlickException {
//		level = new Level(settings.savePath + "Level" + currentLevel + "/level" + currentLevel + ".tmx",settings);
		level = new Level("D:\\RPG\\src\\test\\resources\\desert.tmx",settings);
		level.getTile(5,5).addItem(new SimpleItem("D:\\RPG\\build\\resources\\main\\images\\ded.png"));
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

	public void getTestShape(Graphics g){level.getTestShape(g);}

	public void getRenderable(ArrayList<Renderable> rs, ArrayList<int[]> pos) {
		for (Tile t:
		     level.tiles) {
			rs.addAll(t.getRenderables());
			pos.addAll(t.getRenderablesPos());
		}

	}
}
