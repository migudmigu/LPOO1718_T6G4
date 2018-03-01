package dkeep.logic;

import dkeep.cli.Game;

public abstract class GameBeing {
	protected int x, y;
	protected char symbol;

	public GameBeing(int x, int y, char symbol) {
		this.x = x;
		this.y = y;
		this.symbol = symbol;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public void moveB(char tecla, Map map) {
		if (tecla == 'w') {
			if (!(map.getMapa()[this.getY() - 1][this.getX()] == 'X'
					|| map.getMapa()[this.getY() - 1][this.getX()] == 'I')) {
				this.y--;
			}
		}
		if (tecla == 'a') {
			if (!(map.getMapa()[this.getY()][this.getX() - 1] == 'X'
					|| map.getMapa()[this.getY()][this.getX() - 1] == 'I')) {
				this.x--;
			}
		}
		if (tecla == 'd') {
			if (!(map.getMapa()[this.getY()][this.getX() + 1] == 'X'
					|| map.getMapa()[this.getY()][this.getX() + 1] == 'I')) {
				this.x++;
			}
		}
		if (tecla == 's') {
			if (!(map.getMapa()[this.getY() + 1][this.getX()] == 'X'
					|| map.getMapa()[this.getY() + 1][this.getX()] == 'I')) {
				this.y++;
			}
		}
	}

	public static int checkColision(Game game) {

		if (game.getMap().getM() == 1) {

			if (game.getHero().getX() == game.getGuard().getX() && game.getHero().getY() == game.getGuard().getY())
				return 1;
			else if (game.getHero().getX() == game.getGuard().getX()
					&& (game.getHero().getY() == game.getGuard().getY() + 1
							|| game.getHero().getY() == game.getGuard().getY() - 1))
				return 1;
			else if (game.getHero().getY() == game.getGuard().getY()
					&& (game.getHero().getX() == game.getGuard().getX() + 1
							|| game.getHero().getX() == game.getGuard().getX() - 1))
				return 1;
			return 0;
		} else {
			if (game.getHero().getX() == game.getOgre().getX() && game.getHero().getY() == game.getOgre().getY())
				return 1;
			else if (game.getHero().getX() == game.getOgre().getX()
					&& (game.getHero().getY() == game.getOgre().getY() + 1
							|| game.getHero().getY() == game.getOgre().getY() - 1))
				return 1;
			else if (game.getHero().getY() == game.getOgre().getY()
					&& (game.getHero().getX() == game.getOgre().getX() + 1
							|| game.getHero().getX() == game.getOgre().getX() - 1))
				return 1;
			return 0;
		}
	}
}
