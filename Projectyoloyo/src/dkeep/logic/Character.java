package dkeep.logic;

public abstract class Character {

	protected int x, y;
	protected char symbol;

	public Character(int x, int y, char symbol) {
		this.x = x;
		this.y = y;
		this.symbol = symbol;}

	/**
	 * @return
	 */
	public int getX() {
		return x;}

	/**
	 * @return
	 */
	public int getY() {
		return y;}

	/**
	 * @return
	 */
	public char getSymbol() {
		return this.symbol;}

	/**
	 * @param symbol
	 */
	public void setSymbol(char symbol) {
		this.symbol = symbol;}

	/**
	 * @param key
	 * @param map
	 */
	public void moveCharacter(char key, char[][] map) {

		switch(key) {
		case 'w':
			if(map[this.x-1][this.y] != 'X' && map[this.x-1][this.y] != 'I')
				this.x--;
			break;
		case 'a':
			if(map[this.x][this.y-1] != 'X' && map[this.x][this.y-1] != 'I')
				this.y--;
			break;
		case 'd':
			if(map[this.x][this.y+1] != 'X' && map[this.x][this.y+1] != 'I')
				this.y++;
			break;
		case 's':
			if(map[this.x+1][this.y] != 'X' && map[this.x+1][this.y] != 'I')
				this.x++;
			break;
		}}
}
