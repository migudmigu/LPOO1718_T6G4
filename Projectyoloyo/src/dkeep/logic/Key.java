package dkeep.logic;

public class Key extends Object{

	boolean triggered;

	/**
	 * @param x
	 * @param y
	 * @param symbol
	 */
	public Key(int x, int y,char symbol) {
		super(x, y, symbol);
		this.symbol='K';
	}
}
