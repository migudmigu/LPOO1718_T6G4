package dkeep.logic;

import dkeep.cli.Game;

public class Key extends GameBeing {

	private boolean haskey = false;

	public Key(int x, int y) {
		super(x, y, 'k');
	}

	public void setHeroHasKey() {
		
		this.haskey = true;
	}

	public boolean getHeroHasKey() {
		
		return haskey;
	}
	
	public void findKey(Game game) {
		
		if(getHeroHasKey())
			return;
		else {
			
			if(game.getHero().getX() == this.getX() && game.getHero().getY() == this.getY()) {
				setHeroHasKey();
				game.getHero().setSymbol('K');
				game.getKey().setSymbol(' ');
			}
			else
				return;
		}
	}

}