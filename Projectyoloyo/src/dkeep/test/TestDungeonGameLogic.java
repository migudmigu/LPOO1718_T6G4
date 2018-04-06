package dkeep.test;

import static org.junit.Assert.*;
import org.junit.Test;

import dkeep.logic.*;

public class TestDungeonGameLogic {
	
	Game game;
	public void initialize(char[][] map) {
		game = new Game();
		game.setMap(map);
	}
	char[][] testDungeonMap = {
			{'X','X','X','X','X','X'},
			{'X','H',' ','G',' ','X'},
			{'I',' ',' ',' ',' ','X'},
			{'I','k',' ',' ',' ','X'},
			{'X','X','X','X','X','X'}};
	
	@Test
	public void testMoveHeroIntoToFreeCell() {
		initialize(testDungeonMap);
		assertEquals(1,game.getHero().getX());
		assertEquals(1,game.getHero().getY());
		game.getHero().moveHero('s', testDungeonMap, game);
		assertEquals(2,game.getHero().getX());
		assertEquals(1,game.getHero().getY());}

	@Test
	public void testMoveHeroIntoWall() {
		initialize(testDungeonMap);
		assertEquals(1,game.getHero().getX());
		assertEquals(1,game.getHero().getY());
		game.getHero().moveHero('w', testDungeonMap, game);
		assertEquals(1,game.getHero().getX());
		assertEquals(1,game.getHero().getY());}
	
	@Test
	public void testHeroIsCapturedByGuardLeft() {
		initialize(testDungeonMap);
		game.getHero().moveHero('d', testDungeonMap, game);
		game.checkColisionGuard();
		assertEquals(1, game.gameOver);}
	
	@Test
	public void testHeroIsCapturedByGuardRight() {
		initialize(testDungeonMap);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.getHero().moveHero('d', testDungeonMap, game);
		game.getHero().moveHero('d', testDungeonMap, game);
		game.getHero().moveHero('d', testDungeonMap, game);
		game.getHero().moveHero('w', testDungeonMap, game);
		game.getHero().moveHero('w', testDungeonMap, game);
		game.checkColisionGuard();
		assertEquals(1, game.gameOver);}
	
	@Test
	public void testHeroIsCapturedByGuardDown() {
		initialize(testDungeonMap);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.getHero().moveHero('d', testDungeonMap, game);
		game.getHero().moveHero('d', testDungeonMap, game);
		game.checkColisionGuard();
		assertEquals(1, game.gameOver);}
	
	@Test
	public void testHeroFailsToLeave() {
		initialize(testDungeonMap);
		assertEquals(1, game.currentlvli);
		game.getHero().moveHero('a', testDungeonMap, game);
		assertEquals(1, game.currentlvli);}
	
	@Test
	public void testDoorsOpen() {
		initialize(testDungeonMap);
		assertEquals('I', testDungeonMap[2][0]);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.checkColisionKey();
		assertEquals('s', testDungeonMap[2][0]);}
	
	@Test
	public void testHeroLevelUp() {
		initialize(testDungeonMap);
		assertEquals(1, game.currentlvli);
		assertEquals('I', testDungeonMap[2][0]);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.getHero().moveHero('s', testDungeonMap, game);
		game.checkColisionKey();
		assertEquals('s', testDungeonMap[2][0]);
		game.getHero().moveHero('a', testDungeonMap, game);
		assertEquals(2, game.currentlvli);}
}
