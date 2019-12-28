package rpg.model;

import java.io.*;

/**
 * Main game model class
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
public class RPG {

	/** Map of the game */
	private Level level;

	/** Player character */
	private Player player;

	/** Game settings */
	private Settings settings;

	/** Default constructor */
	public RPG(){
		level = new Level();
		player = new Player();
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
		level = new Level();
		player = new Player();
		// Check if file exists
		if(new File(settingsPath).exists()) {
			if(!importSettings()) {
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
	 * @return  Returns true if import was successful, false otherwise
	 */
	public boolean importSettings() {
		try {
			FileInputStream inp = new FileInputStream(settings.savePath + settings.saveName);
			ObjectInputStream save = new ObjectInputStream(inp);
			settings = (Settings) save.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
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
//	public static void main(String[] args) {
//		System.out.println("Main started");
//		RPG game = new RPG();
//		System.out.println("Before: " + game.settings.getWindowHeight() + " " + game.settings.isShowFPS());
//		if(!game.saveSettings())
//			System.out.println("FAK - Export");
//		else {
//			System.out.println("Saved");
//		}
//
//		game.settings.setShowFPS(true);
//		game.settings.setWindowHeight(200);
//		System.out.println("Changed: " + game.settings.getWindowHeight() + " " + game.settings.isShowFPS());
//
//		if(!game.importSettings("Saved settings.sav"))
//			System.out.println("FAK - Import");
//		else {
//			System.out.println("Imported");
//			System.out.println("After: " + game.settings.getWindowHeight() + " " + game.settings.isShowFPS());
//		}
//	}
}