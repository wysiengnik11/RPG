package tests_and_whatnot;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

import java.io.File;


class AStarTest {

	private static final int MAX_PATH_LENGTH = 100;

	public static void main(String[] args) {

		File JGLLib = new File("build/resources/main/_natives");
		if(JGLLib.exists()) System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());

		SimpleMap map = new SimpleMap();

		AStarPathFinder pathFinder = new AStarPathFinder(map, MAX_PATH_LENGTH, false);
		Path path = pathFinder.findPath(null, 1, 1, 1, 6);

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
			// this seems broken now
			// map is probably not working correctly
			a = new AppGameContainer(new TestEngine("test",1));
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
		TileBasedMap map;
		if(testCase == 0){
			map = new LayerBasedMap(new TiledMap("D:\\RPG\\src\\test\\resources\\desert.tmx"),0);
		}
		else {
			map = new PropertyBasedMap(new TiledMap("D:\\RPG\\src\\test\\resources\\desert.tmx"), "Blocking");
		}

		AStarPathFinder pathFinder = new AStarPathFinder(map, 100, false);
		Path path = pathFinder.findPath(null, 8, 14, 8, 20);

		int length = path.getLength();
		System.out.println("Found path of length: " + length + ".");

		for(int i = 0; i < length; i++) {
			System.out.println("Move to: " + path.getX(i) + "," + path.getY(i) + ".");
		}

		container.setForceExit(false);
		container.exit();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {

	}
}

class SimpleMap implements TileBasedMap {
	private static final int WIDTH = 10;
	private static final int HEIGHT = 10;

	private static final int[][] MAP = {
		//   0 1 2 3 4 5 6 7 8 9
	/*0*/   {1,1,1,1,1,1,1,1,1,1},
	/*1*/	{1,0,0,0,0,0,1,1,1,1},
	/*2*/	{1,0,1,1,1,0,1,1,1,1},
	/*3*/	{1,0,1,1,1,0,0,0,1,1},
	/*4*/	{1,0,0,0,1,1,1,0,1,1},
	/*5*/	{1,1,1,0,1,1,1,0,0,0},
	/*6*/	{1,0,1,0,0,0,0,0,1,0},
	/*7*/	{1,0,1,1,1,1,1,1,1,0},
	/*8*/	{1,0,0,0,0,0,0,0,0,0},
	/*9*/	{1,1,1,1,1,1,1,1,1,0}
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
		System.out.println(map.getLayerCount());
		this.blockingLayerId = blockingLayerId;
	}

	public int test() {
		return map.getLayerCount();
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

class PropertyBasedMap implements TileBasedMap {

	private TiledMap map;
	private String blockingPropertyName;

	public PropertyBasedMap(TiledMap map, String blockingPropertyName) {
		this.map = map;
		this.blockingPropertyName = blockingPropertyName;
	}

	@Override
	public boolean blocked(PathFindingContext ctx, int x, int y) {
		// NOTE: Using getTileProperty like this is slow. You should instead cache the results.
		// For example, set up a HashSet<Integer> that contains all of the blocking tile ids.
		return map.getTileProperty(map.getTileId(x, y, 0), blockingPropertyName, "false").equals("true");
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