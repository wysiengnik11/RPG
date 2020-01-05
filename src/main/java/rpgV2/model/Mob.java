package rpgV2.model;

abstract class Mob {

	/***/
	protected int health;
	/** Speed at which the mob moves between tiles in tiles per second */
	protected float speed;
	/** Indicates the mob is moving and shouldn't take other actions */
	protected boolean moving = false;
	/** Time elapsed since moving started */
	protected int timeMoving = 0;

	void takeDamage(int damage) {
		health -= damage;
	}

	abstract void update(int delta, Tile tile, Level level);

	abstract boolean moveFailed();

	abstract void terminate(Tile tile);

	/**
	 * Move the mob to another tile
	 *
	 * @param currentTile Currently occupied tile
	 * @param nextTile Tile to move to
	 */
	void move(Tile currentTile, Tile nextTile) {
		moving = true;
		currentTile.moveMob(nextTile);
	}
}
