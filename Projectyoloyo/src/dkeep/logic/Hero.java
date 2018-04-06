package dkeep.logic;

public class Hero extends Character {

	boolean haskey = false;

	public Hero(int x, int y, char symbol) {
		super(x, y, symbol);
	}

	public void moveHero(char key, char[][] map, Game game) {

		if (checkDoorWithKey(map) == key)
			openDoorWithKey(map);
		else
			moveCharacter(key, map);

		if (checkLevelEnd(map)) {
			if (game.currentlvli == game.lvlcount)
				game.gameOver = 2;
			else
				game.changeLevel(game.currentlvli);
		}
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

	public void setHaskey() {
		this.setSymbol('K');
		this.haskey = true;
	}

	public boolean getHaskey() {
		return haskey;
	}
}
