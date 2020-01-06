package rpgV2.model;

import org.newdawn.slick.util.pathfinding.Mover;

class PathFindingMob extends PathingMob implements Mover {

	/** Target tile for the path finding */
	protected Tile target;
	/** Indicates target has changed and new path needs to be found */
	private boolean findPath = false;

	@Override
	void update(int delta, Tile tile, Level level) {
		if(findPath) {
			findPath(tile,level);
		}
		if(!tile.equals(target))
			super.update(delta,tile,level);
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

}
