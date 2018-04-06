package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;

import dkeep.logic.*;

public class TestDungeonGameLogic {

	char[][] testDungeonMap = {
			{'X','X','X','X','X','X'},
			{'X','H',' ','G',' ','X'},
			{'I',' ',' ',' ',' ','X'},
			{'I','k',' ',' ',' ','X'},
			{'X','X','X','X','X','X'}
	};
	
	@Test
	public void testMoveHeroIntoToFreeCell() {
		
		Game game = new Game();
		game.setMap(testDungeonMap);
		assertEquals(1,game.getHero().getX());
		assertEquals(1,game.getHero().getY());
		game.getHero().moveHero('s', testDungeonMap, game);
		assertEquals(2,game.getHero().getX());
		assertEquals(1,game.getHero().getY());
	}

	@Test
	public void testMoveHeroIntoWall() {
		
		Game game = new Game();
		game.setMap(testDungeonMap);
		assertEquals(1,game.getHero().getX());
		assertEquals(1,game.getHero().getY());
		game.getHero().moveHero('w', testDungeonMap, game);
		assertEquals(1,game.getHero().getX());
		assertEquals(1,game.getHero().getY());
	}
	
	@Test
	public void testHeroIsCapturedByGuardLeft() {
		
		Game game = new Game();
		game.setMap(testDungeonMap);
		game.getHero().moveHero('d', testDungeonMap, game);
		game.checkColisionGuard();
		assertEquals(1, game.gameOver);
	}
	
	@Test
	public void testHeroIsCapturedByGuardRight() {
		
		Game game = new Game();
		game.setMap(testDungeonMap);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.getHero().moveHero('d', testDungeonMap, game);
		game.getHero().moveHero('d', testDungeonMap, game);
		game.getHero().moveHero('d', testDungeonMap, game);
		game.getHero().moveHero('w', testDungeonMap, game);
		game.getHero().moveHero('w', testDungeonMap, game);
		game.checkColisionGuard();
		assertEquals(1, game.gameOver);
	}
	
	@Test
	public void testHeroIsCapturedByGuardDown() {
		
		Game game = new Game();
		game.setMap(testDungeonMap);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.getHero().moveHero('d', testDungeonMap, game);
		game.getHero().moveHero('d', testDungeonMap, game);
		game.checkColisionGuard();
		assertEquals(1, game.gameOver);
	}
	
	@Test
	public void testHeroFailsToLeave() {
		
		Game game = new Game();
		game.setMap(testDungeonMap);
		assertEquals(1, game.currentlvli);
		game.getHero().moveHero('a', testDungeonMap, game);
		assertEquals(1, game.currentlvli);
	}
	
	@Test
	public void testDoorsOpen() {
		
		Game game = new Game();
		game.setMap(testDungeonMap);
		assertEquals('I', testDungeonMap[2][0]);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.checkColisionKey();
		assertEquals('s', testDungeonMap[2][0]);
	}
	
	@Test
	public void testHeroLevelUp() {
		
		Game game = new Game();
		game.setMap(testDungeonMap);
		assertEquals(1, game.currentlvli);
		assertEquals('I', testDungeonMap[2][0]);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.checkColisionKey();
		assertEquals('s', testDungeonMap[2][0]);
		game.getHero().moveHero('a', testDungeonMap, game);
		assertEquals(2, game.currentlvli);
	}
}
