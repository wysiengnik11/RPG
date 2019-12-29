package rpg;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import rpg.model.RPG;
import rpg.model.Settings;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class GameBasic extends BasicGame {

	private static final String title = "RPG on BasicGame";

	/** Game model */
	private RPG model;

	/**
	 * Create a new basic game
	 *
	 * @param title The title for the game
	 */
	public GameBasic(String title) {
		super(title);
		this.model = new RPG();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		model.importSettings();
		Settings settings = model.getSettings();
		container.setMaximumLogicUpdateInterval(1000 / settings.targetFPS);
		container.setTargetFrameRate(settings.targetFPS);
		container.setAlwaysRender(settings.alwaysRender);
		container.setShowFPS(settings.showFPS);
		container.setVSync(settings.vsync);
		container.setUpdateOnlyWhenVisible(!settings.alwaysRender);
		container.setFullscreen(settings.fullscreen);
		model.init();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		ArrayList<Image> images = new ArrayList<>();
		ArrayList<Vector2f> vectors = new ArrayList<>();
		model.getImages(images,vectors);

		Iterator<Image> oi = images.iterator();
		Iterator<Vector2f> vi = vectors.iterator();
		while(oi.hasNext()) {
			Vector2f nextVector = vi.next();
			Image img = oi.next();
			g.drawImage(img,nextVector.getX(),nextVector.getY());
		}
	}

	public static void main(String[] args) {

		// sets natives library for lwjgl and slick
		File JGLLib = new File("build/resources/main/natives");
		System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

		try {
			AppGameContainer container = new AppGameContainer(new GameBasic(title));
			container.setDisplayMode(640,480,false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
