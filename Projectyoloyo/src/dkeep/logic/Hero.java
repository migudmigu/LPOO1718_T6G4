package dkeep.logic;

public class Hero extends GameBeing {
	
	public Hero(int x, int y) {
		super(x, y, 'H');
	}
	
	public void triggerLever(Lever lever) {
		if(this.getX() == lever.getX() && this.getY() == lever.getY())
		lever.setLever();
	}

}
