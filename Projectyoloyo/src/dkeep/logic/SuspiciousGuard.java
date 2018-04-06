package dkeep.logic;

import java.util.Random;

/**	
 * SuspiciousGuard Class
 * Derived Class from the Class Guard. Represents the instance of the guard which is suspicious.
 */
public class SuspiciousGuard extends Guard {

	/**
	 * @param x
	 * @param y
	 * @param symbol
	 */
	public SuspiciousGuard(int x, int y, char symbol) {
		super(x, y, symbol);
	}

	/**
	 * 
	 */
	public void reversePatrol() {

		r = new Random();
		int i = r.nextInt(10);

		if (i == 0 || i == 1)
			setReverse();
	}

	/**
	 * @param map
	 */
	public void moveSuspiciousGuard(char[][] map) {
		reversePatrol();
		if (reverse) {
			downPathSteps();
			moveCharacter(inverseMovement(guardpath[pathStep]), map);
		} else {
			updateDirection(guardpath[pathStep]);
			moveCharacter(guardpath[pathStep], map);
			upPathSteps();}}}
