import java.util.Scanner;

public class Mapa {
	public static void main(String[] args) {
		char mapa[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'K', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, };

		
		int heroi_x = 1;
		int heroi_y = 1;
		int w1x = 0, w1y=5,
			w2x = 0, w2y=6;
		
		
		while (true) {
			
			for (int i = 0; i < mapa.length; i++) {
				for (int k = 0; k < mapa[i].length; k++)
					System.out.print(mapa[i][k]);
				System.out.println();
			}

			Scanner s = new Scanner(System.in);
			char tecla = s.next().charAt(0);
			if (tecla == 'w') {

				if (!(mapa[heroi_y - 1][heroi_x] == 'X' || mapa[heroi_y - 1][heroi_x] == 'I')) {
					mapa[heroi_y][heroi_x] = ' ';
					heroi_y--;
					mapa[heroi_y][heroi_x] = 'H';
				}
			}
			if (tecla == 'a') {

				if (!(mapa[heroi_y][heroi_x - 1] == 'X' || mapa[heroi_y][heroi_x - 1] == 'I')) {
					mapa[heroi_y][heroi_x] = ' ';
					heroi_x--;
					mapa[heroi_y][heroi_x] = 'H';
				}
			}
			if (tecla == 'd') {

				if (!(mapa[heroi_y][heroi_x + 1] == 'X' || mapa[heroi_y][heroi_x + 1] == 'I')) {
					mapa[heroi_y][heroi_x] = ' ';
					heroi_x++;
					mapa[heroi_y][heroi_x] = 'H';
				}
			}
			if (tecla == 's') {

				if (!(mapa[heroi_y + 1][heroi_x] == 'X' || mapa[heroi_y + 1][heroi_x] == 'I')) {
					mapa[heroi_y][heroi_x] = ' ';
					heroi_y++;
					mapa[heroi_y][heroi_x] = 'H';
				}
			}
			if(mapa[heroi_y][heroi_x] == 'K') {
				mapa[w1y][w1x]='S';
				mapa[w2y][w2x]='S';
			}
		}
	}
}
