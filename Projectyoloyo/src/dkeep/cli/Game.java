package dkeep.cli;


import java.util.Random;
import java.util.Scanner;

import com.sun.activation.registries.MailcapParseException;

import dkeep.logic.GameBeing;
import dkeep.logic.Guard;
import dkeep.logic.Hero;
import dkeep.logic.Key;
import dkeep.logic.Lever;
import dkeep.logic.Map;
import dkeep.logic.Ogre;

public class Game {
	 
	private static Map map;
	private static Hero hero;
	private static Guard guard;
	private static Lever lever;
	private static Ogre ogre;
	private static Random r;
	private static Key key;
	
	private int gameover = 0;
	
	public Game() {
		map = new Map(1);
		hero = new Hero(1,1);
		guard = new Guard(8,1);
		lever = new Lever(7,8);
		ogre = new Ogre(4,1);
		key = new Key(7,1);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		char key;
		
		while (game.gameover == 0) {
			map.printMapa();
			key = readKey();
			handler(key, hero,guard, game);
		}
		
	}
	
//	public static void startGame() {
//		// Create map
//		Map map = new Map();
//		char[][] mapa = map.getMapa();
//		
//		
//	}
	

	
	public static char readKey() {
		Scanner s = new Scanner(System.in);
		char tecla = s.next().charAt(0);
		return tecla;
	}

	public static void handler(char key, Hero hero, Guard guard, Game game) {
		hero.moveB(key, map);
		if (map.getM() == 1) {
			hero.triggerLever(lever);
			guard.moveB(guard.getPathmove(), map);
		}
		else {
			ogre.moveB(ogre.getRandnum(), map);
			game.getKey().findKey(game);
			ogre.ogreKey();
		}
		
		if (GameBeing.checkColision(game) == 1) {
			game.gameover = 1;
			System.out.println("Gameover. Try again!\n");
		}
		updateMap(game);
	}

	public static void updateMap(Game game) {

//		System.out.println(hero.getX());
//		System.out.println(hero.getY());
// 		System.out.println('\n');
//		System.out.println(guard.getX());
//		System.out.println(guard.getY());
//		System.out.println(ogre.getX());
//		System.out.println(ogre.getY());
		
		map.resetMap(map.getM());
		if (map.getM() == 1) {
			for (int i = 0; i < map.getMapa().length; i++) {
				for (int j = 0; j < map.getMapa()[i].length; j++) {

					if (i == hero.getY() && j == hero.getX())
						map.setCell(i, j, hero.getSymbol());

					if (i == guard.getY() && j == guard.getX())
						map.setCell(i, j, guard.getSymbol());

					if (i == lever.getY() && j == lever.getX())
						map.setCell(i, j, lever.getSymbol());

					changeDoors(i, j);

					if (hero.getX() == 0 && (hero.getY() == 5 || hero.getY() == 6))
						map.setMap(2, game);
				}
			}
		}
		else if(map.getM() == 2) {
			for (int i = 0; i < map.getMapa().length; i++) {
				for (int j = 0; j < map.getMapa()[i].length; j++) {

					if (i == key.getY() && j == key.getX())
						map.setCell(i, j, key.getSymbol());
					
					if (i == hero.getY() && j == hero.getX())
						map.setCell(i, j, hero.getSymbol());

					if (i == ogre.getY() && j == ogre.getX())
						map.setCell(i, j, ogre.getSymbol());

					changeDoors(i, j);
				}
			}
		}
	}

	public static void changeDoors(int i, int j) {
		if(map.getMapa()[i][j] == 'I') 
			if(lever.getLever())
			map.setCell(i, j, 'S');
			else map.setCell(i, j, 'I');
	}
	
	public Hero getHero() {
	return this.hero;
	}
	
	public Guard getGuard() {
		return this.guard;
	}
	
	public Map getMap() {
		return this.map;
	}
	
	public Ogre getOgre() {
		return this.ogre;
	}
	
	public Key getKey() {
		return this.key;
	}
	
	public Lever getLever() {
		return this.lever;
	}
}
