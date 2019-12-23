package first_rpg.controller;

import first_rpg.view.View;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Controller implements GameController{

	private String title;

	public Controller(String title) { this.title = title; }

	@Override
	public void init(View view) throws SlickException {

	}

	@Override
	public void update(View view, int delta) throws SlickException {

	}

	@Override
	public void render(View view, Graphics g) throws SlickException {

	}

	@Override
	public boolean closeRequested() {
		return false;
	}

	@Override
	public String getTitle() {
		return title;
	}
}
