import java.util.Scanner;

public class Mapa {
	public static void main(String[] args) {
		char mapa[][] = { 
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'H', ' ', ' ', 'I', ' ', 'X', ' ', 'G', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
				{ 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
				{ 'X', ' ', 'I', ' ', 'I', ' ', 'X', 'K', ' ', 'X' },
				{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };

		int gameover = 0;
		int heroi_x = 1;
		int heroi_y = 1;
		int numero = 0;
		
		int w1x = 0, w1y=5,
			w2x = 0, w2y=6;
		int[][] guarda_xy = {
				{8,1},
				{7,1},
				{7,2},
				{7,3},
				{7,4},
				{7,5},
				{6,5},
				{5,5},
				{4,5},
				{3,5},
				{2,5},
				{1,5},
				{1,6},
				{2,6},
				{3,6},
				{4,6},
				{5,6},
				{6,6},
				{7,6},
				{8,6},
				{8,5},
				{8,4},
				{8,3},
				{8,2}
		};
		
		while (gameover == 0) {
			
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
			if(heroi_y==8 && heroi_x==7) {
				mapa[w1y][w1x]='S';
				mapa[w2y][w2x]='S';
			}
			
			mapa[guarda_xy[numero][1]][guarda_xy[numero][0]] = ' ';
			numero++;
			if(numero == 24)
				numero = 0;
			mapa[guarda_xy[numero][1]][guarda_xy[numero][0]] = 'G';
			
			if (heroi_x == guarda_xy[numero][0] && heroi_y == guarda_xy[numero][1])
				gameover = 1;
			else if (heroi_x == guarda_xy[numero][0] + 1 && heroi_y == guarda_xy[numero][1])
				gameover = 1;
			else if (heroi_x == guarda_xy[numero][0] - 1 && heroi_y == guarda_xy[numero][1])
				gameover = 1;
			else if (heroi_x == guarda_xy[numero][0] && heroi_y == guarda_xy[numero][1] + 1)
				gameover = 1;
			else if (heroi_x == guarda_xy[numero][0] && heroi_y == guarda_xy[numero][1] - 1)
				gameover = 1;

			char mapa2[][] = { 
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
					{ 'I', ' ', ' ', ' ', 'O', ' ', ' ', 'k', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
					{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', 'H', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
					{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
		}
	}
}
