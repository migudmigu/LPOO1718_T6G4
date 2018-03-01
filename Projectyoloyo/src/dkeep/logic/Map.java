package dkeep.logic;

import dkeep.cli.Game;

public class Map {

	private int M;
	private char mapa[][];
	private char mapa1[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' }, { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' }, { 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	private char mapa2[][] = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

	public Map(int m) {
		if (m == 1) {
			M = 1;
			mapa = mapa1.clone();
			for (int i = 0; i < mapa1.length; i++)
				this.mapa[i] = mapa1[i].clone();
		} else if (m == 2) {
			mapa = mapa2;
			M = 2;
		}
	}

	public void setMap(int m, Game game) {
		if (m == 1) {
			mapa = mapa1;
			M = 1;
		} else if (m == 2) {
			mapa = mapa2.clone();
			for (int i = 0; i < mapa2.length; i++)
				this.mapa[i] = mapa2[i].clone();
			game.getHero().setX(1);
			game.getHero().setY(7);
			M = 2;
			game.getLever().setLever();
		}
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
			for (int i = 0; i < mapa1.length; i++)
				this.mapa[i] = mapa1[i].clone();
		} else if (m == 2)
			for (int i = 0; i < mapa2.length; i++)
				this.mapa[i] = mapa2[i].clone();
	}

	public void printMapa() {
		for (int i = 0; i < mapa.length; i++) {
			for (int k = 0; k < mapa[i].length; k++)
				System.out.print(mapa[i][k]);
			System.out.println();
		}
	}

	public int getM() {
		return this.M;
	}

}