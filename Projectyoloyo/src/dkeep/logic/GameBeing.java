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
	
	public void moveB(char tecla, Map map) {
		if (tecla == 'w') {
			if (!(map.getMapa()[this.getY()-1][this.getX()] == 'X' || map.getMapa()[this.getY()-1][this.getX()] == 'I')) {
				this.y--;
			}
		}
		if (tecla == 'a') {
			if (!(map.getMapa()[this.getY()][this.getX()-1] == 'X' || map.getMapa()[this.getY()][this.getX()-1] == 'I')) {
				this.x--;
			}
		}
		if (tecla == 'd') {
			if (!(map.getMapa()[this.getY()][this.getX()+1] == 'X' || map.getMapa()[this.getY()][this.getX()+1] == 'I')) {
				this.x++;
			}
		}
		if (tecla == 's') {
			if (!(map.getMapa()[this.getY()+1][this.getX()] == 'X' || map.getMapa()[this.getY()+1][this.getX()] == 'I')) {
				this.y++;
			}
		}
	}

	public static int checkColision(Hero hero, Guard guard) {
		if (hero.getX() == guard.getX() && hero.getY() == guard.getY())
			return 1;
		else if(hero.getX() == guard.getX() && (hero.getY() == guard.getY() + 1 || hero.getY() == guard.getY() - 1))
			return 1;
		else if (hero.getY() == guard.getY() && (hero.getX() == guard.getX() + 1 || hero.getX() == guard.getX() - 1))
			return 1;
		return 0;
	}
}
