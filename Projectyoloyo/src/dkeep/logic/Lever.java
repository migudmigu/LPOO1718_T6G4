package dkeep.logic;

/**	
 * Lever Class
 * Has functions related to all the levers presented in the game.
 */
public class Lever extends Object{
	
	boolean triggered;

	/**
	 * @param x
	 * @param y
	 * @param symbol
	 */
	public Lever(int x, int y,char symbol) {
		super(x, y, symbol);
		this.symbol='k';
	}
	
	/**
	 * 
	 */
	public void triggerKey() {
		triggered=!triggered;
	}
	
	/**
	 * @return
	 */
	public boolean getTriggered() {
		return this.triggered;
	}

}
