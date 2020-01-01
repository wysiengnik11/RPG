package rpg.model;

import org.junit.Test;
import org.newdawn.slick.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class StaticImageEntityTest {

	private class TestEngine extends BasicGame{

		int delta = 0;
		int testCase;

		/**
		 * Create a new basic game
		 *
		 * @param title The title for the game
		 */
		public TestEngine(String title, int testCase) {
			super(title);
			this.testCase = testCase;
		}

		@Override
		public void init(GameContainer container) throws SlickException {

			if(testCase == 0) {
				Image img = new Image("build/resources/test/outlier.png");
				StaticImageEntity entity = new StaticImageEntity(img);
				assertEquals(img, entity.getImage());

			} else if (testCase == 1) {
				Image img = new Image("build/resources/test/outlier.png");
				StaticImageEntity entity = new StaticImageEntity();
				entity.setImage(img);
				assertEquals(img, entity.getImage());
			}
		}

		@Override
		public void update(GameContainer container, int delta) throws SlickException {
			container.exit();
		}

		@Override
		public void render(GameContainer container, Graphics g) throws SlickException {
		}
	}

	@Test
	public void getImage() {
//		File JGLLib = new File("build/resources/main/_natives");
//		System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());
//
//		try {
//			AppGameContainer app = new AppGameContainer(new TestEngine("test engine", 0));
//			app.setDisplayMode(10,10,false);
//			app.start();
//		} catch (SlickException e) {
//			e.printStackTrace();
//		}
	}

	@Test
	public void setImage() {
//		File JGLLib = new File("build/resources/main/_natives");
//		System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());
//
//		try {
//			AppGameContainer app = new AppGameContainer(new TestEngine("test engine", 1));
//			app.setDisplayMode(10,10,false);
//			app.start();
//		} catch (SlickException e) {
//			e.printStackTrace();
//		}
	}
}