package rpg.model;

import org.junit.Test;
import org.newdawn.slick.geom.Vector2f;

import static org.junit.Assert.*;

public class EntityTest {

	@Test
	public void getVelocity() {
		Vector2f v = new Vector2f(5,5);
		Entity e = new Entity(v);
		assertEquals(v,e.getVelocity());
	}

	@Test
	public void setVelocity() {
		Entity e = new Entity();
		Vector2f v = new Vector2f(1,1);
		e.setVelocity(v);
		assertEquals(v, e.getVelocity());
	}

	@Test
	public void update() {
		Vector2f v = new Vector2f(1,1);
		Entity e = new Entity(v);
		int delta = 1;
		e.update(delta);
		assertEquals(e.getVelocity(),v);
		assertEquals(e.getPosition(),new Vector2f(0,0).add(v.getTheta()*delta));
	}
}