package dkeep.logic;

import java.util.Random;

public class Level {
	
	int numOgres=0;
	
	/**
	 * @param l
	 */
	public Level(int l) {
		if (l == 1) {
			map = map1.clone();
			for (int i = 0; i < map1.length; i++)
				this.map[i] = map1[i].clone();
		} else if (l == 2) {
			map = map2.clone();
			for (int i = 0; i < map2.length; i++)
				this.map[i] = map2[i].clone();}}

	/**
	 * 
	 */
	public Level() {}

	protected char map[][];
	protected char map1[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },{ 'X', ' ', 'H', ' ', 'I', ' ', 'X', ' ', 'G', 'X' }, { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' }, { 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	
	protected char map2[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', 'K', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },{ 'X', 'A', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	
	/**
	 * @param x
	 * @param y
	 * @param symbol
	 */
	public void setCell(int x, int y, char symbol) {
		map[x][y] = symbol;
	}

	/**
	 * @param x
	 * @param y
	 */
	public void eraseCell(int x, int y) {
		map[x][y] = ' ';
	}

	/**
	 * @return
	 */
	public char[][] getMap() {
		return map;
	}

	/**
	 * @param map
	 */
	public void setMap(char[][] map) {
		this.map = map;
	}

	/**
	 * @param n
	 */
	public void setOgres(int n) {
		Random r = new Random();
		int x;
		int y;
		for (int i = 0; i < n; i++) {
			x = r.nextInt(4 + 1) + 2;
			y = r.nextInt(3 + 1) + 2;
			setCell(x, y, 'O');
		}
	}

}
