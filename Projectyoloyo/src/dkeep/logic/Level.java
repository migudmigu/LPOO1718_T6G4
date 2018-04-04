package dkeep.logic;

public class Level {
	
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
	
	public Level(char[][] map) {
		for (int i = 0; i < map.length; i++)
			this.map[i] = map[i].clone();
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
			{ 'I', ' ', ' ', ' ', 'O', ' ', ' ', 'k', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'O', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'O', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'A', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	
	public void setCell(int x, int y, char symbol) {
		map[x][y] = symbol;
	}
	
	public void eraseCell(int x, int y) {
		map[x][y] = ' ';
	}
	
	public char[][] getMap() {
		return map;
	}
	
}
