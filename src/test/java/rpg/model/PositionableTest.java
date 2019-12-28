package rpg.model;

import org.junit.Test;
import org.newdawn.slick.geom.Vector2f;

import static org.junit.Assert.*;

public class PositionableTest {

	@Test
	public void getX() {
		Positionable pos = new Positionable(10,10);
		assertEquals(10.f, pos.getX(), 0.0);
	}

	@Test
	public void setX() {
		Positionable pos = new Positionable(0,0);
		assertEquals(0.f, pos.getX(), 0.0);
		pos.setX(10);
		assertEquals(10.f, pos.getX(), 0.0);
	}

	@Test
	public void getY() {
		Positionable pos = new Positionable(10,10);
		assertEquals(10.f, pos.getY(), 0.0);
	}

	@Test
	public void setY() {
		Positionable pos = new Positionable(0,0);
		assertEquals(0.f, pos.getY(), 0.0);
		pos.setY(10);
		assertEquals(10.f, pos.getY(), 0.0);
	}

	@Test
	public void setPosition() {
		Positionable pos = new Positionable(0,0);
		assertEquals(0.f, pos.getX(), 0.0);
		assertEquals(0.f, pos.getY(), 0.0);
		pos.setPosition(10,10);
		assertEquals(10.f, pos.getX(), 0.0);
		assertEquals(10.f, pos.getY(), 0.0);

		pos.setPosition(new Vector2f(5,5));
		assertEquals(pos.getPosition(), new Vector2f(5,5));
	}

	@Test
	public void getPosition() {
		Positionable pos = new Positionable(10,10);
		assertEquals(pos.getPosition(), new Vector2f(10,10));
	}
}