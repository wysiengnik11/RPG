package rpg.model;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

class Map extends TiledMap implements TileBasedMap {

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
	public Map(String ref) throws SlickException {
		super(ref);
		for(int i = this.getLayerCount() - 1; i >= 0; --i ) {
			if(this.getLayerProperty(i,"Blocking","false").equals("true")) {
				blockingLayerID = i;
				i = -1;
			}
		}
		tileOffset = new int[]{tileWidth, tileHeight};
	}

	public int getXOffset() {
		return tileOffset[0];
	}

	public int getYOffset() {
		return tileOffset[1];
	}

	public int[] getTileOffset() {
		return tileOffset;
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
		return getTileId(tx,ty,blockingLayerID) != 0;
	}

	@Override
	public float getCost(PathFindingContext context, int tx, int ty) {
		return 1.f;
	}
}
