package dkeep.logic;

public class Map{

	private char mapa[][];
	private char mapa1[][] = { 
		{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
		{ 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X' },
		{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
		{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
		{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
		{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
		{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'K', ' ', 'X' },
		{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	private char mapa2[][] = { 
		{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
		{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

	public Map(int m) {
		if (m == 1) {
			mapa = mapa1.clone();
			for(int i = 0; i < mapa1.length; i++)
			    this.mapa[i] = mapa1[i].clone();
		}
		else if (m == 2)
			mapa = mapa2;
	}

	public void setMapa(int m) {
		if (m == 1)
			mapa = mapa1;
		else if (m == 2)
			mapa = mapa2;
	}

	public char[][] getMapa() {
		return mapa;
	}

	public char getCell(int x, int y) {
		return mapa[x][y];
	}

	public void setCell(int x, int y, char symbol) {
		mapa[x][y] = symbol;
	}
	
	public void resetMap(int m) {
		if (m == 1) {
			for(int i = 0; i < mapa1.length; i++)
			    this.mapa[i] = mapa1[i].clone();
		}
		else if (m == 2)
			this.mapa = mapa2;
	}
	
	public void printMapa() {
		for (int i = 0; i < mapa.length; i++) {
			for (int k = 0; k < mapa[i].length; k++)
				System.out.print(mapa[i][k]);
			System.out.println();
		}
	}
	
	
}