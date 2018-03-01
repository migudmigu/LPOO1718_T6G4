package dkeep.logic;

public class Guard extends GameBeing {

	private int pathStep = 0;
	private char[] guardpath = {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};
	
	public Guard(int x, int y) {
		super(x, y, 'G');
	}
	
	public  char[] getGuardpath() {
		return guardpath;
	}
	
	public char getPathmove() {
		int ppathstep = pathStep;
		upPathstep();
		return guardpath[ppathstep];
	}
	
	public void upPathstep() {
		if(pathStep==guardpath.length-1)
			pathStep = 0;
		else
		pathStep++;
	}

}
