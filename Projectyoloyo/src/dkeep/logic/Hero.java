package dkeep.logic;

/**	
 * Hero Class
 * Has all the functions needed for the user to be able to play and move the Hero.
 */
public class Hero extends Character {

	boolean haskey = false;

	/**
	 * @param x
	 * @param y
	 * @param symbol
	 */
	public Hero(int x, int y, char symbol) {
		super(x, y, symbol);
	}

	/**
	 * @param key
	 * @param map
	 * @param game
	 */
	public void moveHero(char key, char[][] map, Game game) {
		if (checkDoorWithKey(map) == key)openDoorWithKey(map);
		else moveCharacter(key, map);

		if (checkLevelEnd(map)) {
			if (game.currentlvli == game.lvlcount)game.gameOver = 2;
			else game.changeLevel(game.currentlvli);}}

	/**
	 * @param map
	 * @return
	 */
	public boolean checkLevelEnd(char[][] map) {
		if (map[this.x][this.y] == 's')return true;
		else return false;
	}

	/**
	 * @param map
	 * @return
	 */
	public char checkDoorWithKey(char[][] map) {
		if (this.getSymbol() == 'K') {
			if (map[this.getX() + 1][this.getY()] == 'I') return 's';
			else if (map[this.getX() - 1][this.getY()] == 'I') return 'w';
			else if (map[this.getX()][this.getY() + 1] == 'I') return 'd';
			else if (map[this.getX()][this.getY() - 1] == 'I') return 'a';}
		return 'n';}

	/**
	 * @param map
	 */
	public void openDoorWithKey(char[][] map) {
		if (this.getSymbol() == 'K') {
			if (map[this.getX() + 1][this.getY()] == 'I') map[this.getX() + 1][this.getY()] = 's';
			else if (map[this.getX() - 1][this.getY()] == 'I')map[this.getX() - 1][this.getY()] = 's';
			else if (map[this.getX()][this.getY() + 1] == 'I')map[this.getX()][this.getY() + 1] = 's';
			else if (map[this.getX()][this.getY() - 1] == 'I')map[this.getX()][this.getY() - 1] = 's';}}

	/**
	 * 
	 */
	public void setHaskey() {
		this.setSymbol('K');
		this.haskey = true;
	}

	/**
	 * @return
	 */
	public boolean getHaskey() {
		return haskey;
	}
}
