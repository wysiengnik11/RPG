package first_rpg.view;

import org.lwjgl.input.Cursor;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.opengl.ImageData;

public class View implements GameView, GUIContext {

	@Override
	public Input getInput() {
		return null;
	}

	@Override
	public long getTime() {
		return 0;
	}

	@Override
	public int getScreenWidth() {
		return 0;
	}

	@Override
	public int getScreenHeight() {
		return 0;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public Font getDefaultFont() {
		return null;
	}

	@Override
	public void setMouseCursor(String ref, int hotSpotX, int hotSpotY) throws SlickException {

	}

	@Override
	public void setMouseCursor(ImageData data, int hotSpotX, int hotSpotY) throws SlickException {

	}

	@Override
	public void setMouseCursor(Cursor cursor, int hotSpotX, int hotSpotY) throws SlickException {

	}

	@Override
	public void setDefaultMouseCursor() {

	}
}
