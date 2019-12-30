package rpg.model;

import org.junit.Test;
import org.newdawn.slick.geom.*;

import java.io.*;

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
		Shape circle = new Circle(0,0,10);
		Colliding colliding = new Colliding(circle);
		assertSame(colliding.getBoundingBox().getClass(),circle.getClass());
		assertEquals(colliding.getBoundingBox().getLocation().getX(), circle.getLocation().getX(), 0.0);
		assertEquals(colliding.getBoundingBox().getLocation().getY(), circle.getLocation().getY(), 0.0);
	}

	@Test
	public void setX() {
		Colliding colliding = new Colliding(new Circle(0,0,1),0,0);
		colliding.setX(20);
		assertEquals(20, colliding.getX(), 0.0);
		assertEquals(20, colliding.getBoundingBox().getLocation().getX(), 0.0);
	}

	@Test
	public void setY() {
		Colliding colliding = new Colliding(new Circle(0,0,1),0,0);
		colliding.setY(20);
		assertEquals(20, colliding.getY(), 0.0);
		assertEquals(20, colliding.getBoundingBox().getLocation().getY(), 0.0);
	}

	@Test
	public void hasBoundingBox() {
		Colliding colliding = new Colliding();
		assertFalse(colliding.hasBoundingBox());
		colliding = new Colliding(new Circle(0,0,1));
		assertTrue(colliding.hasBoundingBox());
	}

	@Test
	public void setBoundingBox() {
		Colliding colliding = new Colliding();
		assertFalse(colliding.hasBoundingBox());
		colliding.setBoundingBox(new Circle(0,0,1));
		assertTrue(colliding.hasBoundingBox());

		Shape shape = new Circle(0,0,1);
		shape.setLocation(0,0);
		try {
			FileOutputStream out = new FileOutputStream("build/resources/test/testsave.sav");
			ObjectOutputStream save = new ObjectOutputStream(out);
			save.writeObject(shape);
		} catch (IOException e) {
			e.printStackTrace();
		}

		colliding.setBoundingBox("build/resources/test/testsave.sav");
		assertEquals(colliding.getBoundingBox().getLocation().getX(), shape.getLocation().getX(), 0.0);
		assertEquals(colliding.getBoundingBox().getLocation().getY(), shape.getLocation().getY(), 0.0);

	}
}