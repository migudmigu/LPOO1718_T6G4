package dkeep.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dkeep.logic.Game;
import dkeep.logic.Level;

public class GameData {
	
	Game game;
	String personality;
	int numOgres;
	BufferedImage hero;
	BufferedImage wall;
	BufferedImage floor;
	BufferedImage VDoor;
	BufferedImage HDoor;
	BufferedImage guard;
	BufferedImage lever;
	Level[] levels;
	int lvlcount = 2;
	
	public GameData() throws IOException {
		personality = "Rookie";					//		DEFAULT
		numOgres = 1;
		loadImages();
		this.levels = new Level[10];
	}

	public void savePersonality(String personality) {
		this.personality = personality;
	}
	
	public void updateGame(char key) {
		game.handler(key);
	}
	
	public void startGame() {
		this.game= new Game();
		this.levels=game.getLevels();
		game.setGuard(personality);
//		game.setOgres(numOgres);
	}
	
	public void loadImages() throws IOException {
		this.hero = ImageIO.read(new File("Images/hero.png"));
		this.floor = ImageIO.read(new File("Images/floor.jpg"));
		this.wall = ImageIO.read(new File("Images/wall.png"));
		this.VDoor = ImageIO.read(new File("Images/VerDoors.png"));
		this.HDoor = ImageIO.read(new File("Images/HorDoors.png"));
		this.guard = ImageIO.read(new File("Images/guardDown.png"));
		this.lever = ImageIO.read(new File("Images/Lever.png"));
	}
	
	public void addLevel(Level level) {
		this.levels[lvlcount]=level;
		this.lvlcount++;
	}
	
	public int getLevelCount() {
		return this.lvlcount;
	}
	
//	public void checkDoors() throws IOException {
//		if(game.doorsOpened)
//		this.VDoor = ImageIO.read(new File("Images/HorDoors.png"));
//		else VDoor = ImageIO.read(new File("Images/VerDoors.png"));
//	}
	
	public void setHeroDirection(char key) throws IOException {
		switch(key) {
		case 'w':this.hero = ImageIO.read(new File("Images/hero.png"));break;
		case 'a':this.hero = ImageIO.read(new File("Images/heroLeft.png")); break;
		case 's':this.hero = ImageIO.read(new File("Images/heroDown.png")); break;
		case 'd':this.hero = ImageIO.read(new File("Images/heroRight.png")); break;
		}
	}
	
	public void setGuardDirection(char key) throws IOException {
		switch(key) {
		case 'w':this.guard = ImageIO.read(new File("Images/guardUp.png"));break;
		case 'a':this.guard = ImageIO.read(new File("Images/guardLeft.png")); break;
		case 's':this.guard = ImageIO.read(new File("Images/guardDown.png")); break;
		case 'd':this.guard = ImageIO.read(new File("Images/guardRight.png")); break;
		}
	}
	
	public void setLeverDirection() throws IOException {
		if(game.getKey().getTriggered())
		this.lever = ImageIO.read(new File("Images/Lever2.png"));
		else this.lever = ImageIO.read(new File("Images/Lever.png"));
	}
}
