package dkeep.logic;

public class Game {

	public int gameOver = 0;
	public int levNum = 1;
	public int keyX = 0, keyY = 0;
	public boolean doorsOpened = false;
	Hero hero;
	SuspiciousGuard guard;
	Ogre[] ogre = new Ogre[3];;

	Level level = new Level(1);

	public Game() {

		this.findSomething();
	}

	public void findSomething() {

		int ogreNumber = 0;

		for (int i = 0; i < level.map.length; i++) {

			for (int k = 0; k < level.map[i].length; k++) {

				if (level.map[i][k] == 'H') {
					
					hero = new Hero(i, k, 'H');
					level.eraseCell(i, k);
				} else if (level.map[i][k] == 'A') {
					
					hero = new Hero(i, k, 'A');
					level.eraseCell(i, k);
				} else if (level.map[i][k] == 'G') {
					
					guard = new SuspiciousGuard(i, k, 'G');
					level.eraseCell(i, k);
				} else if (level.map[i][k] == 'O') {

					ogre[ogreNumber] = new Ogre(i, k, 'O');
					ogre[ogreNumber].possibleClubPos(level.map);
					ogreNumber++;
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
		if (hero.moveHero(key, level.map))
			changeLevel(2);

		if (levNum == 1) {
			guard.moveSuspiciousGuard(level.map);
			checkColisionGuard();
		} else if (levNum == 2) {

			for (int j = 0; j < ogre.length; j++) {

				ogre[j].moveOgre(level.map);
			}
			checkColisionOgreClub();
		}

		checkColisionKey();
	}

	public void checkColisionGuard() {

		if (hero.getX() == guard.getX() && hero.getY() == guard.getY())
			gameOver = 1;
		else if (hero.getX() == guard.getX() && hero.getY() == guard.getY() + 1)
			gameOver = 1;
		else if (hero.getX() == guard.getX() && hero.getY() == guard.getY() - 1)
			gameOver = 1;
		else if (hero.getX() == guard.getX() + 1 && hero.getY() == guard.getY())
			gameOver = 1;
		else if (hero.getX() == guard.getX() - 1 && hero.getY() == guard.getY())
			gameOver = 1;
	}

	public void checkColisionOgreClub() {

		for (int j = 0; j < ogre.length; j++) {

			if (hero.getX() == ogre[j].clubX && hero.getY() == ogre[j].clubY)
				gameOver = 1;
			else if (hero.getX() == ogre[j].clubX && hero.getY() == ogre[j].clubY + 1)
				gameOver = 1;
			else if (hero.getX() == ogre[j].clubX && hero.getY() == ogre[j].clubY - 1)
				gameOver = 1;
			else if (hero.getX() == ogre[j].clubX + 1 && hero.getY() == ogre[j].clubY)
				gameOver = 1;
			else if (hero.getX() == ogre[j].clubX - 1 && hero.getY() == ogre[j].clubY)
				gameOver = 1;
		}
	}

	public void changeDoorsBoolean() {

		if (doorsOpened)
			doorsOpened = false;
		else
			doorsOpened = true;
	}

	public void checkColisionKey() {

		if (levNum == 1) {
			if (hero.getX() == keyX && hero.getY() == keyY) {
				changeDoorsBoolean();
				openDoors();
			}
		} else if (levNum == 2) {
			if (hero.getX() == keyX && hero.getY() == keyY) {
				hero.setSymbol('K');
				level.map[keyX][keyY] = ' ';
			}

			for (int j = 0; j < ogre.length; j++) {
				if (ogre[j].getX() == keyX && ogre[j].getY() == keyY)
					ogre[j].setSymbol('$');
				else
					ogre[j].setSymbol('O');
			}
		}
	}

	public void openDoors() {

		for (int i = 0; i < level.map.length; i++) {

			for (int k = 0; k < level.map[i].length; k++) {

				if (i == 0 || k == 0 || i == level.map.length - 1 || k == level.map[0].length) {
					if (level.map[i][k] == 'I')
						level.map[i][k] = 's';
					else if (level.map[i][k] == 's')
						level.map[i][k] = 'I';
				}

			}
		}
	}

	public void printMap() {

		for (int i = 0; i < level.map.length; i++) {
			for (int k = 0; k < level.map[i].length; k++) {

				boolean found = false;
				for (int j = 0; j < ogre.length; j++) {

					if (ogre[j] != null && ogre[j].getX() == i && ogre[j].getY() == k) {
						System.out.print(ogre[j].getSymbol());
						found = true;
					} else if (!found && ogre[j] != null && ogre[j].clubX == i && ogre[j].clubY == k) {
						if (level.map[i][k] == 'k')
							System.out.print('$');
						else
							System.out.print('*');
						found = true;
					}
				}
				if (!found) {
					if (hero.getX() == i && hero.getY() == k)
						System.out.print(hero.getSymbol());
					else if (guard != null && guard.getX() == i && guard.getY() == k) {
						System.out.print(guard.getSymbol());
					} else {
						System.out.print(level.map[i][k]);
					}
				}
			}
			System.out.println();
		}
	}

	public void changeLevel(int l) {

		levNum = l;
		this.level = null;
		this.level = new Level(l);
		this.hero = null;
		this.guard = null;
		this.findSomething();

	}

	public int getKeyX() {
		return keyX;
	}

	public int getKeyY() {
		return keyY;
	}
}
