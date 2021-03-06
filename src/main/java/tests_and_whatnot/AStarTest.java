package tests_and_whatnot;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

import java.io.File;

/**
 * Three tests of path finding with different maps and blocking systems
 */
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
			a.setDisplayMode(640, 640, false);
			a.setShowFPS(false);
			a.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

		try {
			AppGameContainer a = new AppGameContainer(new TestEngine("test",1));
			a.setDisplayMode(640, 640, false);
			a.setShowFPS(false);
			a.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}

class TestEngine extends BasicGame {

	private int testCase;
	private int delta = 0;
	TiledMap map;

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
		this.map = new TiledMap("D:\\RPG\\src\\test\\resources\\desert.tmx");
		TileBasedMap map;
		if(testCase == 0){
			map = new LayerBasedMap(this.map,1);
		}
		else {
			map = new PropertyBasedMap(this.map , "Blocking");
		}

		AStarPathFinder pathFinder = new AStarPathFinder(map, 100, false);
		Path path = pathFinder.findPath(null, 8, 14, 8, 20);

		int length = path.getLength();
		System.out.println("Found path of length: " + length + ".");

		for(int i = 0; i < length; i++) {
			System.out.println("Move to: " + path.getX(i) + "," + path.getY(i) + ".");
		}

	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if(this.delta > 2000){
			container.setForceExit(false);
			container.exit();
		}
		this.delta += delta;
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// this showed me blocking layer has to be underneath ground layer for the map to draw properly
		map.render(0,0);
	}
}

/**
 * Simple map with an array of blocked tiles
 */
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

/**
 * A map basing blocked tile detection on TileD maps Layer feature
 * Map would have a layer specifying which tiles are blocked
 */
class LayerBasedMap implements TileBasedMap {

	private TiledMap map;
	private int blockingLayerId;

	public LayerBasedMap(TiledMap map, int blockingLayerId) {
		this.map = map;
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

/**
 * A map basing blocked tile detection on TileD maps properties feature
 * The map would have a property for tiles that would be true for blocking tiles
 */
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