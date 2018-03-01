package dkeep.logic;

import java.util.Random;

public class Ogre extends GameBeing{

	public Ogre(int x, int y) {
		super(x, y, 'O');
	}
	
	
	public char getRandnum() {
	
		Random rand = new Random();
		int n = rand.nextInt(4) + 1;
		if(n == 1)
			return 'w';
		else if(n == 2)
			return 'd';
		else if (n == 3)
			return 's';
		else
			return 'a';
	}
	
	public void ogreKey() {
		
		if(this.getX() == 7 && this.getY() == 1)
			this.setSymbol('$');
		else
			this.setSymbol('O');
	}

}
