package dkeep.logic;

import java.util.Random;

public class Ogre extends Character {

	Random r;
	protected boolean stunned;
	protected int stunnedTurns;

	char[] moves = { 'a', 's', 'd', 'w' };
	int clubX;
	int clubY;

	/**
	 * @param x
	 * @param y
	 * @param symbol
	 */
	public Ogre(int x, int y, char symbol) {
		super(x, y, symbol);
		stunned = false;
		stunnedTurns = 0;
	}

	/**
	 * @param map
	 */
	public void moveOgre(char[][] map) {
		if (!stunned)
			moveCharacter(moves[randomNumber()], map);
		else
			increaseStunnedTurns();
		possibleClubPos(map);}

	/**
	 * 
	 */
	public void increaseStunnedTurns() {
		stunnedTurns++;
		if (stunnedTurns > 2) {
			stunned = false;
			stunnedTurns = 0;}}
	
	/**
	 * 
	 */
	public void stunOgre() {
		stunned = true;
		stunnedTurns = 0;}

	/**
	 * 
	 */
	public void moveClub() {
		switch (randomNumber()) {
		case 0:
			clubX = this.x + 1;
			clubY = this.y;
			break;
		case 1:
			clubX = this.x - 1;
			clubY = this.y;
			break;
		case 2:
			clubX = this.x;
			clubY = this.y + 1;
			break;
		case 3:
			clubX = this.x;
			clubY = this.y - 1;
			break;}}

	/**
	 * @param map
	 */
	public void possibleClubPos(char[][] map) {
		moveClub();
		while (true) {
			if (map[clubX][clubY] != 'X' && map[clubX][clubY] != 'I')break;
			else moveClub();}}

	/**
	 * @return
	 */
	public int randomNumber() {
		r = new Random();
		int i = r.nextInt(4);
		return i;
	}

	/**
	 * @return
	 */
	public int getClubX() {
		return clubX;
	}

	/**
	 * @return
	 */
	public int getClubY() {
		return clubY;
	}
	
	/**
	 * @return
	 */
	public boolean getStunned() {
		return stunned;
	}
}
