package tests_and_whatnot;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

import java.io.File;


public class AStarTest {

	private static final int MAX_PATH_LENGTH = 100;

	private static final int START_X = 1;
	private static final int START_Y = 1;

	private static final int GOAL_X = 1;
	private static final int GOAL_Y = 6;

	public static void main(String[] args) {

		File JGLLib = new File("build/resources/main/_natives");
		if(JGLLib.exists()) System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

		SimpleMap map = new SimpleMap();

		AStarPathFinder pathFinder = new AStarPathFinder(map, MAX_PATH_LENGTH, false);
		Path path = pathFinder.findPath(null, START_X, START_Y, GOAL_X, GOAL_Y);

		int length = path.getLength();
		System.out.println("Found path of length: " + length + ".");

		for(int i = 0; i < length; i++) {
			System.out.println("Move to: " + path.getX(i) + "," + path.getY(i) + ".");
		}

		try {
			AppGameContainer a = new AppGameContainer(new TestEngine("test",0));
			a.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
			a.setShowFPS(false);
			a.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

}

class TestEngine extends BasicGame {

	private int testCase;
	private LayerBasedMap map;
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
		if(testCase == 0){
			map = new LayerBasedMap(new TiledMap("D:\\RPG\\src\\test\\resources\\desert.tmx"),2);
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {

		AStarPathFinder pathFinder = new AStarPathFinder(map, 100, false);
		Path path = pathFinder.findPath(null, 8, 17, 8, 24);

		int length = path.getLength();
		System.out.println("Found path of length: " + length + ".");

		for(int i = 0; i < length; i++) {
			System.out.println("Move to: " + path.getX(i) + "," + path.getY(i) + ".");
		}
		container.exit();
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {

	}
}

class SimpleMap implements TileBasedMap {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 10;

	private static final int[][] MAP = {
			{1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,1,1,1,1},
			{1,0,1,1,1,0,1,1,1,1},
			{1,0,1,1,1,0,0,0,1,1},
			{1,0,0,0,1,1,1,0,1,1},
			{1,1,1,0,1,1,1,0,0,0},
			{1,0,1,0,0,0,0,0,1,0},
			{1,0,1,1,1,1,1,1,1,0},
			{1,0,0,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,1,1,0}
	};

	@Override
	public boolean blocked(PathFindingContext ctx, int x, int y) {
		return MAP[y][x] != 0;
	}

	@Override
	public float getCost(PathFindingContext ctx, int x, int y) {
		return 1.0f;
	}

	@Override
	public int getHeightInTiles() {
		return HEIGHT;
	}

	@Override
	public int getWidthInTiles() {
		return WIDTH;
	}

	@Override
	public void pathFinderVisited(int x, int y) {}

}

class LayerBasedMap implements TileBasedMap {

	private TiledMap map;
	private int blockingLayerId;

	public LayerBasedMap(TiledMap map, int blockingLayerId) {
		this.map = map;
		this.blockingLayerId = blockingLayerId;
	}

	@Override
	public boolean blocked(PathFindingContext ctx, int x, int y) {
		return map.getTileId(x, y, blockingLayerId) != 0;
	}

	@Override
	public float getCost(PathFindingContext ctx, int x, int y) {
		return 1.0f;
	}

	@Override
	public int getHeightInTiles() {
		return map.getHeight();
	}

	@Override
	public int getWidthInTiles() {
		return map.getWidth();
	}

	@Override
	public void pathFinderVisited(int arg0, int arg1) {}

}