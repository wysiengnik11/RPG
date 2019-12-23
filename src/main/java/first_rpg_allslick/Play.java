package first_rpg_allslick;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import static first_rpg_allslick.model.Settings.Window.*;

/**
 * play game state
 */
public class Play extends BasicGameState {

	/** state ID */
	private int stateID;

	Animation player, movingUp, movingDown, movingLeft, movingRight;
	Image worldMap;
	boolean quit = false;
	int[] duration = { 200, 200 };
	float playerPositionX = 0;
	float playerPositionY = 0;
	float shiftX = playerPositionX + (float)WIDTH/2;
	float shiftY = playerPositionY + (float)HEIGHT/2;

	public Play(int stateID) { this.stateID = stateID; }

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
	 * @param game The game holding this state
	 * @throws SlickException Indicates a failure to initialise a resource for this state
	 */
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		worldMap = new Image("build/resources/main/images/map.png");
		Image[] walkUp = {new Image("build/resources/main/images/back.png"), new Image("build/resources/main/images/back.png")};
		Image[] walkDown = {new Image("build/resources/main/images/front.png"), new Image("build/resources/main/images/front.png")};
		Image[] walkLeft = {new Image("build/resources/main/images/left.png"), new Image("build/resources/main/images/left.png")};
		Image[] walkRight = {new Image("build/resources/main/images/right.png"), new Image("build/resources/main/images/right.png")};
		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		player = movingDown;
	}

	/**
	 * Render this state to the game's graphics context
	 *
	 * @param container The container holding the game
	 * @param game The game holding this state
	 * @param g The graphics context to render to
	 * @throws SlickException Indicates a failure to render an artifact
	 */
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		worldMap.draw(-playerPositionX, playerPositionY);
		player.draw(shiftX, shiftY);
		g.drawString("Players X: " + playerPositionX + "\nPlayers Y: " + playerPositionY, 400, 20);

		if(quit){
			g.clear();
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 200);
			g.drawString("Quit (Q)", 250, 300);
			if(!quit)
				g.clear();
		}
	}

	/**
	 * Update the state's logic based on the amount of time thats passed
	 *
	 * @param container The container holding the game
	 * @param game The game holding this state
	 * @param delta The amount of time thats passed in millisecond since last update
	 * @throws SlickException Indicates an internal error that will be reported through the
	 * standard framework mechanism
	 */
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		Input input = container.getInput();

		//up
		if(input.isKeyDown(Input.KEY_UP)) {
			player = movingUp;
			playerPositionY += delta*.2f;
			if(playerPositionY > (float)worldMap.getHeight()/2)
				playerPositionY -= delta*.2f;
		}
		//down
		if(input.isKeyDown(Input.KEY_DOWN)) {
			player = movingDown;
			playerPositionY -= delta*.2f;
			if(playerPositionY < -(float)worldMap.getHeight()/2 + player.getHeight())
				playerPositionY += delta*.2f;
		}
		//left
		if(input.isKeyDown(Input.KEY_LEFT)) {
			player = movingLeft;
			playerPositionX -= delta*.2f;
			if(playerPositionX < -(float)worldMap.getWidth()/2)
				playerPositionX += delta*.2f;
		}
		//right
		if(input.isKeyDown(Input.KEY_RIGHT)) {
			player = movingRight;
			playerPositionX += delta*.2f;
			if(playerPositionX > (float)worldMap.getWidth()/2 - player.getWidth())
				playerPositionX -= delta*.2f;
		}
		//escape
		if(input.isKeyDown(Input.KEY_ESCAPE)) {
			quit = true;
		}
		//menu up
		if(quit){
			if(input.isKeyDown(Input.KEY_R)) { quit = false; }
			if(input.isKeyDown(Input.KEY_M)) { game.enterState(0); }
			if(input.isKeyDown(Input.KEY_Q)) { System.exit(0); }
		}
	}
}
