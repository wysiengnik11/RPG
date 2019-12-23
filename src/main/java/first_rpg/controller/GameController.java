package first_rpg.controller;

import first_rpg.view.View;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface GameController {

	/**
	 * Initialise the game. This can be used to load static resources. It's called
	 * before the game loop starts
	 *
	 * @param view The controller holding the game
	 * @throws SlickException Throw to indicate an internal error
	 */
	public void init(View view) throws SlickException;

	/**
	 * Update the game logic here. No rendering should take place in this method
	 * though it won't do any harm.
	 *
	 * @param view The controller holing this game
	 * @param delta The amount of time thats passed since last update in milliseconds
	 * @throws SlickException Throw to indicate an internal error
	 */
	public void update(View view, int delta) throws SlickException;

	/**
	 * Render the game's screen here.
	 *
	 * @param view The controller holing this game
	 * @param g The graphics context that can be used to render. However, normal rendering
	 * routines can also be used.
	 * @throws SlickException Throw to indicate a internal error
	 */
	public void render(View view, Graphics g) throws SlickException;

	/**
	 * Notification that a game close has been requested
	 *
	 * @return True if the game should close
	 */
	public boolean closeRequested();

	/**
	 * Get the title of this game
	 *
	 * @return The title of the game
	 */
	public String getTitle();

}
