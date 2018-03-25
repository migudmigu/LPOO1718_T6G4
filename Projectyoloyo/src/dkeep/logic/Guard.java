package dkeep.logic;

import java.util.Random;

public class Guard extends Character {

	protected int pathStep = 0;
	protected char[] guardpath = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd',
			'd', 'd', 'w', 'w', 'w', 'w', 'w' };
	protected boolean asleep;
	protected boolean reverse;
	Random r;

	public Guard(int x, int y, char symbol) {
		super(x, y, symbol);
		asleep = false;
		reverse = false;
	}

	public void upPathSteps() {

		if (pathStep == guardpath.length - 1)
			pathStep = 0;
		else
			pathStep++;
	}
	
	public void downPathSteps() {

		if (pathStep == 0)
			pathStep = guardpath.length - 1;
		else
			pathStep--;
	}
	
	public void setReverse() {

		if (reverse)
			reverse = false;
		else
			reverse = true;
	}
	
	public char inverseMovement(char mov) {

		if (mov == 'a')
			return 'd';
		else if (mov == 'd')
			return 'a';
		else if (mov == 'w')
			return 's';
		else
			return 'w';
	}	
}
