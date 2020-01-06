package rpgV2;

import org.newdawn.slick.*;
import rpgV2.model.Rpg;
import rpgV2.model.Settings;

import java.io.File;

public class Controller extends BasicGame {

	private static final String title = "Yet another try";
	private Rpg model;

	/**
	 * Create a new basic game
	 *
	 * @param title The title for the game
	 */
	public Controller(String title) {
		super(title);
		this.model = new Rpg();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		model.init();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		model.getMap().render(0,0, 0, 0, model.settings.windowWidth, model.settings.windowHeight);
	}

	public static void main(String[] args) {

		// sets natives library for lwjgl and slick
		File JGLLib = new File("build/resources/main/_natives");
		System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

		Controller game = new Controller(title);
		game.model.settings = Settings.importSettings();

		try {
			AppGameContainer container = new AppGameContainer(game);
			container.setDisplayMode(game.model.settings.windowWidth,game.model.settings.windowHeight,game.model.settings.fullscreen);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
