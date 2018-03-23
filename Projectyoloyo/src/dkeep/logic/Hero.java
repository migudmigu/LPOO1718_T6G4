package dkeep.logic;

public class Hero extends Character{

	public Hero(int x, int y, char symbol) {
		super(x, y, symbol);
	}
	
	public boolean moveHero(char key,char[][] map) {

		moveCharacter(key, map);
		return checkLevelEnd(map);
	}
	
	public boolean checkLevelEnd(char[][] map) {

		if( map[this.x][this.y] == 's') {
			return true;
		}
		else return false;
	}
	
}
