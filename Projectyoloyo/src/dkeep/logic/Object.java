package dkeep.logic;

public abstract class Object {

	protected int x, y;
	protected char symbol;

	public Object(int x, int y, char symbol) {
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

}