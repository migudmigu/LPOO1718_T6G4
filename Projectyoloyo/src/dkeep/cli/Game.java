package dkeep.cli;


import java.util.Scanner;

import dkeep.logic.GameBeing;
import dkeep.logic.Guard;
import dkeep.logic.Hero;
import dkeep.logic.Map;

public class Game {
	 
	private static Map map;
	private static Hero hero;
	private static Guard guard;
	
	public Game() {
		map = new Map(1);
		hero = new Hero(1,1);
		guard = new Guard(8,1);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		int gameover = 0;
		char key;
		
		while (gameover == 0) {
			map.printMapa();
			key = readKey();
			handler(key, hero);
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

	public static void handler(char key, Hero hero) {
		hero.moveB(key);
		map.updateMap();
		
		
	}
	
}