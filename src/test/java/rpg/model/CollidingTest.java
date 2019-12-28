package rpg.model;

import org.junit.Test;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Rectangle;

import static org.junit.Assert.*;

public class CollidingTest {

	@Test
	public void intersects() {
		Colliding first = new Colliding(50,50);
		Colliding second = new Colliding(80,80);
		assertFalse(first.intersects(second));
		first.setBoundingBox(new Circle(0,0,50));
		second.setBoundingBox(new Circle(0,0,50));
		assertTrue(first.intersects(second));
		second.setPosition(150,150);
		assertFalse(first.intersects(second));
		first.setBoundingBox(new Circle(0,0,100));
		first.setPosition(150,150);
		assertTrue(first.intersects(second));
		float[] points = new float[]{0,0,0,200,200,200,200,0}; // Rectangle
		first.setBoundingBox(new Polygon(points));
		first.setPosition(0,0);
		second.setPosition(100,100);
		second.setBoundingBox(new Circle(0,0,10));
		assertFalse(first.intersects(second));
	}

	@Test
	public void contains() {
		Colliding first = new Colliding(50,50);
		Colliding second = new Colliding(80,80);
		assertFalse(first.contains(second));
		first.setBoundingBox(new Circle(0,0,50));
		second.setBoundingBox(new Circle(0,0,50));
		assertFalse(first.contains(second));
		second.setPosition(150,150);
		assertFalse(first.contains(second));
		first.setBoundingBox(new Circle(0,0,100));
		first.setPosition(150,150);
		assertFalse(first.contains(second));
		float[] points = new float[]{0,0,0,200,200,200,200,0}; // Rectangle
		first.setBoundingBox(new Polygon(points));
		first.setPosition(0,0);
		second.setPosition(100,100);
		second.setBoundingBox(new Circle(0,0,10));
		assertTrue(first.collides(second));
	}

	@Test
	public void collides() {
		Colliding first = new Colliding(50,50);
		Colliding second = new Colliding(80,80);
		assertFalse(first.collides(second));
		first.setBoundingBox(new Circle(0,0,50));
		second.setBoundingBox(new Circle(0,0,50));
		assertTrue(first.collides(second));
		second.setPosition(150,150);
		assertFalse(first.collides(second));
		first.setBoundingBox(new Circle(0,0,100));
		first.setPosition(150,150);
		assertTrue(first.collides(second));
		float[] points = new float[]{0,0,0,200,200,200,200,0}; // Rectangle
		first.setBoundingBox(new Polygon(points));
		first.setPosition(0,0);
		second.setPosition(100,100);
		second.setBoundingBox(new Circle(0,0,10));
		assertTrue(first.collides(second));
	}

	@Test
	public void getBoundingBox() {
	}

	@Test
	public void setBoundingBox() {
	}

	@Test
	public void testSetBoundingBox() {
	}

	@Test
	public void setX() {
	}

	@Test
	public void setY() {
	}

	@Test
	public void hasBoundingBox() {
	}
}