package rpgV2.model;

import org.newdawn.slick.Renderable;

/**
 * Interface for classes that have objects implementing openGL Renderable interface,
 * and thus can be drawn on screen really easily
 */
interface Drawable {

	/**
	 * This function is intended to return Renderable object currently used by the object implementing Drawable
	 * This can return for instance an Image class image, an Animation class animation and so on
	 * This function is intended to be used by objects immediately ON the Tile class tiles and NOWHERE else,
	 * as it would create problems with for example items in player inventory.
	 * Thus it will be called ONLY by Tile objects
	 *
	 * @return Object to be drawn on screen
	 */
	Renderable getRenderable();
}
