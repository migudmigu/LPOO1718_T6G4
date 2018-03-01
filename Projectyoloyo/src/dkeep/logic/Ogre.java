package dkeep.logic;

import java.util.Random;

public class Ogre extends GameBeing{

	private Random r;
	
	public Ogre(int x, int y) {
		super(x, y, 'O');
	}
	
//	public char getRandnum() {
//		char w = 'w';
//		char d = 'd';
//		char s = 's';
//		char a = 'a';
//		int rand = r.nextInt(3);
//		if(rand == 0)
//			return w;
//		else if(rand == 1)
//			return d;
//		else if (rand == 2)
//			return s;
//		else if(rand == 3)
//			return a;
//	}

}
