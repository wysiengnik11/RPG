package rpgV2;

import org.newdawn.slick.*;
import rpgV2.model.Rpg;
import rpgV2.model.Settings;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class Controller extends BasicGame {

	private static final String title = "Yet another try";
	private Rpg model;
	private boolean initiated = false;
	private boolean reinitWindow;

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
		if(!initiated) {
//			model.settings.showFPS = true;
//		    container.setMaximumLogicUpdateInterval(1000 / model.settings.targetFPS);
			container.setTargetFrameRate(model.settings.targetFPS);
			container.setAlwaysRender(model.settings.alwaysRender);
			container.setShowFPS(model.settings.showFPS);
			container.setVSync(model.settings.vsync);
			container.setUpdateOnlyWhenVisible(!model.settings.alwaysRender);
			container.setFullscreen(model.settings.fullscreen);
			model.init();
			initiated = true;
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if(reinitWindow) {
			container.setForceExit(false);
			container.exit();
		}
		model.update(delta);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		model.getMap().render(0,0, 0, 0, model.settings.windowWidth, model.settings.windowHeight, 0, false);

//		model.getTestShape(g);

		renderTiles();
		renderPlayer();
	}

	private void renderTiles() {
		// note: this approach requires that every sprite have the same dimensions as a map tile
		ArrayList<Renderable> rs = new ArrayList<>();
		rs.add(null);
		ArrayList<int[]> pos = new ArrayList<>();

		model.getRenderable(rs,pos);

		Iterator<int[]> i = pos.iterator();

		int[] p = new int[] {0,0};
		for (Renderable r:
				rs) {
			if(r == null) {
				if(i.hasNext())
					p = i.next();
			} else
				r.draw(p[0]*model.getMap().getXOffset(),p[1]*model.getMap().getYOffset());
		}
	}

	private void renderPlayer() {
	}

	public static void main(String[] args) {

		// sets natives library for lwjgl and slick
		File JGLLib = new File("build/resources/main/_natives");
		System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

		Controller game = new Controller(title);
		game.model.settings = Settings.importSettings();
		game.model.settings.windowWidth = 1088;
		game.model.settings.windowHeight = 800;

		do {
			game.reinitWindow = false;
			try {
				AppGameContainer container = new AppGameContainer(game);
				container.setDisplayMode(game.model.settings.windowWidth,game.model.settings.windowHeight,game.model.settings.fullscreen);
				container.start();
			} catch (SlickException e) {
				e.printStackTrace();
			}
		} while(game.reinitWindow);
	}
}
