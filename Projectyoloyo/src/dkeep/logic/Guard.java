package dkeep.logic;

import java.util.Random;

public class Guard extends Character {
	protected int pathStep = 0;
	protected char[] guardpath = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd',
			'd', 'd', 'w', 'w', 'w', 'w', 'w' };
	protected boolean asleep;
	protected boolean reverse;
	protected char direction;
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

		if (mov == 'a') {
			updateDirection('d');
			return 'd';
		}
		else if (mov == 'd') {
			updateDirection('a');
			return 'a';
		}
		else if (mov == 'w') {
			updateDirection('s');
			return 's';
		}
		else {
			updateDirection('w');
			return 'w';
		}
	}	
	
	public void moveGuard(char[][] map) {
		if(this instanceof DrunkenGuard)
		((DrunkenGuard)this).moveDrunkenGuard(map);
		else if(this instanceof SuspiciousGuard)
			((SuspiciousGuard)this).moveSuspiciousGuard(map);
		else ((RookieGuard)this).moveRookieGuard(map);
	}
	
	public void updateDirection(char c) {
		this.direction = c;
	}
	
	public char getDirection() {
		return this.direction;
	}
}
