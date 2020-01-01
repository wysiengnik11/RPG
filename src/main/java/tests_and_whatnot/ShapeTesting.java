package tests_and_whatnot;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.io.File;

class ShapeTesting extends BasicGame {

	private Shape shape = null;
	private Shape shape2 = null;
	private boolean collides = false;

	/**
	 * Create a new basic game
	 *
	 * @param title The title for the game
	 */
	public ShapeTesting(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		float[] points = new float[]{0,0,0,200,200,200,200,0}; // Rectangle
//		float[] points = new float[]{50,50,70,85,100,80,115,40,85,40};
//		150,150,100,100
		shape = new Polygon(points);
		shape.setLocation(0,0);
		shape2 = new Circle(100,100,100);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		shape2.setCenterX(container.getInput().getMouseX());
		shape2.setCenterY(container.getInput().getMouseY());
		if(container.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
			shape.setLocation(0,0);

		collides = shape.intersects(shape2);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.setColor(new Color(255,0,0));
		g.draw(shape);
		g.setColor(new Color(255,255,255));
		g.drawString("Collides: " + collides,10,25);
		if(!collides)
			g.setColor(new Color(0xCCCCCC));
		else
			g.setColor(Color.blue);
		g.draw(shape2);
		g.fill(shape2);
	}

	public static void main(String[] args) {

		File JGLLib = new File("build/resources/main/_natives");
		if(JGLLib.exists()) System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

		try {
			AppGameContainer app = new AppGameContainer(new ShapeTesting("Shape test"));
			app.setDisplayMode(640,480,false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
