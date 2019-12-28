package rpg.model;

import java.io.Serializable;

/**
 * Settings for the game
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
public class Settings implements Serializable {
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/*------------------------------------------------------------- Window Settings  -------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/** Name of the settings save file */
	public String saveName = "Saved settings.sav";
	/**
	 * Path where the settings save file is located
	 * When string is empty the save location is in the "RPG" folder
	 */
	public String savePath = "";
	/**
	 * Width of the window
	 */
	public int windowWidth = 640;
	/**
	 * Height of the window
	 */
	public int windowHeight = 480;
	/**
	 * Target frame rate
	 */
	public int targetFPS = 60;
	/**
	 * Display FPS
	 */
	public boolean showFPS = false;
	/**
	 * Fullscreen mode
	 */
	public boolean fullscreen = false;
	/**
	 * Always render
	 */
	public boolean alwaysRender = true;
	/**
	 * V-Sync
	 */
	public boolean vsync = true;

	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/*-------------------------------------------------------------- Game Settings  --------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/

}