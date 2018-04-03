package dkeep.logic;

import java.util.Random;

public class DrunkenGuard extends Guard {

	public DrunkenGuard(int x, int y, char symbol) {
		super(x, y, symbol);
	}

	public boolean getAsleep() {

		return asleep;
	}

	public void fallAsleep() {

		r = new Random();
		int i = r.nextInt(5);

		if (i == 0) {
			
			setReverse();
			asleep = true;
			this.setSymbol('g');
		} else if (i == 1) {

			asleep = true;
			this.setSymbol('g');
		} else {

			asleep = false;
			this.setSymbol('G');
		}
	}

	public void moveDrunkenGuard(char[][] map) {

		fallAsleep();

		if (!asleep) {

			if (reverse) {

				downPathSteps();
				moveCharacter(inverseMovement(guardpath[pathStep]), map);
			} else {
				updateDirection(guardpath[pathStep]);
				moveCharacter(guardpath[pathStep], map);
				upPathSteps();
			}
		}
	}
}
