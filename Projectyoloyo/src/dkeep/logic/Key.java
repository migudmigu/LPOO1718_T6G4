package dkeep.logic;

public class Key extends Object{

	boolean triggered;

	public Key(int x, int y,char symbol) {
		super(x, y, symbol);
		this.symbol='K';
	}
	
	public void triggerKey() {								//not needed
		triggered=!triggered;
	}
	
	public boolean getTriggered() {							//not needed
		return this.triggered;
	}
	
}
