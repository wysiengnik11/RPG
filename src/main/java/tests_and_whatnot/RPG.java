package tests_and_whatnot;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class RPG extends BasicGame
{
	public RPG(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawString("Howdy!", 10, 10);
	}

	public static void main(String[] args)
	{
		try
		{
			File JGLLib = new File("build/resources/main/slick2d-natives");
			System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

			AppGameContainer appgc;
			appgc = new AppGameContainer(new RPG("Simple Slick Game"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(RPG.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}