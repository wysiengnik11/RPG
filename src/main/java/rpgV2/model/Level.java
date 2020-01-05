package rpgV2.model;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.pathfinding.AStarPathFinder;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

import java.util.ArrayList;

public class Level implements TileBasedMap {

	AStarPathFinder pathFinder;
	Map map;
	ArrayList<Tile> tiles = new ArrayList<>();

	Level(String ref, Settings settings) throws SlickException {
		map = new Map(ref);
		for(int y = 0; y < map.getHeight(); ++y)
			for(int x = 0; x < map.getWidth(); ++x) {
				Tile tile = new Tile(x,y);
				if(y > 0) {
					tile.connect(getTile(x,y-1), Tile.UP);
					getTile(x,y-1).connect(tile, Tile.DOWN);
				}
				if (x > 0) {
					tile.connect(getTile(x-1,y), Tile.LEFT);
					getTile(x-1,y).connect(tile, Tile.RIGHT);
				}
				if(map.getTileId(x,y,map.getBlockingLayerID()) != 0)
					tile.setBlocked(true);
				tiles.add(tile);
			}
		pathFinder = new AStarPathFinder(this, settings.maxSearchDistance, false);
	}

	Tile getTile(int x, int y) {
		return tiles.get(x + y*map.getWidth());
	}

	public void update(int delta) {
		for (Tile tile:
		     tiles) {
			tile.update(delta, this);
		}
	}

	@Override
	public int getWidthInTiles() {
		return map.getWidth();
	}

	@Override
	public int getHeightInTiles() {
		return map.getHeight();
	}

	@Override
	public void pathFinderVisited(int x, int y) {

	}

	@Override
	public boolean blocked(PathFindingContext context, int tx, int ty) {
		return getTile(tx,ty).isBlocked();
	}

	@Override
	public float getCost(PathFindingContext context, int tx, int ty) {
		return getTile(tx,ty).getMovementCost();
	}
}
