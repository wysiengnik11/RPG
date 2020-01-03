package rpg.model;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class Map extends TiledMap implements TileBasedMap {

	private int blockingLayerId;

	public Map(String ref, int blockingLayerId) throws SlickException {
		super(ref);
		this.blockingLayerId = blockingLayerId;
	}

	@Override
	public int getWidthInTiles() {
		return getWidth();
	}

	@Override
	public int getHeightInTiles() {
		return getHeight();
	}

	@Override
	public void pathFinderVisited(int x, int y) {

	}

	@Override
	public boolean blocked(PathFindingContext context, int tx, int ty) {
		return getTileId(tx,ty,blockingLayerId) != 0;
	}

	@Override
	public float getCost(PathFindingContext context, int tx, int ty) {
		return 1.f;
	}
}
