package rpg;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import rpg.model.Settings;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Main menu game state
 * Probably not gonna use
 */
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
		game.getModel().init();
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
	}

//	public void render(GameContainer container, Game game, Graphics g) throws SlickException {
//		//TODO get the bloody thing to render something
//		ArrayList<Image> images = new ArrayList<>();
//		ArrayList<Vector2f> vectors = new ArrayList<>();
//		game.getModel().getImages(images,vectors);
//
//		Iterator<Image> oi = images.iterator();
//		Iterator<Vector2f> vi = vectors.iterator();
//		while(oi.hasNext()) {
//			Vector2f nextVector = vi.next();
//			Image img = oi.next();
//			g.drawImage(img,nextVector.getX(),nextVector.getY());
//		}
//		g.drawString("I'm in",5,5);
//	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

	}
}
