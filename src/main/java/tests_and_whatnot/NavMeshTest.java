package tests_and_whatnot;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.TileBasedMap;
import org.newdawn.slick.util.pathfinding.navmesh.NavMesh;
import org.newdawn.slick.util.pathfinding.navmesh.NavMeshBuilder;
import org.newdawn.slick.util.pathfinding.navmesh.NavPath;

import java.io.File;

class NavMeshTest extends BasicGame {

	/**
	 * Create a new basic game
	 *
	 * @param title The title for the game
	 */
	public NavMeshTest(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		TileBasedMap map = new SimpleMap();
		NavMeshBuilder builder = new NavMeshBuilder();
		NavMesh mesh = builder.build(map);
		NavPath path = mesh.findPath(1,1,1,6,true);

		System.out.println("Found path of length: " + path.length() + ".");
		while(path.length() != 0){
			System.out.println("Move to: " + path.getX(0) + "," + path.getY(0) + ".");
			path.remove(0);
		}

		// these lower tests fail to provide satisfying results

		map = new LayerBasedMap(new TiledMap("D:\\RPG\\src\\test\\resources\\desert.tmx"),0);

		mesh = builder.build(map);
		path = mesh.findPath(8, 14, 8, 20,true);

		System.out.println("Found path of length: " + path.length() + ".");
		while(path.length() != 0){
			System.out.println("Move to: " + path.getX(0) + "," + path.getY(0) + ".");
			path.remove(0);
		}

		map = new PropertyBasedMap(new TiledMap("D:\\RPG\\src\\test\\resources\\desert.tmx"), "Blocking");

		mesh = builder.build(map);
		path = mesh.findPath(8, 14, 8, 20,true);

		System.out.println("Found path of length: " + path.length() + ".");
		while(path.length() != 0){
			System.out.println("Move to: " + path.getX(0) + "," + path.getY(0) + ".");
			path.remove(0);
		}

		container.exit();
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {

	}

	public static void main(String[] args) {

		File JGLLib = new File("build/resources/main/_natives");
		if(JGLLib.exists()) System.setProperty("org.lwjgl.librarypath", JGLLib.getAbsolutePath());


		try {
			AppGameContainer a = new AppGameContainer(new NavMeshTest("NavMesh test"));
			a.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
			a.setShowFPS(false);
			a.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
