package dkeep.logic;

public class Key extends Object{

	boolean triggered;

	public Key(int x, int y,char symbol) {
		super(x, y, symbol);
		this.symbol='K';
	}
	
	public void triggerKey() {
		triggered=!triggered;
	}
	
	public boolean getTriggered() {
		return this.triggered;
	}
	
}
