package first_rpg_allslick;

import java.io.File;

import first_rpg_allslick.model.Settings;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

	/** name of the game */
	private static final String gameName = "tests_and_whatnot.RPG";

	/** states */
	public static final int mainMenu = 0;
	public static final int play = 1;

	/**
	 * Create a new state based game
	 *
	 * @param name The name of the game
	 */
	public Game(String name) {
		super(name);
		this.addState(new MainMenu(mainMenu));
		this.addState(new Play(play));
	}

	/**
	 * Initialise the list of states making up this game
	 *
	 * @param container The container holding the game
	 * @throws SlickException Indicates a failure to initialise the state based game resources
	 */
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(mainMenu).init(container , this);
		this.getState(play).init(container , this);

		this.enterState(mainMenu);
	}

	public static void main(String[] args) {

		// sets natives library for lwjgl and slick
		File JGLLib = new File("build/resources/main/natives");
		System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());
		Settings settings = new Settings();

		try {
			AppGameContainer container = new AppGameContainer(new Game(gameName));
			container.setDisplayMode(Settings.Window.WIDTH, Settings.Window.HEIGHT, Settings.Window.FULLSCREEN);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}