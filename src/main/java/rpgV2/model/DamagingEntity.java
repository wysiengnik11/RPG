package rpgV2.model;

import org.newdawn.slick.Renderable;

class DamagingEntity extends Entity {

	private int damage;

	DamagingEntity(int damage) {
		this.damage = damage;
	}

	@Override
	void update(int delta, Tile tile, Level level) {
		Mob mob = tile.getMob();
		if(mob != null) {
			mob.takeDamage(damage);
			terminate(tile);
		}
	}

	@Override
	boolean moveFailed() {
		return false;
	}

	@Override
	void terminate(Tile tile) {
		tile.remove(this);
	}

	@Override
	public Renderable getRenderable() {
		return null;
	}
}
