package dkeep.logic;

public class Lever extends GameBeing{

	private boolean triggered = false;
	
	public Lever(int x, int y) {
		super(x, y, 'k');
	}
	
	public void setLever() {
		if(triggered)
		triggered=false;
		else triggered=true;
	}
	
	public boolean getLever() {
		return triggered;
	}
	
}
