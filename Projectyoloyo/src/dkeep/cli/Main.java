package dkeep.cli;


import java.util.Scanner;

import dkeep.logic.Map;

public class Main {

	public static void main(String[] args) {
		Map map = new Map();
		char[][] mapa = map.getMapa();
		
		int gameover =0;
		
		while (gameover == 0) {
			printMapa(mapa);
			inputKeys(mapa);
			
		}
		
	}
	
	public static void printMapa(char[][] mapa) {
		for (int i = 0; i < mapa.length; i++) {
			for (int k = 0; k < mapa[i].length; k++)
				System.out.print(mapa[i][k]);
			System.out.println();
		}
	}
	
	public static char inputKeys(char[][] mapa) {
		Scanner s = new Scanner(System.in);
		char tecla = s.next().charAt(0);
		heroMove(tecla, mapa);
	}
	
}