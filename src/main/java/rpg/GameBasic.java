package rpg;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;
import rpg.model.RPG;
import rpg.model.Settings;

import java.io.File;
import java.io.IOException;
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

//		model.update(delta);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// Get and check images and vectors from the model
		ArrayList<Image> images = new ArrayList<>();
		ArrayList<Vector2f> vectors = new ArrayList<>();
		model.getImages(images,vectors);
		if(images.size() != vectors.size())
			throw new SlickException("Mismatched Image and Vector lists for render");
		// Iterate over the images and draw them according to their position vectors
		Iterator<Image> oi = images.iterator();
		Iterator<Vector2f> vi = vectors.iterator();
		while(oi.hasNext()) {
			Vector2f nextVector = vi.next();
			Image img = oi.next();
			g.drawImage(img,nextVector.getX(),nextVector.getY());
		}
	}

	public static void main(String[] args) {

//		System.load("D:\\RPG\\build\\resources\\main\\_natives\\jinput-dx8_64.dll");
//		System.load("D:\\RPG\\build\\resources\\main\\_natives\\jinput-raw_64.dll");

		// sets natives library for lwjgl and slick
		File JGLLib = new File("build/resources/main/_natives");
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
