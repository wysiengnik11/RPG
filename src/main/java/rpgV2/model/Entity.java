package rpgV2.model;

import java.io.Serializable;

/**
 * Abstract class for entities that take actions when on a tile
 */
abstract class Entity implements Serializable {

	/**
	 * Update method for determining behavior
	 *
	 * @param delta Time since last update in milliseconds
	 * @param tile Tile this entity is on
	 * @param level Level (for path finding context)
	 */
	abstract void update(int delta, Tile tile, Level level);

	/**
	 * If entity tries to move to a different tile, but fails due to that tile being impassable
	 * This is supposed to return true if the entity ignores the impassable check,
	 *  or if it will modify the tile it terminates at
	 *  In that case some flag should be set to terminate at the next tile
	 *
	 * @return Return true if tile being impassable should be ignored
	 */
	abstract boolean moveFailed();

	/**
	 * Method called when an entity should terminate
	 *
	 * @param tile The tile entity is currently at
	 */
	abstract void terminate(Tile tile);
}
