package dkeep.logic;

import java.util.Random;

public class SuspiciousGuard extends Guard {

	public SuspiciousGuard(int x, int y, char symbol) {
		super(x, y, symbol);
	}

	public void reversePatrol() {

		r = new Random();
		int i = r.nextInt(10);

		if (i == 0 || i == 1)
			setReverse();
	}

	public void moveSuspiciousGuard(char[][] map) {

		reversePatrol();
		if (reverse) {

			downPathSteps();
			moveCharacter(inverseMovement(guardpath[pathStep]), map);
		} else {

			moveCharacter(guardpath[pathStep], map);
			upPathSteps();
		}
	}
}
