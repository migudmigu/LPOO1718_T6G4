package dkeep.logic;

/**	
 * Object Class
 * Like the Character Class it is a SuperClass that relates to the Key and Lever Classes.
 */
public abstract class Object {

	protected int x, y;
	protected char symbol;

	/**
	 * @param x
	 * @param y
	 * @param symbol
	 */
	public Object(int x, int y, char symbol) {
		this.x = x;
		this.y = y;
		this.symbol = symbol;
	}

	/**
	 * @return
	 */
	public int getX() {

		return x;
	}

	/**
	 * @return
	 */
	public int getY() {

		return y;
	}

}