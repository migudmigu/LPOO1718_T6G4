package dkeep.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import dkeep.logic.Game;
import dkeep.logic.Level;

public class GameData {
	
	Game game;
	String personality;
	int numOgres;
	BufferedImage hero, wall, floor, VDoor, HDoor, guard, lever, ogre, ogrestunned, club, key;
	ImageIcon wallicon, dooricon, ogreicon, keyicon, heroicon, flooricon;
	public Level[] levels;
	int lvlcount = 0;
	
	/**
	 * @throws IOException
	 */
	public GameData() throws IOException {
		personality = "Rookie";					//		DEFAULT
		numOgres = 1;
		loadImages();
		this.levels = new Level[10];
		this.addLevel(new Level(1));
		this.addLevel(new Level(2));
	}

	/**
	 * @param personality
	 */
	public void savePersonality(String personality) {
		this.personality = personality;
	}

	/**
	 * @param text
	 */
	public void saveNumOgres(String text) {
		numOgres = Integer.parseInt(text);
	}
	
	/**
	 * @param key
	 */
	public void updateGame(char key) {
		game.handler(key);
	}
	
	/**
	 * 
	 */
	public void startGame() {
		this.game= new Game();
		this.game.loadLevels(levels);
		game.setGuard(personality);
		game.setOgres(numOgres);
	}
	
	/**
	 * @throws IOException
	 */
	public void loadImages() throws IOException {
		this.hero = ImageIO.read(new File("Images/hero.png"));
		this.floor = ImageIO.read(new File("Images/floor.jpg"));
		this.wall = ImageIO.read(new File("Images/wall.png"));
		this.VDoor = ImageIO.read(new File("Images/dooricon.png"));
		this.HDoor = ImageIO.read(new File("Images/dooropen.png"));
		this.guard = ImageIO.read(new File("Images/guardDown.png"));
		this.lever = ImageIO.read(new File("Images/Lever.png"));
		this.ogre = ImageIO.read(new File("Images/Ogre.png"));
		this.ogrestunned = ImageIO.read(new File("Images/OgreStunned.png"));
		this.club = ImageIO.read(new File("Images/Sawblade.png"));
		this.key = ImageIO.read(new File("Images/key.png"));
		this.wallicon = new ImageIcon("Images/wallicon.png");
		this.dooricon = new ImageIcon("Images/dooricon.png");
		this.keyicon = new ImageIcon("Images/keyicon.png");
		this.heroicon = new ImageIcon("Images/heroicon.png");
		this.flooricon = new ImageIcon("Images/flooricon.png");
		this.ogreicon = new ImageIcon("Images/ogreicon.png");
	} 
	
	/**
	 * @param level
	 */
	public void addLevel(Level level) {
		this.levels[lvlcount]=level;
		this.lvlcount++;
	}
	
	/**
	 * @return
	 */
	public int getLevelCount() {
		return this.lvlcount;
	}
	
	/**
	 * @param key
	 * @throws IOException
	 */
	public void setHeroDirection(char key) throws IOException {
		switch (key) {
		case 'w':
			this.hero = ImageIO.read(new File("Images/hero.png"));
			if (game.getHero().getHaskey()) this.hero = ImageIO.read(new File("Images/heroKey.png")); break;
		case 'a':
			this.hero = ImageIO.read(new File("Images/heroLeft.png"));
			break;
		case 's':
			this.hero = ImageIO.read(new File("Images/heroDown.png"));
			break;
		case 'd':
			this.hero = ImageIO.read(new File("Images/heroRight.png"));
			break;
		}
	}
	
	/**
	 * @param key
	 * @throws IOException
	 */
	public void setGuardDirection(char key) throws IOException {
		if (guard != null) {
			switch (key) {
			case 'w':
				this.guard = ImageIO.read(new File("Images/guardUp.png"));
				break;
			case 'a':
				this.guard = ImageIO.read(new File("Images/guardLeft.png"));
				break;
			case 's':
				this.guard = ImageIO.read(new File("Images/guardDown.png"));
				break;
			case 'd':
				this.guard = ImageIO.read(new File("Images/guardRight.png"));
				break;
			}
		}
	}
	
	/**
	 * @throws IOException
	 */
	public void setLeverDirection() throws IOException {
		if(game.getLever().getTriggered())
		this.lever = ImageIO.read(new File("Images/Lever2.png"));
		else this.lever = ImageIO.read(new File("Images/Lever.png"));
	}
		
}
