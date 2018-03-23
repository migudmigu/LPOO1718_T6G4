package dkeep.logic;

import java.util.Random;

public class Ogre extends Character{

	Random r;
	char[] moves = {'a','s','d','w'};
	

	public Ogre(int x, int y, char symbol) {
		super(x, y, symbol);
	}
	
	public void moveOgre(char[][] map) {
		moveCharacter(moves[randomNumber()], map);
	}
	
	public int randomNumber() {
		r = new Random();
		int i = r.nextInt(4);
		return i;
	}
}
