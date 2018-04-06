package dkeep.cli;

import java.util.Scanner;

import dkeep.logic.Game;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Game game = new Game();
		char key;
		
		while(game.gameOver == 0) {
			
			key = readKey();
			game.handler(key);
			game.printMap();
		}
		
		game.gameResult();
	}
	
	/**
	 * @return
	 */
	public static char readKey() {
		Scanner s = new Scanner(System.in);
		char tecla = s.next().charAt(0);
		return tecla;
		
	}
}
