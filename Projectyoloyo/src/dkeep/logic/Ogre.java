package dkeep.logic;

import java.util.Random;

public class Ogre extends Character {

	Random r;
	char[] moves = { 'a', 's', 'd', 'w' };
	int clubX;
	int clubY;

	public Ogre(int x, int y, char symbol) {
		super(x, y, symbol);

	}

	public void moveOgre(char[][] map) {
		
		moveCharacter(moves[randomNumber()], map);
		possibleClubPos(map);
	}

	public void moveClub() {

		switch (randomNumber()) {

		case 0:
			clubX = this.x + 1;
			clubY = this.y;
			break;
		case 1:
			clubX = this.x - 1;
			clubY = this.y;
			break;
		case 2:
			clubX = this.x;
			clubY = this.y + 1;
			break;
		case 3:
			clubX = this.x;
			clubY = this.y - 1;
			break;
		}
	}

	public void possibleClubPos(char[][] map) {

		moveClub();
		
		while (true) {

			if (map[clubX][clubY] != 'X' && map[clubX][clubY] != 'I') {
				break;
			} else
				moveClub();
		}
	}

	public int randomNumber() {
		r = new Random();
		int i = r.nextInt(4);
		return i;
	}
}
