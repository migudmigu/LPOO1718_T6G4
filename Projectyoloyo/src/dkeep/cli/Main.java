package dkeep.cli;

import java.util.Scanner;

import dkeep.logic.Game;

/**	
 * 
 * Main Class
 *
 */
public class Main {

	/**
	 * Main function
	 * @param args Arguments of type String[]
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
	 * Reads the pressed key
	 * @return char which is the pressed key
	 */
	public static char readKey() {
		Scanner s = new Scanner(System.in);
		char tecla = s.next().charAt(0);
		return tecla;
		
	}
}
