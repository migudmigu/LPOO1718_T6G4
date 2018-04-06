package dkeep.logic;

import java.util.Random;

public class Guard extends Character {
	protected int pathStep = 0;
	protected char[] guardpath = {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};
	protected boolean asleep, reverse;
	protected char direction;
	Random r;

	/**
	 * @param x
	 * @param y
	 * @param symbol
	 */
	public Guard(int x, int y, char symbol) {
		super(x, y, symbol);
		asleep = false;
		reverse = false;
	}

	/**
	 * 
	 */
	public void upPathSteps() {
		if (pathStep == guardpath.length - 1)pathStep = 0;
		else pathStep++;}
	
	/**
	 * 
	 */
	public void downPathSteps() {
		if (pathStep == 0)	pathStep = guardpath.length - 1;
		else pathStep--;}
	
	/**
	 * 
	 */
	public void setReverse() {
		if (reverse) reverse = false;
		else reverse = true;}
	
	/**
	 * @param mov
	 * @return
	 */
	public char inverseMovement(char mov) {
		switch (mov) {
		case 'a':
			updateDirection('d');
			return 'd';
		case 'd':
			updateDirection('a');
			return 'a';
		case 'w':
			updateDirection('s');
			return 's';
		case 's':
			updateDirection('w');
			return 'w';
		default:
			return ' ';	}}

	/**
	 * @param map
	 */
	public void moveGuard(char[][] map) {
		if(this instanceof DrunkenGuard) ((DrunkenGuard)this).moveDrunkenGuard(map);
		else if(this instanceof SuspiciousGuard) ((SuspiciousGuard)this).moveSuspiciousGuard(map);
		else ((RookieGuard)this).moveRookieGuard(map);
	}
	
	/**
	 * @param c
	 */
	public void updateDirection(char c) {
		this.direction = c;
	}
	
	/**
	 * @return
	 */
	public char getDirection() {
		return this.direction;
	}
	
	/**
	 * @param path
	 */
	public void setPath(char[] path) {
		guardpath = path;
	}
	
	/**
	 * @return
	 */
	public boolean getAsleep() {
		return this.asleep;
	}
	
	/**
	 * @return
	 */
	public boolean getReverse() {
		return this.reverse;
	}
}
