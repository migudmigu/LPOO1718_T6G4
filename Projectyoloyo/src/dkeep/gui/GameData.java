package dkeep.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dkeep.logic.Game;

public class GameData {
	
	Game game;
	String personality;
	int numOgres;
	BufferedImage hero;
	
	public GameData() throws IOException {
		personality = "Rookie";					//		DEFAULT
		numOgres = 1;
		loadImages();
	}

	public void savePersonality(String personality) {
		this.personality = personality;
	}
	
	
	
	public void updateGame(char key) {
		game.handler(key);
	}
	
	public void startGame() {
		this.game= new Game();
		game.setGuard(personality);
//		game.setOgres(numOgres);
	}
	
	public void loadImages() throws IOException {
		this.hero = ImageIO.read(new File("Images/hero.png"));
	}
	
	public void setHeroDirection(char key) throws IOException {
		System.out.print(key);
		switch(key) {
		case 'w':this.hero = ImageIO.read(new File("Images/hero.png"));break;
		case 'a':this.hero = ImageIO.read(new File("Images/heroLeft.png")); break;
		case 's':this.hero = ImageIO.read(new File("Images/heroDown.png")); break;
		case 'd':this.hero = ImageIO.read(new File("Images/heroRight.png")); break;
		}
	}
}
