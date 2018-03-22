package dkeep.logic;

public abstract class Character {

	protected int x, y;
	protected char symbol;

	public Character(int x, int y, char symbol) {

		this.x = x;
		this.y = y;
		this.symbol = symbol;
	}

	public int getX() {

		return x;
	}

	public int getY() {

		return y;
	}

	public char getSymbol() {

		return this.symbol;
	}

	public void setX(int x) {

		this.x = x;
	}

	public void setY(int y) {

		this.y = y;
	}

	public void setSymbol(char symbol) {

		this.symbol = symbol;
	}

	public void moveCharacter(char key, char[][] map) {

		if (key == 'w') {					
			if(map[this.x-1][this.y] != 'X' && map[this.x-1][this.y] != 'I')
				this.x--;
		}
		if (key == 'a') {
			if(map[this.x][this.y-1] != 'X' && map[this.x][this.y-1] != 'I')
				this.y--;
		}
		if (key == 'd') {
			if(map[this.x][this.y+1] != 'X' && map[this.x][this.y+1] != 'I')
				this.y++;
		}
		if (key == 's') {
			if(map[this.x+1][this.y] != 'X' && map[this.x+1][this.y] != 'I')
				this.x++;
		}
	}
}
