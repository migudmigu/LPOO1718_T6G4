package dkeep.logic;

public class Hero extends Character {

	public Hero(int x, int y, char symbol) {
		super(x, y, symbol);
	}

	public boolean moveHero(char key, char[][] map) {
		
		if (checkDoorWithKey(map) == key)
			openDoorWithKey(map);
		else
			moveCharacter(key, map);
		return checkLevelEnd(map);
	}

	public boolean checkLevelEnd(char[][] map) {

		if (map[this.x][this.y] == 's') {
			return true;
		} else
			return false;
	}

	public char checkDoorWithKey(char[][] map) {

		if (this.getSymbol() == 'K') {

			if (map[this.getX() + 1][this.getY()] == 'I') {
				return 's';
			} else if (map[this.getX() - 1][this.getY()] == 'I') {
				return 'w';
			} else if (map[this.getX()][this.getY() + 1] == 'I') {
				return 'd';
			} else if (map[this.getX()][this.getY() - 1] == 'I') {
				return 'a';
			}

		}
		return 'n';
	}

	public void openDoorWithKey(char[][] map) {

		if (this.getSymbol() == 'K') {

			if (map[this.getX() + 1][this.getY()] == 'I') {
				map[this.getX() + 1][this.getY()] = 's';
			} else if (map[this.getX() - 1][this.getY()] == 'I') {
				map[this.getX() - 1][this.getY()] = 's';
			} else if (map[this.getX()][this.getY() + 1] == 'I') {
				map[this.getX()][this.getY() + 1] = 's';
			} else if (map[this.getX()][this.getY() - 1] == 'I') {
				map[this.getX()][this.getY() - 1] = 's';
			}

		}
	}

}
