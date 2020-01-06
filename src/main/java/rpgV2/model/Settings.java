package rpgV2.model;

import java.io.*;

/**
 * Settings for the game
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
public class Settings implements Serializable {
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/*-------------------------------------------------------------- Misc Settings  --------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/** Name of the settings save file */
	public String saveName = "settings.save";
	/**
	 * Path where the settings save file is located
	 * When string is empty the save location is in the "RPG" folder (probably)
	 */
	public String savePath = "D:/RPG/";
	/**
	 * A flag used to display a card during initial loading notifying of a save import fail
	 */
	public boolean failedToImport = true;
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/*------------------------------------------------------------- Window Settings  -------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/***/
	public int windowWidth = 640;
	/***/
	public int windowHeight = 480;
	/** Target frame rate, used to also set maximum logic update interval */
	public int targetFPS = 60;
	/**
	 * Display FPS
	 */
	public boolean showFPS = false;
	/***/
	public boolean fullscreen = false;
	/** alwaysRender == false - the game won't run out of focus */
	public boolean alwaysRender = true;
	/***/
	public boolean vsync = true;
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/*-------------------------------------------------------------- Sound Settings --------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/***/
	public boolean soundOn = true;
	/***/
	public float soundLevel = 1;
	/***/
	public boolean musicOn = true;
	/***/
	public float musicLevel = 1;
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/*-------------------------------------------------------------- Game Settings  --------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/** Max search distance for A* path finding algorithm */
	public int maxSearchDistance = 100;

	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/*----------------------------------------------------------------- Methods  -----------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/

	/**
	 * Method for saving this instance of settings into a file
	 */
	public void saveSettings() {
		try {
			File file = new File(savePath);
			file = new File(file, "save");
			if(!file.exists())
				file.mkdir();
			file = new File(file, saveName);

			FileOutputStream out = new FileOutputStream(file);
			ObjectOutputStream save = new ObjectOutputStream(out);
			save.writeObject(this);
			save.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Static method for importing settings from a file
	 * If the import fails the return object is initialized to default
	 *
	 * @return Settings object
	 */
	public static Settings importSettings() {
		Settings settings = new Settings();
		try {
			File file = new File(settings.savePath);
			file = new File(file, "save");
			file = new File(file, settings.saveName);

			if(file.exists()) {
				FileInputStream in = new FileInputStream(file);
				ObjectInputStream save = new ObjectInputStream(in);
				settings = (Settings) save.readObject();
				settings.failedToImport = false;
				save.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return settings;
	}
}