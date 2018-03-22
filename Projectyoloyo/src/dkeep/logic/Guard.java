package dkeep.logic;

public class Guard extends Character{

	private int pathStep = 0;
	private char[] guardpath = {'a','s','s','s','s','a','a','a','a','a','a','s','d','d','d','d','d','d','d','w','w','w','w','w'};

	
	public Guard(int x, int y, char symbol) {
		super(x, y, symbol);
	}
	
	public void upPathStep() {
		if(pathStep==guardpath.length-1)
			pathStep = 0;
		else
		pathStep++;
	}

	public void moveGuard(char[][] map) {

		moveCharacter(guardpath[pathStep], map);
		upPathStep();
	}

}
