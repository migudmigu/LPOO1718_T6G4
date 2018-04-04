package dkeep.logic;

public class Game {

	public int gameOver = 0;
	public int levNum = 1;
	public boolean doorsOpened = false;
	Key key;
	Hero hero;
	Guard guard;
	public Door[] doors = new Door[20];
	int nmrDoors=0;
	Ogre[] ogre = new Ogre[3];
	Level[] levels = new Level[10];
	int lvlcount = 0;
	Level level;

	public Game() {
		level = new Level(1);
		addLevel(level);
		level = new Level(2);
		addLevel(level);
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
					guard = new Guard(i, k, 'G');
					level.eraseCell(i, k);
				} else if (level.map[i][k] == 'O') {

					ogre[ogreNumber] = new Ogre(i, k, 'O');
					ogre[ogreNumber].possibleClubPos(level.map);
					ogreNumber++;
					level.eraseCell(i, k);
				} else if (level.map[i][k] == 'k') {
					key = new Key(i,k,'k');
				} else if (level.map[i][k] == 'I') {
					nmrDoors++;
					doors[nmrDoors] = new Door(i,k,'I');
				}
			}
		}
		checkIfDoorsOpenable();
		printMap();
	}

	public void setGuard(String personality) {
		if (personality == "Drunken") {
			guard = new DrunkenGuard(guard.getX(), guard.getY(), 'G');
		} else if (personality == "Suspicious") {
			guard = new SuspiciousGuard(guard.getX(), guard.getY(), 'G');
		} else
			guard = new RookieGuard(guard.getX(), guard.getY(), 'G');
	}

	public void handler(char key) {

		if (hero.moveHero(key, level.map))
			changeLevel(2);

		if (levNum == 1) {
			guard.moveGuard(level.map);
			checkColisionGuard();
		} else if (levNum == 2) {

			for (int j = 0; j < ogre.length; j++) {

				ogre[j].moveOgre(level.map);
			}
			checkColisionOgreHero();
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

	public void checkColisionOgreHero() {
		for (int j = 0; j < ogre.length; j++) {

			if (hero.getX() == ogre[j].getX() && hero.getY() == ogre[j].getY()) // hero and ogre in the same position;
				gameOver = 1;
			else if (checkColisionOgreClub(j)) // hero dies to the ogre club
				gameOver = 1;
			else if (hero.getX() == ogre[j].getX() && hero.getY() == ogre[j].getY() + 1) // hero stuns the ogre
				ogre[j].stunOgre();
			else if (hero.getX() == ogre[j].getX() && hero.getY() == ogre[j].getY() - 1) // hero stuns the ogre
				ogre[j].stunOgre();
			else if (hero.getX() == ogre[j].getX() + 1 && hero.getY() == ogre[j].getY()) // hero stuns the ogre
				ogre[j].stunOgre();
			else if (hero.getX() == ogre[j].getX() - 1 && hero.getY() == ogre[j].getY()) // hero stuns the ogre
				ogre[j].stunOgre();
		}
	}

	public boolean checkColisionOgreClub(int j) {

		if (hero.getX() == ogre[j].getClubX() && hero.getY() == ogre[j].getClubY())
			return true;
		else if (hero.getX() == ogre[j].getClubX() && hero.getY() == ogre[j].getClubY() + 1)
			return true;
		else if (hero.getX() == ogre[j].getClubX() && hero.getY() == ogre[j].getClubY() - 1)
			return true;
		else if (hero.getX() == ogre[j].getClubX() + 1 && hero.getY() == ogre[j].getClubY())
			return true;
		else if (hero.getX() == ogre[j].getClubX() - 1 && hero.getY() == ogre[j].getClubY())
			return true;
		else
			return false;
	}

	public void changeDoorsBoolean() {					//in new DOOR CLASS

		if (doorsOpened)
			doorsOpened = false;
		else
			doorsOpened = true;
	}

	public void checkColisionKey() {

		if (levNum == 1) {
			if (hero.getX() == key.getX() && hero.getY() == key.getY()) {
				key.triggerKey();			// NECESSARIO?
				openDoors();
			}
		} else if (levNum == 2) {
			if (hero.getX() == key.getX() && hero.getY() == key.getY()) {
				hero.setSymbol('K');
				level.map[key.getX()][key.getY()] = ' ';
			}

			for (int j = 0; j < ogre.length; j++) {
				if (ogre[j].getX() == key.getX() && ogre[j].getY() == key.getY())
					ogre[j].setSymbol('$');
				else
					ogre[j].setSymbol('O');
			}
		}
	}

	public void openDoors() {

		for(int i = 0 ; i < 20 ; i++) {
			if(doors[i]!=null) {
				if(doors[i].openable) {
					System.out.println("test3");
					doors[i].openDoor();
				}
			}
		}
		
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
						// System.out.print(ogre[j].getSymbol());
						if (ogre[j].stunned == true)
							System.out.print('8');
						else
							System.out.print('O');
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

	// Function used in iteration 4
	public String getMapa() {
		String mapaString = "";
		for (int i = 0; i < level.map.length; i++) {

			for (int k = 0; k < level.map[i].length; k++) {

				boolean found = false;
				for (int j = 0; j < ogre.length; j++) {

					if (ogre[j] != null && ogre[j].getX() == i && ogre[j].getY() == k) {
						// System.out.print(ogre[j].getSymbol());
						if (ogre[j].stunned == true)
							mapaString += '8';
						else
							mapaString += 'O';
						found = true;
					} else if (!found && ogre[j] != null && ogre[j].clubX == i && ogre[j].clubY == k) {
						if (level.map[i][k] == 'k')
							mapaString += '$';
						else
							mapaString += '*';
						found = true;
					}
				}
				if (!found) {
					if (hero.getX() == i && hero.getY() == k)
						mapaString += hero.getSymbol();
					else if (guard != null && guard.getX() == i && guard.getY() == k) {
						mapaString += guard.getSymbol();
					} else {
						mapaString += level.map[i][k];
					}
				}
			}
			mapaString += '\n';
		}

		return mapaString;
	}

	public char[][] getMapArray() {
		return this.level.map;
	}

	public void changeLevel(int l) {

		levNum = l;
		this.level = null;
		this.level = new Level(l);
		this.hero = null;
		this.guard = null;
		this.findSomething();
	}
	
	public void checkIfDoorsOpenable() {
		for(int i = 0 ; i < 20 ; i++) {
			if(doors[i]!=null) {
				System.out.println("tst5");
				if(doors[i].getX()==0 || doors[i].getX()==this.level.map.length-1 || doors[i].getY()==0 || doors[i].getY()==this.level.map[0].length-1)
					doors[i].setOpenable();
			}
		}
	}

	public void addLevel(Level level) {
		levels[lvlcount] = level;
		lvlcount++;
	}
	
	public Level[] getLevels(){
		return levels;
	}
	
	public int getLevelcount() {
		return this.lvlcount;
	}
	
//	public int getKeyX() {
//		return keyX;
//	}
//
//	public int getKeyY() {
//		return keyY;
//	}

	public Hero getHero() {
		return hero;
	}

	public Guard getGuard() {
		return guard;
	}
	
	public Key getKey() {
		return key;
	}
}
