package dkeep.logic;

import java.util.Random;

public class Level {
	
	int numOgres=0;
	
	public Level(int l) {
		if(l==1) {
		map = map1.clone();
		for (int i = 0; i < map1.length; i++) 	
			this.map[i] = map1[i].clone();
		} else if(l==2) {
			map = map2.clone();
			for (int i = 0; i < map2.length; i++)
				this.map[i] = map2[i].clone();
		}
	}
	
	public Level() {
	}

	protected char map[][];
	protected char map1[][] = {
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', ' ', 'H', ' ', 'I', ' ', 'X', ' ', 'G', 'X' }, 
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' }, 
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'k', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	
	protected char map2[][] = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', 'K', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'A', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	
//	protected char map1[][] = {
//	{ 'X', 'X', 'X', 'X', 'X', 'I', 'I', 'X', 'X', 'X' },
//	{ 'X', ' ', 'X', ' ', 'X', ' ', ' ', 'X', ' ', 'X' }, 
//	{ 'X', 'H', 'X', 'I', 'X', ' ', ' ', 'X', 'I', 'X' },
//	{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
//	{ 'X', 'I', 'X', 'I', 'X', ' ', ' ', 'X', 'I', 'X' },
//	{ 'X', ' ', 'X', ' ', 'X', ' ', ' ', 'X', ' ', 'X' }, 
//	{ 'X', 'X', 'X', 'X', 'X', ' ', ' ', 'X', 'X', 'X' },
//	{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X', 'k', 'X' }, 
//	{ 'X', 'G', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//	{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
//
//protected char map2[][] = { 
//	{ 'X', 'I', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
//	{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'A', 'X' }, 
//	{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//	{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
//	{ 'X', 'O', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//	{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
//	{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
//	{ 'X', 'K', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
//	{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	
	
	public void setCell(int x, int y, char symbol) {
		map[x][y] = symbol;
	}
	
	public void eraseCell(int x, int y) {
		map[x][y] = ' ';
	}
	
	public char[][] getMap() {
		return map;
	}
	
	public void setMap(char[][] map) {
		this.map = map;
	}
	
	public void setOgres(int n) {
//		this.numOgres = n;
		Random r = new Random();
		int x;
		int y;
		for(int i=0 ; i < n ; i++) {
		x = r.nextInt(4+1)+2;
		y = r.nextInt(3+1)+2;
		setCell(x,y,'O');
		}
	}

}
