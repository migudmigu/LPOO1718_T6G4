package dkeep.logic;

/**	
 * Key Class
 * Has functions related to all the keys presented in the game.
 */
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
