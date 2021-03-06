package dkeep.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dkeep.logic.*;

public class TestKeepGameLogic {

	Game game;
	public void initialize(char[][] map) {
		game = new Game();
		game.setMap(map);
	}
	char[][] testKeepMap = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X' }, 
			{ 'X', 'H', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', 'O', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'I', ' ', 'K', ' ', ' ', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X' } };

	@Test
	public void testHeroIsKilledByOgre() {
		initialize(testKeepMap);
		game.getHero().moveHero('d', testKeepMap, game);
		game.getHero().moveHero('d', testKeepMap, game);
		game.getHero().moveHero('s', testKeepMap, game);
		game.checkColisionOgreHero();
		assertEquals(1, game.gameOver);
	}
	
	@Test
	public void testHeroGetsKey() {
		initialize(testKeepMap);
		game.currentlvli = 2;
		assertEquals('H', game.getHero().getSymbol());
		game.getHero().moveHero('s', testKeepMap, game);
		game.getHero().moveHero('s', testKeepMap, game);
		game.getHero().moveHero('s', testKeepMap, game);
		game.getHero().moveHero('d', testKeepMap, game);
		game.checkColisionKey();
		assertEquals('K', game.getHero().getSymbol());
	}

	@Test
	public void testHeroTriesToLeaveWithoutKey() {
		initialize(testKeepMap);
		game.currentlvli = 2;
		game.getHero().moveHero('s', testKeepMap, game);
		game.getHero().moveHero('s', testKeepMap, game);
		game.getHero().moveHero('s', testKeepMap, game);
		game.getHero().moveHero('a', testKeepMap, game);
		assertEquals('I', testKeepMap[4][0]);
	}
	
	@Test
	public void testHeroTriesToOpenDoorWithKey() {

		Game game = new Game();
		game.currentlvli = 2;
		game.setMap(testKeepMap);
		assertEquals('H', game.getHero().getSymbol());
		game.getHero().moveHero('s', testKeepMap, game);
		game.getHero().moveHero('s', testKeepMap, game);
		game.getHero().moveHero('s', testKeepMap, game);
		game.getHero().moveHero('d', testKeepMap, game);
		game.checkColisionKey();
		game.getHero().moveHero('a', testKeepMap, game);
		game.getHero().moveHero('a', testKeepMap, game);
		assertEquals('s', testKeepMap[4][0]);}
	
	@Test
	public void testHeroWinGame() {

		Game game = new Game();
		game.currentlvli = 2;
		game.setMap(testKeepMap);
		assertEquals('H', game.getHero().getSymbol());
		game.getHero().moveHero('s', testKeepMap, game);
		game.getHero().moveHero('s', testKeepMap, game);
		game.getHero().moveHero('s', testKeepMap, game);
		game.getHero().moveHero('d', testKeepMap, game);
		game.checkColisionKey();
		game.getHero().moveHero('a', testKeepMap, game);
		game.getHero().moveHero('a', testKeepMap, game);
		assertEquals('s', testKeepMap[4][0]);}
}
