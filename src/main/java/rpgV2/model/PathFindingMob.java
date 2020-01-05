package rpgV2.model;

import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.Path;

class PathFindingMob extends Mob implements Mover {

	/** Target tile for the path finding */
	protected Tile target;
	/** Path the mob will take */
	private Path path;
	/** Current step on the mob's path */
	private int step = 0;
	/** Indicates target has changed and new path needs to be found */
	private boolean findPath = false;

	@Override
	void update(int delta, Tile tile, Level level) {
		if(findPath)
			findPath(tile,level);

		// if the mob is not moving and hasn't reached it's target, move it
		if(!moving && !tile.equals(target)){
			Tile nextTile = level.getTile(path.getX(step), path.getY(step));
			move(tile,nextTile);
		}
		// if the mob is moving add delta to time elapsed since it started moving
		else if(moving) {
			timeMoving += delta;
			// if the time spent moving reaches the time for one move the moving stops
			if (timeMoving >= 1000 / speed)
				moving = false;
		}
	}

	@Override
	boolean moveFailed() {
		--step;
		moving = false;
		return false;
	}

	@Override
	void terminate(Tile tile) {
		tile.remove(this);
	}

	/**
	 * Set target tile
	 *
	 * @param target Tile to set as this mob's target
	 */
	void setTarget(Tile target) {
		this.target = target;
		findPath = true;
	}

	/**
	 * Finds path to target tile and resets findPath flag and step counter
	 *
	 * @param tile Current tile
	 * @param level Level for AStarPathfinder
	 */
	void findPath(Tile tile, Level level) {
		path = level.pathFinder.findPath(this, tile.getX(), tile.getY(), target.getX(), target.getY());
		findPath = false;
		step = 0;
	}

	/**
	 * @see Mob
	 */
	@Override
	void move(Tile currentTile, Tile nextTile) {
		++step;
		super.move(currentTile, nextTile);
	}
}
