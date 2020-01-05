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
		model.getSettings().windowHeight = 640;
		Settings settings = model.getSettings();
//		container.setMaximumLogicUpdateInterval(1000 / settings.targetFPS);
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
		model.update(delta);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		/*
		// Get and check images and vectors from the model
		ArrayList<Image> images = new ArrayList<>();
		ArrayList<Vector2f> vectors = new ArrayList<>();
		model.getImages(images,vectors);
		if(images.size() != vectors.size())
			throw new SlickException("Mismatched Image and Vector lists for render");
		// Iterate over the images and draw them according to their position vectors
		Iterator<Vector2f> vi = vectors.iterator();
		for (Image img:
		     images) {
			Vector2f v = vi.next();
			img.draw(v.x,v.y);
		}

		// Get and check animations and vectors from the model
		ArrayList<Animation> animations = new ArrayList<>();
		vectors.clear();
		model.getAnimations(animations, vectors);
		if(animations.size() != vectors.size())
			throw new SlickException("Mismatched Animation and Vector lists for render");
		// Iterate over the animations and draw them according to their position vectors
		vi = vectors.iterator();
		for (Animation anim:
				animations) {
			Vector2f v = vi.next();
			anim.draw(v.x,v.y);
		}
		g.drawString(model.getString(),10,10);
		*/
	}

	public static void main(String[] args) {

		// sets natives library for lwjgl and slick
		File JGLLib = new File("build/resources/main/_natives");
		System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

		GameBasic game = new GameBasic(title);
		game.model.importSettings();
		game.model.getSettings().windowHeight = 640;

		try {
			AppGameContainer container = new AppGameContainer(game);
			container.setDisplayMode(game.model.getSettings().windowWidth,game.model.getSettings().windowHeight,game.model.getSettings().fullscreen);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
