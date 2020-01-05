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
	public String saveName = "settings.sav";
	/**
	 * Path where the settings save file is located
	 * When string is empty the save location is in the "RPG" folder (probably)
	 */
	public String savePath = "";
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
			FileOutputStream out = new FileOutputStream(savePath + saveName);
			ObjectOutputStream save = new ObjectOutputStream(out);
			save.writeObject(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Static method for importing settings from a file into a provided settings object
	 *
	 * @param settings Settings object to be replaced by settings imported from the file
	 */
	public static void importSettings(Settings settings) {
		try {
			if (new File(settings.savePath + settings.saveName).exists()) {
				FileInputStream in = new FileInputStream(settings.savePath + settings.saveName);
				ObjectInputStream save = new ObjectInputStream(in);
				settings = (Settings) save.readObject();
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}