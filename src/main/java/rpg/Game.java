package rpg;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;

/**
 * A simple rpg game for collage
 * I am yet to decide what the story is going to be
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
public class Game extends StateBasedGame {

	/** game's title */
	private static final String title = "RPG";
	/** menu game state ID */
	public static final int menu = 0;
	/** main game state ID */
	public static final int play = 1;

	/**
	 * Create a new state based game
	 *
	 * @param name The name of the game
	 */
	public Game(String name) {
		super(name);
	}

	/**
	 * Initialise the list of states making up this game
	 *
	 * @param container The container holding the game
	 * @throws SlickException Indicates a failure to initialise the state based game resources
	 */
	@Override
	public void initStatesList(GameContainer container) throws SlickException {

	}

	public static void main(String[] args) {

		// sets natives library for lwjgl and slick
		File JGLLib = new File("build/resources/main/natives");
		System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

		try {
			AppGameContainer container = new AppGameContainer(new Game(title));
			container.setDisplayMode(640,480,false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
