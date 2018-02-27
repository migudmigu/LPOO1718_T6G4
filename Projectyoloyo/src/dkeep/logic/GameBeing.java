package dkeep.logic;

public abstract class GameBeing {
	protected int x, y;
	protected char symbol;
	
	public GameBeing(int x, int y,char symbol) {
		this.x=x;
		this.y=y;
		this.symbol=symbol;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public void moveB(char tecla) {
		if (tecla == 'w') {
			this.y++;
//			if (!(mapa[heroi_y - 1][heroi_x] == 'X' || mapa[heroi_y - 1][heroi_x] == 'I')) {
//				mapa[heroi_y][heroi_x] = ' ';
//				heroi_y--;
//				mapa[heroi_y][heroi_x] = 'H';
//			}
		}
		if (tecla == 'a') {
			this.x--;
//			if (!(mapa[heroi_y][heroi_x - 1] == 'X' || mapa[heroi_y][heroi_x - 1] == 'I')) {
//				mapa[heroi_y][heroi_x] = ' ';
//				heroi_x--;
//				mapa[heroi_y][heroi_x] = 'H';
//			}
		}
		if (tecla == 'd') {
			this.x++;
//			if (!(mapa[heroi_y][heroi_x + 1] == 'X' || mapa[heroi_y][heroi_x + 1] == 'I')) {
//				mapa[heroi_y][heroi_x] = ' ';
//				heroi_x++;
//				mapa[heroi_y][heroi_x] = 'H';
//			}
		}
		if (tecla == 's') {
			this.y--;
//			if (!(mapa[heroi_y + 1][heroi_x] == 'X' || mapa[heroi_y + 1][heroi_x] == 'I')) {
//				mapa[heroi_y][heroi_x] = ' ';
//				heroi_y++;
//				mapa[heroi_y][heroi_x] = 'H';
//			}
		}
	}
}
