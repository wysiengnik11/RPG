package rpgV2.model;

import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;

import java.io.Serializable;
import java.util.ArrayList;

class Tile implements Serializable {

	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<Entity> entities = new ArrayList<>();
	private Mob mob = null;
	private boolean passable = true;
	private boolean blocked;
	private float movementCost;
	private float defaultMovementCost = 1.f;
	private int X;
	private int Y;

	private Tile[] connected = new Tile[4];
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;

	Tile(int x, int y) {
		this.X = x;
		this.Y = y;
		movementCost = defaultMovementCost;
	}

	void addMob(Mob mob) {
		if(this.mob == null)
			this.mob = mob;
	}

	void addEntity(Entity entity) {
		this.entities.add(entity);
	}

	void addItem(Item item) {
		this.items.add(item);
	}

	void remove(Mob mob) {
		this.mob = null;
	}

	void remove(Entity entity) {
		this.entities.remove(entity);
	}

	void remove(Item item) {
		this.items.remove(item);
	}

	void moveMob(Tile other) {
		if(!other.isPassable()) {
			if(!mob.moveFailed())
				return;
		}
		other.addMob(mob);
		remove(mob);
	}

	void moveEntity(Tile other, Entity entity) {
		if(!other.isPassable()) {
			if(!entity.moveFailed())
				return;
		}
		other.addEntity(entity);
		entities.remove(entity);
	}

	void update(int delta, Level level) {
		for (Entity e:
				entities) {
			e.update(delta, this, level);
		}
		if(mob != null)
			mob.update(delta, this, level);
	}

	Mob getMob() {
		return mob;
	}

	boolean isBlocked() {
		return blocked;
	}

	void setBlocked(boolean blocked) {
		this.blocked = blocked;
		setPassable(false);
	}

	public float getMovementCost() {
		return movementCost;
	}

	public void setMovementCost(float movementCost) {
		if(movementCost < 0)
			this.movementCost = defaultMovementCost;
		else
			this.movementCost = movementCost;
	}

	public void setDefaultMovementCost(float movementCost) {
		defaultMovementCost = movementCost;
	}

	public float getDefaultMovementCost() {
		return defaultMovementCost;
	}

	public boolean isPassable() {
		return passable;
	}

	public void setPassable(boolean passable) {
		this.passable = passable;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	void connect(Tile tile, int direction) throws SlickException {
		if(tile == null || direction != UP && direction != RIGHT && direction != DOWN && direction != LEFT)
			throw new SlickException("Tile connection failure. Check the code.");
		connected[direction] = tile;
	}

	Tile getConnected(int direction) throws SlickException {
		if(direction != UP && direction != RIGHT && direction != DOWN && direction != LEFT)
			throw new SlickException("No direction " + direction + " Check the game code.");
		return connected[direction];
	}

	public ArrayList<Renderable> getRenderables() {
		ArrayList<Renderable> ret = new ArrayList<>();
		for (Item i:
		     items) {
			if((boolean) i.properties.get("Renderable"))
				ret.add(i.getRenderable());
		}
		return ret;
	}

	public ArrayList<int[]> getRenderablesPos() {
		ArrayList<int[]> ret = new ArrayList<>();
		for (Item i:
		     items) {
			if((boolean) i.properties.get("Renderable"))
				ret.add(new int[] {getX(), getY()});
		}
		return ret;
	}
}



