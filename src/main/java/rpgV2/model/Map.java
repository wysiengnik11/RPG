package rpgV2.model;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class Map extends TiledMap {

	/** Id of the layer used for path finding */
	private int blockingLayerID;
	/** Tile offset ing pixels used to determine draw placements */
	private int[] tileOffset;

	/**
	 * Constructor matching super of TiledMap
	 * Also sets blockingLayerID based on Blocking property of the blocking layer
	 * (Blocking layer has to have a custom property called "Blocking" set to true for this to work)
	 *
	 * @see TiledMap
	 */
	Map(String ref) throws SlickException {
		super(ref);
		for(int i = this.getLayerCount() - 1; i >= 0; --i ) {
			if(this.getLayerProperty(i,"Blocking","false").equals("true")) {
				blockingLayerID = i;
				i = -1;
			}
		}
		tileOffset = new int[]{tileWidth, tileHeight};
	}

	int getBlockingLayerID() {
		return blockingLayerID;
	}

	int getXOffset() {
		return tileOffset[0];
	}

	int getYOffset() {
		return tileOffset[1];
	}

	int[] getTileOffset() {
		return tileOffset;
	}

}
