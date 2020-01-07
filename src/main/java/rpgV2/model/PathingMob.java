package rpgV2.model;

import org.newdawn.slick.Renderable;
import org.newdawn.slick.util.pathfinding.Path;

class PathingMob extends Mob {

	/** Path the mob will take */
	protected Path path;
	/** Current step on the mob's path */
	protected int step = 0;

	@Override
	void update(int delta, Tile tile, Level level) {
		// if the mob is not moving and hasn't reached it's target, move it
		if(!moving){
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
	 * @see Mob
	 */
	@Override
	void move(Tile currentTile, Tile nextTile) {
		int xDir = currentTile.getX() - nextTile.getX();
		int yDir = currentTile.getY() - nextTile.getY();

		if(xDir < 0)
			facing = Tile.RIGHT;
		else if(xDir > 0)
			facing = Tile.LEFT;
		else if(yDir < 0)
			facing = Tile.UP;
		else
			facing = Tile.DOWN;

		++step;
		super.move(currentTile, nextTile);
	}

	@Override
	public Renderable getRenderable() {
		return null;
	}
}
