package rpg.model;

import java.io.Serializable;

/**
 * Settings for the game
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
class Settings implements Serializable {
	/** Name of the settings save file */
	public String saveName = "Saved settings.sav";
	/**
	 * Path where the settings save file is located
	 * When string is empty the save location is in the "RPG" folder
	 */
	public String savePath = "";

	private int windowWidth = 640;
	private int windowHeight = 480;
	private boolean showFPS = false;

	public int getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}

	public boolean isShowFPS() {
		return showFPS;
	}

	public void setShowFPS(boolean showFPS) {
		this.showFPS = showFPS;
	}

}