package dkeep.logic;

import java.util.Random;

public class RookieGuard extends Guard{
	
	public RookieGuard(int x, int y, char symbol) {
		super(x, y, symbol);
	}

	public void moveRookieGuard(char[][] map) {

		moveCharacter(guardpath[pathStep], map);
		upPathSteps();
	}
}
