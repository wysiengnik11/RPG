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
	/*-------------------------------------------------------------- Misc Settings  --------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/** Name of the settings save file */
	public String saveName = "Saved settings.sav";
	/**
	 * Path where the settings save file is located
	 * When string is empty the save location is in the "RPG" folder
	 */
	public String savePath = "";
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/*------------------------------------------------------------- Window Settings  -------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	public int windowWidth = 640;
	public int windowHeight = 480;
	/**
	 * Target frame rate, used to also set maximum logic update interval
	 */
	public int targetFPS = 60;
	/**
	 * Display FPS
	 */
	public boolean showFPS = false;
	public boolean fullscreen = false;
	/**
	 * Always render == false - the game won't run out of focus
	 */
	public boolean alwaysRender = true;
	public boolean vsync = true;
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/*-------------------------------------------------------------- Sound Settings --------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	public boolean soundOn = true;
	public boolean musicOn = true;
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/
	/*-------------------------------------------------------------- Game Settings  --------------------------------------------------------------*/
	/*--------------------------------------------------------------------------------------------------------------------------------------------*/

}