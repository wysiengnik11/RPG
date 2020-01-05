package rpg.model;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

/**
 * Class for holding map information
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
class Level extends Colliding {

	/** TileD Map */
	private Map map = null;

	/** Default constructor */
	public Level() {
		super();
	}
	/**
	 * Constructs a map with an image attached
	 *
	 * @param ref Reference path to TileD map file
	 */
	public Level(String ref) throws SlickException {
		map = new Map(ref);
	}
	/**
	 * Constructs a map with an image
	 * Sets position
	 *
	 * @param ref Reference path to TileD map file
	 * @param position Vector2f position
	 */
	public Level(String ref, int[] position) throws SlickException {
		this(ref);
		setPosition(position);
	}
	/**
	 * Constructs a map with an image
	 * Sets position
	 *
	 * @param ref Reference path to TileD map file
	 * @param x X coordinate
	 * @param y Y coordinate
	 */
	public Level(String ref, int x, int y) throws SlickException {
		this(ref);
		this.setPosition(x,y);
	}
	public Level(Map map, int x, int y) {
		this.map = map;
		this.setPosition(x,y);
	}
	/**
	 * Copy constructor
	 *
	 * @param other Object being copied
	 */
	public Level(Level other) {
		this(other.getMap(),other.getX(),other.getY());
		this.setBoundingBox(other.getBoundingBox());
	}
	/**
	 * Returns the TileD map of the level
	 *
	 * @return TiledMap
	 */
	public Map getMap() {
		return map;
	}
	/**
	 * Sets the map to a TileD map referenced by ref
	 *
	 * @param ref Reference path to TileD map file
	 */
	public void setMapImage(String ref) throws SlickException {
		map = new Map(ref);
	}
}
