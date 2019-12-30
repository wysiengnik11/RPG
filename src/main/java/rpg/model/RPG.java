package rpg.model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import java.io.*;
import java.util.ArrayList;

/**
 * Main game model class
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
public class RPG {

	/** Game settings */
	private Settings settings;

	/** Map of the current level */
	private Level level = new Level();

	/** Player character */
	private Player player = new Player();

	/** Movable static image entities */
	private ArrayList<StaticImageEntity> staticImageEntities = new ArrayList<>();

	/** Movable animated entities */
	private ArrayList<AnimatedEntity> animatedEntities = new ArrayList<>();

	/** Default constructor */
	public RPG(){
		settings = new Settings();
	}

	/**
	 * Constructor taking in path to saved settings file
	 * If the file does not exist default settings are created
	 * If the file fails to load TODO inform about import failure
	 *
	 * @param settingsPath Path to saved settings file
	 */
	public RPG(String settingsPath) {
		// Check if file exists
		if(new File(settingsPath).exists()) {
			if(!importSettings()) {
				System.out.println("FIle found");
				// TODO inform about import failure
				settings = new Settings();
			}
		}
		else {
			settings = new Settings();
		}
	}

	/** Initialize the game */
	public void init() {
		try {
			level.setMapImage(new Image("build/resources/main/Play/Levels/floor_0/map.png"));

		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Function used by controller to get images to draw
	 */
	public void getImages(ArrayList<Image> images, ArrayList<Vector2f> vectors) {
		images.clear();
		vectors.clear();
		images.add(level.getMapImage());
		vectors.add(level.getPosition());
		for (StaticImageEntity entity:
				staticImageEntities) {
			images.add(entity.getImage());
			vectors.add(entity.getPosition());
		}
	}

	/**
	 * Function used by controller to get animations to draw
	 */
	public void getAnimations(ArrayList<Animation> animations, ArrayList<Vector2f> vectors) {
		animations.clear();
		vectors.clear();
		for (AnimatedEntity entity:
		     animatedEntities) {
			animations.add(entity.getCurrentAnimation());
			vectors.add(entity.getPosition());
		}
	}

	/**
	 * Settings saving method
	 *
	 * @return Returns true if save was successful, false otherwise
	 */
	public boolean saveSettings() {
		try {
			FileOutputStream out = new FileOutputStream(settings.savePath + settings.saveName);
			ObjectOutputStream save = new ObjectOutputStream(out);
			save.writeObject(settings);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Settings importing method
	 * Does not check if file exists
	 *
	 * @return Returns true if import was successful, false otherwise
	 */
	public boolean importSettings() {
		try {
			File f = new File(settings.savePath + settings.saveName);
			if(f.exists()) {
				FileInputStream inp = new FileInputStream(settings.savePath + settings.saveName);
				ObjectInputStream save = new ObjectInputStream(inp);
				settings = (Settings) save.readObject();
			}
			else return false;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void update(int delta) {
		player.update(delta);

	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}
}