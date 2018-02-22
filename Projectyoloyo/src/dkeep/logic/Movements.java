public class Movements {
	
	public void heroMove(char tecla, Map map, Heroi heroi){
		
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
	}
}