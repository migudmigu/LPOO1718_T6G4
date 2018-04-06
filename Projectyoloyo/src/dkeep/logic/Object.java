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

}