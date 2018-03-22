package dkeep.logic;

public class Game {

	public int gameOver = 0;
	public int levNum = 1;
	public int keyX, keyY;
	public boolean doorsOpened = false;
	Hero hero;
	Guard guard;
	Ogre ogre[];

	Level level = new Level();

	public Game() {

		this.findSomething();
	}

	public void findSomething() {

		for (int i = 0; i < level.map.length; i++) {

			for (int k = 0; k < level.map[i].length; k++) {

				if (level.map[i][k] == 'H') {
					hero = new Hero(i, k, 'H');
					level.eraseCell(i, k);
				} else if (level.map[i][k] == 'G') {
					guard = new Guard(i, k, 'G');
					level.eraseCell(i, k);
				} else if (level.map[i][k] == 'O') {
					ogre[0] = new Ogre(i, k, 'O');
					level.eraseCell(i, k);
				} else if (level.map[i][k] == 'k') {
					keyX = i;
					keyY = k;
				}
			}
		}
		
		printMap();
	}

	public void handler(char key) {
		hero.moveCharacter(key, level.map);
		
		if(levNum == 1) {
			guard.moveGuard(level.map);
			checkColisionGuard();
			checkColisionKey();
		}
	}
	
	public void checkColisionGuard() {
		
		if(hero.getX() == guard.getX() && hero.getY() == guard.getY())
			gameOver = 1;
		else if(hero.getX() == guard.getX() && hero.getY() == guard.getY()+1)
			gameOver = 1;
		else if(hero.getX() == guard.getX() && hero.getY() == guard.getY()-1)
			gameOver = 1;
		else if(hero.getX() == guard.getX()+1 && hero.getY() == guard.getY())
			gameOver = 1;
		else if(hero.getX() == guard.getX()-1 && hero.getY() == guard.getY())
			gameOver = 1;
	}
	
	public void changeDoorsBoolean() {
		
		if(doorsOpened)
			doorsOpened = false;
		else
			doorsOpened = true;
	}
	public void checkColisionKey() {
		
		if(hero.getX() == keyX && hero.getY() == keyY) {
			changeDoorsBoolean();
			openDoors();
		}
	}
	
	public void openDoors() {
		
		for (int i = 0; i < level.map.length; i++) {
			
			for (int k = 0; k < level.map[i].length; k++) {

				if(level.map[i][k] == 'I')
					level.map[i][k] = 's';
				else if(level.map[i][k] == 's')
					level.map[i][k] = 'I';
			}
		}
	}
	
	public void printMap() {

		for (int i = 0; i < level.map.length; i++) {
			for (int k = 0; k < level.map[i].length; k++) {
				if(hero.getX() == i && hero.getY() == k)
					System.out.print(hero.getSymbol());
				
				else if	(ogre != null) {
					if(ogre[0].getX() == i && ogre[0].getY() == k) 
						System.out.print(ogre[0].getSymbol());
				}
				else if(guard.getX() == i && guard.getY() == k) 
					System.out.print(guard.getSymbol());
				else
					System.out.print(level.map[i][k]);
			}
			System.out.println();
		}
	}
}
