package first_rpg_allslick;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import static first_rpg_allslick.model.Settings.Window.*;

public class MainMenu extends BasicGameState {

	/**
	 * state ID
	 */
	private int stateID;

	Image playNow;
	Image exitGame;

	boolean test = false;
	Image outlier;
	private String mouse = "No input yet";
//	int outlierX = 200;
//	int outlierY = 200;
	private String overImage = "";

	public MainMenu(int stateID) { this.stateID = stateID; }

	/**
	 * Get the ID of this state
	 *
	 * @return The game unique ID of this state
	 */
	@Override
	public int getID() { return stateID; }

	/**
	 * Initialise the state. It should load any resources it needs at this stage
	 *
	 * @param container The container holding the game
	 * @param game      The game holding this state
	 * @throws SlickException Indicates a failure to initialise a resource for this state
	 */
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		container.setMaximumLogicUpdateInterval(1000 / targetFramerate);
		container.setTargetFrameRate(targetFramerate);
		container.setAlwaysRender(alwaysRender);
		container.setShowFPS(showFPS);
		container.setVSync(vsync);

		outlier = new Image("build/resources/main/images/outlier.png");

		playNow = new Image("build/resources/main/images/PLay_now.png");
		exitGame = new Image("build/resources/main/images/exit.png");
	}

	/**
	 * Render this state to the game's graphics context
	 *
	 * @param container The container holding the game
	 * @param game      The game holding this state
	 * @param g         The graphics context to render to
	 * @throws SlickException Indicates a failure to render an artifact
	 */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.drawString(mouse, 50, 50);
//		g.fillOval(75, 100, 100, 100);
//		g.drawString("Play now!", 80, 70);
		g.drawString(overImage, 50,10);
//		g.drawImage(outlier, outlierX, outlierY);

		playNow.draw(100,100);
		exitGame.draw(100,200);

		if(test){ g.drawImage(outlier,300,100);}
	}

	/**
	 * Update the state's logic based on the amount of time thats passed
	 *
	 * @param container The container holding the game
	 * @param game      The game holding this state
	 * @param delta     The amount of time thats passed in millisecond since last update
	 * @throws SlickException Indicates an internal error that will be reported through the
	 *                        standard framework mechanism
	 */
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		mouse = "Mouse position x: " + xpos + " y: " + ypos;
		Input input = container.getInput();
//		if (input.isKeyDown(Input.KEY_UP)) { outlierY -= 2; }
//		if (input.isKeyDown(Input.KEY_DOWN)) { outlierY += 2; }
//		if (input.isKeyDown(Input.KEY_LEFT)) { outlierX -= 2; }
//		if (input.isKeyDown(Input.KEY_RIGHT)) { outlierX += 2; }
//
//		if((xpos > 75 && xpos < 175) && (ypos > 280 && ypos < 380)) {
//			overImage = "Mouse over image";
//			if(input.isMouseButtonDown(0)){
//				game.enterState(1);
//			}
//		}
//		else
//			overImage = "Mouse not over image";

//		Play now! button
		if( ( xpos > 100 && xpos < 100+playNow.getWidth() ) && ( ypos > HEIGHT-100-playNow.getHeight() && ypos < HEIGHT-100) ){
			if(Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON)){
				game.enterState(1);
			}
		}
//      Exit button
		if( ( xpos > 100 && xpos < 100+exitGame.getWidth() ) && ( ypos > HEIGHT-200-exitGame.getHeight() && ypos < HEIGHT-200) ){
			if(Mouse.isButtonDown(Input.MOUSE_LEFT_BUTTON))
				System.exit(0);
		}
		if(input.isKeyDown(Input.KEY_ENTER)){
			game.enterState(1);
		}
	}

}