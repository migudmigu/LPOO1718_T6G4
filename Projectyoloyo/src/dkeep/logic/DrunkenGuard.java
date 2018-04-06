package dkeep.logic;

import java.util.Random;

public class DrunkenGuard extends Guard {

	public DrunkenGuard(int x, int y, char symbol) {
		super(x, y, symbol);}

	public boolean getAsleep() {
		return asleep;}

	public void fallAsleep() {

		r = new Random();
		int i = r.nextInt(5);

		switch(i) {
		case 0:			
			setReverse();
			asleep = true;
			this.setSymbol('g');
			break;
		case 1:
			asleep = true;
			this.setSymbol('g');
			break;
		default:
			asleep = false;
			this.setSymbol('G');
			break;
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
