package rpg;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Play-time game state
 * Probably not gonna use
 */
public class Play extends BasicGameState {
	/** State's ID */
	private int ID;

	public Play(int ID) {
		this.ID = ID;
	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

	}
}
