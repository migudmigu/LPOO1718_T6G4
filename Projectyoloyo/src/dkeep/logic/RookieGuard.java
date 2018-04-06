package dkeep.logic;

import java.util.Random;

public class RookieGuard extends Guard{
	
	/**
	 * @param x
	 * @param y
	 * @param symbol
	 */
	public RookieGuard(int x, int y, char symbol) {
		super(x, y, symbol);
	}

	/**
	 * @param map
	 */
	public void moveRookieGuard(char[][] map) {
		updateDirection(guardpath[pathStep]);
		moveCharacter(guardpath[pathStep], map);
		upPathSteps();
	}
}
