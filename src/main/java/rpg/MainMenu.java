package rpg;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import rpg.model.Settings;

public class MainMenu extends BasicGameState {
	/** State's ID */
	private int ID;

	public MainMenu(int ID) {
		this.ID = ID;
	}

	@Override
	public int getID() {
		return ID;
	}

	public void init(GameContainer container, Game game) throws SlickException {
		Settings settings = game.getModel().getSettings();
		container.setMaximumLogicUpdateInterval(1000 / settings.targetFPS);
		container.setTargetFrameRate(settings.targetFPS);
		container.setAlwaysRender(settings.alwaysRender);
		container.setShowFPS(settings.showFPS);
		container.setVSync(settings.vsync);
		container.setUpdateOnlyWhenVisible(!settings.alwaysRender);
		container.setFullscreen(settings.fullscreen);
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
