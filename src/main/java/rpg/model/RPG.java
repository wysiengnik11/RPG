package rpg.model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import java.io.*;
import java.util.ArrayList;

/**
 * Main game model class
 *
 * @author Janusz Kubiak
 * @version 1.0
 * @since 2019-12-23
 */
public class RPG {

	/** Game settings */
	private Settings settings;

	/** Map of the current level */
	private Level level = new Level();

	/** Player character */
	private Player player = new Player();

	/** Movable static image entities */
	private ArrayList<StaticImageEntity> staticImageEntities = new ArrayList<>();

	/** Movable animated entities */
	private ArrayList<AnimatedEntity> animatedEntities = new ArrayList<>();

	/** Mobs */
	public ArrayList<Mob> mobs = new ArrayList<>();

	/** Default constructor */
	public RPG(){
		settings = new Settings();
	}

	/**
	 * Constructor taking in path to saved settings file
	 * If the file does not exist default settings are created
	 * If the file fails to load TODO inform about import failure
	 *
	 * @param settingsPath Path to saved settings file
	 */
	public RPG(String settingsPath) {
		// Check if file exists
		if(new File(settingsPath).exists()) {
			if(!importSettings()) {
				// TODO inform about import failure
				settings = new Settings();
			}
		}
		else {
			settings = new Settings();
		}
	}

	/** Initialize the game */
	public void init() {
		try {
//			level.setMapImage(new Image("build/resources/main/Play/Levels/floor_0/map.png"));
			staticImageEntities.add(new StaticImageEntity(new Image("build/resources/main/images/outlier.png")));
			staticImageEntities.get(0).setPosition(0,0);
			staticImageEntities.get(0).setVelocity(new Vector2f(100,100));
			ArrayList<Animation> animations = new ArrayList<>();
			Image[] imgs = new Image[2];
			imgs[0] = new Image("build/resources/main/images/right1.png");
			imgs[1] = new Image("build/resources/main/images/right2.png");
			animations.add(new Animation(imgs, 200, true));
			AnimatedEntity anim = new AnimatedEntity(animations);
			animatedEntities.add(anim);
			animatedEntities.get(0).setPosition(0,settings.windowHeight-32);
			animatedEntities.get(0).setVelocity(new Vector2f(100,-100));
			Mob mob = new Mob();
			mob.addAnimation(new Animation(new Image[] {new Image("build/resources/main/images/down1.png")},200,true));
			animations.clear();
			imgs = new Image[4];
			for (int i = 0; i < 4; i++)
				imgs[i] = new Image("build/resources/main/images/down"+(i+1)+".png");
			animations.add(new Animation(imgs,200,true));
			imgs = new Image[2];
			for (int i = 0; i < 2; i++)
				imgs[i] = new Image("build/resources/main/images/left"+(i+1)+".png");
			animations.add(new Animation(imgs,200,true));
			imgs = new Image[4];
			for (int i = 0; i < 4; i++)
				imgs[i] = new Image("build/resources/main/images/up"+(i+1)+".png");
			animations.add(new Animation(imgs,200,true));
			imgs = new Image[2];
			for (int i = 0; i < 2; i++)
				imgs[i] = new Image("build/resources/main/images/right"+(i+1)+".png");
			animations.add(new Animation(imgs,200,true));
			imgs = new Image[] { new Image("build/resources/main/images/dying.png"), new Image("build/resources/main/images/dying.png") };
			animations.add((new Animation(imgs, 500,true)));
			imgs = new Image[] {new Image("build/resources/main/images/ded.png"), new Image("build/resources/main/images/ded.png")};
			animations.add((new Animation(imgs, 200,true)));
			mob.addAnimations(animations);
			mob.setPosition(200,200);
			mob.setVelocity(new Vector2f(100,0));
			this.mobs.add(mob);

		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	private int temp = 0;
	private int i = 0;
	public void update(int delta) {
		for (StaticImageEntity s:
				staticImageEntities) {
			s.update(delta);
		}
		for (AnimatedEntity a:
				animatedEntities) {
			a.update(delta);
		}
		temp+=delta;
		for (Mob mob:
				mobs) {
			if(i > 5 && temp>500)
				mob.kill();
			if(temp>1000 && !mob.isDead()) {
				mob.tempupdate();
				temp = 0;
				++i;
			}
			mob.update(delta);
		}
	}

	/**
	 * Function used by controller to get images to draw
	 */
	public void getImages(ArrayList<Image> images, ArrayList<Vector2f> vectors) {
		images.clear();
		vectors.clear();
//		images.add(level.getMapImage());
		vectors.add(level.getPosition());
		for (StaticImageEntity entity:
				staticImageEntities) {
			images.add(entity.getImage());
			vectors.add(entity.getPosition());
		}
	}

	/**
	 * Function used by controller to get animations to draw
	 */
	public void getAnimations(ArrayList<Animation> animations, ArrayList<Vector2f> vectors) {
		animations.clear();
		vectors.clear();
		for (AnimatedEntity entity:
		     animatedEntities) {
			if(entity.isDisplayed()) {
				animations.add(entity.getCurrentAnimation());
				vectors.add(entity.getPosition());
			}
		}
		for (Mob m:
		     mobs) {
			if(m.isDisplayed()) {
				animations.add(m.getCurrentAnimation());
				vectors.add(m.getPosition());
			}
		}
	}

	public String getString() {
		return "theta: "+mobs.get(0).getVelocity().getTheta();
//		return "x: "+mobs.get(0).getVelocity().getX()+ " y: "+mobs.get(0).getVelocity().getY();
	}

	/**
	 * Settings saving method
	 *
	 * @return Returns true if save was successful, false otherwise
	 */
	public boolean saveSettings() {
		try {
			FileOutputStream out = new FileOutputStream(settings.savePath + settings.saveName);
			ObjectOutputStream save = new ObjectOutputStream(out);
			save.writeObject(settings);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Settings importing method
	 * Does not check if file exists
	 *
	 * @return Returns true if import was successful, false otherwise
	 */
	public boolean importSettings() {
		try {
			File f = new File(settings.savePath + settings.saveName);
			if(f.exists()) {
				FileInputStream inp = new FileInputStream(settings.savePath + settings.saveName);
				ObjectInputStream save = new ObjectInputStream(inp);
				settings = (Settings) save.readObject();
			}
			else return false;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}
}