package dkeep.logic;

import dkeep.gui.GamePanel;

/**	
 * Game Class
 * Main Class which has every object the game needs. Also has the functions that can keep the basic of the game flowing.
 */
public class Game {

	public int gameOver = 0; //0 = keep playing       1 = defeat         2 = victory
	public boolean doorsOpened = false;
	Lever lever;
	Key key;
	Hero hero;
	Guard guard;
	public Door[] doors = new Door[20];
	int nmrDoors=0;
	Ogre[] ogre = new Ogre[6];
	Level[] levels = new Level[10];
	int lvlcount = 0;
	Level level;
	public int currentlvli=0;

	/**
	 * 
	 */
	public Game() {
		level = new Level(1);
		addLevel(level);
		level = new Level(2);
		addLevel(level);
		changeLevel(currentlvli);
		this.findSomething();
	}

	/**
	 * 
	 */
	public void findSomething() {
		this.nmrDoors=0;
		resetDoors();
		for (int i = 0; i < level.map.length; i++) {

			for (int k = 0; k < level.map[i].length; k++) {

				switch(level.map[i][k]) {
				case 'H':
					hero = new Hero(i, k, 'H');
					level.eraseCell(i, k);
					break;
				case 'A':
					hero = new Hero(i, k, 'A');
					break;
				case 'G':
					guard = new Guard(i, k, 'G');
					level.eraseCell(i, k);
					break;
				case 'O':
					ogre[level.numOgres] = new Ogre(i, k, 'O');
					ogre[level.numOgres].possibleClubPos(level.map);
					level.numOgres++;
					level.eraseCell(i, k);
					break;
				case 'k':
					lever = new Lever(i,k,'k');
					break;
				case 'K':
					key = new Key(i,k,'K');
					break;
				case 'I':
					doors[nmrDoors] = new Door(i,k,'I');
					nmrDoors++;
					break;
				}
			}
		}
		checkIfDoorsOpenable();
		printMap();
	}
	
	/**
	 * @param personality
	 */
	public void setGuard(String personality) {
		if (guard != null) {
			if (personality == "Drunken") {
				guard = new DrunkenGuard(guard.getX(), guard.getY(), 'G');
			} else if (personality == "Suspicious") {
				guard = new SuspiciousGuard(guard.getX(), guard.getY(), 'G');
			} else
				guard = new RookieGuard(guard.getX(), guard.getY(), 'G');}}
	
	/**
	 * @param key
	 */
	public void handler(char key) {
		hero.moveHero(key, level.map, this);
		if (currentlvli == 1) {
			guard.moveGuard(level.map);
			checkColisionGuard();
		} else if (currentlvli == 2) {
			for (int j = 0; j < ogre.length; j++) {
				if(ogre[j]!=null) {
				ogre[j].moveOgre(level.map);}}
			checkColisionOgreHero();}
		checkColisionKey();
		printMap();}

	/**
	 * 
	 */
	public void checkColisionGuard() {

		if ((hero.getX() == guard.getX() && hero.getY() == guard.getY()) || (hero.getX() == guard.getX() && hero.getY() == guard.getY() + 1) || (hero.getX() == guard.getX() && hero.getY() == guard.getY() - 1) || (hero.getX() == guard.getX() + 1 && hero.getY() == guard.getY()) || (hero.getX() == guard.getX() - 1 && hero.getY() == guard.getY()))
			gameOver = 1;
	}

	/**
	 * 
	 */
	public void checkColisionOgreHero() {
		for (int j = 0; j < ogre.length; j++) {
			if(ogre[j]!=null) {
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
		}}
	}

	/**
	 * @param j
	 * @return
	 */
	public boolean checkColisionOgreClub(int j) {
		if (hero.getX() == ogre[j].getClubX() && hero.getY() == ogre[j].getClubY())return true;
		else if (hero.getX() == ogre[j].getClubX() && hero.getY() == ogre[j].getClubY() + 1)return true;
		else if (hero.getX() == ogre[j].getClubX() && hero.getY() == ogre[j].getClubY() - 1)return true;
		else if (hero.getX() == ogre[j].getClubX() + 1 && hero.getY() == ogre[j].getClubY())return true;
		else if (hero.getX() == ogre[j].getClubX() - 1 && hero.getY() == ogre[j].getClubY())return true;
		else return false;}

	/**
	 * 
	 */
	public void changeDoorsBoolean() {										//not needed
		if (doorsOpened) doorsOpened = false;
		else doorsOpened = true;}

	/**
	 * 
	 */
	public void checkColisionKey() {
		if (currentlvli == 1) {
			if (hero.getX() == lever.getX() && hero.getY() == lever.getY()) {
				lever.triggerKey();
				openDoors();}
		} else if (currentlvli == 2) {
			if (hero.getX() == key.getX() && hero.getY() == key.getY()) {
				hero.setHaskey();
				level.map[key.getX()][key.getY()] = ' ';}
			for (int j = 0; j < ogre.length; j++) {
				if (ogre[j] != null) {
					if (ogre[j].getX() == key.getX() && ogre[j].getY() == key.getY()) ogre[j].setSymbol('$');
					else ogre[j].setSymbol('O');}}}}

	/**
	 * 
	 */
	public void openDoors() {
		for(int i = 0 ; i < 20 ; i++) {
			if(doors[i]!=null) {
				if(doors[i].openable) {doors[i].openDoor();}}}
		for (int i = 0; i < level.map.length; i++) {
			for (int k = 0; k < level.map[i].length; k++) {
				if (i == 0 || k == 0 || i == level.map.length - 1 || k == level.map[0].length) {
					if (level.map[i][k] == 'I')level.map[i][k] = 's';
					else if (level.map[i][k] == 's')level.map[i][k] = 'I';}}}}

	/**
	 * 
	 */
	public void printMap() {
		for (int i = 0; i < level.map.length; i++) {
			for (int k = 0; k < level.map[i].length; k++) {
				boolean found = false;
				for (int j = 0; j < ogre.length; j++) {
					if (ogre[j] != null && ogre[j].getX() == i && ogre[j].getY() == k) {
						if (ogre[j].stunned == true) System.out.print('8');
						else System.out.print('O');
					} else if (!found && ogre[j] != null && ogre[j].clubX == i && ogre[j].clubY == k) {
						if (level.map[i][k] == 'k')System.out.print('$');
						else System.out.print('*');
					}
					found = true;}
				if (!found) {
					if (hero.getX() == i && hero.getY() == k) System.out.print(hero.getSymbol());
					else if (guard != null && guard.getX() == i && guard.getY() == k)System.out.print(guard.getSymbol());
					else System.out.print(level.map[i][k]);	}}
			System.out.println();}}
	
	/**
	 * @return
	 */
	public char[][] getMapArray() {
		return this.level.map;
	}

	/**
	 * @param l
	 */
	public void changeLevel(int l) {
		this.level = levels[l];
		this.hero = null;
		this.guard = null;
		this.findSomething();
		currentlvli++;
	}
	
	/**
	 * 
	 */
	public void checkIfDoorsOpenable() {
		for(int i = 0 ; i < 20 ; i++) {
			if(doors[i]!=null) {
				if(doors[i].getX()==0 || doors[i].getX()==this.level.map.length-1 || doors[i].getY()==0 || doors[i].getY()==this.level.map[0].length-1)
					doors[i].setOpenable();	}}}

	/**
	 * @param level
	 */
	public void addLevel(Level level) {
		levels[lvlcount] = level;
		lvlcount++;}
	
	/**
	 * 
	 */
	public void resetDoors() {
		for(int i = 0 ; i < doors.length ; i++) {
			doors[i]=null;}}
	
	/**
	 * @return
	 */
	public Level[] getLevels(){									//not needed
		return levels;
	}
	
	/**
	 * @param levels
	 */
	public void loadLevels(Level[] levels) {
		this.levels=levels;
	}
	
	/**
	 * @return
	 */
	public int getLevelcount() {								//not needed
		return this.lvlcount;
	}
	
	/**
	 * @return
	 */
	public Ogre[] getOgres() {
		return this.ogre;
	}
	
	/**
	 * @param n
	 */
	public void setOgres(int n) {
//		numOgres=n;
		levels[1].setOgres(n);
	}
	
	/**
	 * @return
	 */
	public Hero getHero() {
		return hero;
	}

	/**
	 * @return
	 */
	public Guard getGuard() {
		return guard;
	}
	
	/**
	 * @return
	 */
	public Lever getLever() {
		return lever;
	}

	/**
	 * @param map
	 */
	public void setMap(char[][] map) {
		levels[0].setMap(map);
		findSomething();
	}
	
	/**
	 * 
	 */
	public void gameResult() {										//not needed
		if(gameOver == 1) System.out.println("You Lost...");
		else System.out.println("You Won!");
	}
}
