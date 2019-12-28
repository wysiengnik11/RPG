package StateBasedGame_from_a_tutorial.model;

/**
 * settings for the game
 */
public class Settings {
	/** window settings */
	static public class Window {
		static public boolean FULLSCREEN = false;
		static public int HEIGHT = 640;
		static public int WIDTH = 640;
		/** whether or not the window will render if out of focus */
		static public boolean alwaysRender = true;
		static public boolean showFPS = false;
		static public boolean vsync = true;
		/** target framerate for the window */
		static public int targetFramerate = 60;
	}
	/** game settings */
	static class Game {

	}
}