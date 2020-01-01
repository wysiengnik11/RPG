package tests_and_whatnot;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;

import java.io.File;

class VectorTesting extends BasicGame {

	Vector2f v = null;
	int d = 0;

	/**
	 * Create a new basic game
	 *
	 * @param title The title for the game
	 */
	public VectorTesting(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		v = new Vector2f(1,0);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if(d>2000 && d<4000)
			v = new Vector2f(0,-1);
		if(d>4000 && d<6000)
			v = new Vector2f(-1,0);
		if(d>6000 && d<8000)
			v = new Vector2f(0,1);
		if(d>8000){
			d = 0;
			v = new Vector2f(1,0);
		}
		d+=delta;
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.drawString("Current theta = " + v.getTheta(), 10,10);
	}

	public static void main(String[] args) {

		File JGLLib = new File("build/resources/main/_natives");
		if(JGLLib.exists()) System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

		try {
			AppGameContainer app = new AppGameContainer(new VectorTesting("Vector test"));
			app.setDisplayMode(640,480,false);
			app.setShowFPS(false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
