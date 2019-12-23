package tests_and_whatnot;

import org.newdawn.slick.*;
import org.newdawn.slick.command.*;

import java.io.File;

public class Engine extends BasicGame implements InputProviderListener {

	private Command vsync = new BasicCommand("V-Sync");
	private Command fps = new BasicCommand("FPS");
	private boolean VSync = true;
	private boolean VSyncUpdate = false;
	private boolean ShowFPS = false;
	private boolean fpsUpdate = false;
	private String vsyncMessage = "V-Sync on";
	private String message = "";
	private InputProvider provider;

	public Engine() {
		super("title");
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		container.setMaximumLogicUpdateInterval(60);
		container.setTargetFrameRate(60);
		container.setAlwaysRender(true);
		container.setShowFPS(ShowFPS);
		container.setVSync(VSync);

		provider = new InputProvider(container.getInput());
		provider.addListener(this);

		provider.bindCommand(new KeyControl(Input.KEY_V), vsync);
		provider.bindCommand(new KeyControl(Input.KEY_F), fps);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {

		boolean reInnit = false;
		if(VSyncUpdate) {
			container.setVSync(VSync);
			VSyncUpdate = false;
			reInnit = true;
		}
		if(fpsUpdate) {
			container.setShowFPS(ShowFPS);
			fpsUpdate = false;
			reInnit = true;
		}
		if(reInnit) {
			container.reinit();
		}

		g.drawString("Press V to enable/disable V-Sync",10,50);
		g.drawString("Press F to enable/disable FPS display",10,100);
		g.drawString(message, 10, 200);
		g.drawString(vsyncMessage,100,250);
	}

	@Override
	public void controlPressed(Command command) {
		message = "Pressed "+command;

		if(command.equals(vsync)) {
			VSync = !VSync;
			if(VSync) vsyncMessage = "V-Sync on";
			else vsyncMessage = "V-Sync off";
			VSyncUpdate = true;
		}
		else if(command.equals(fps)) {
			ShowFPS = !ShowFPS;
			fpsUpdate = true;
		}
	}

	@Override
	public void controlReleased(Command command) {

	}

	public static void main(String[] args) {
		File JGLLib = new File("build/resources/main/slick2d-natives");
		if(JGLLib.exists()) System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

		try {
			AppGameContainer game = new AppGameContainer(new Engine());
			game.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
			game.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}