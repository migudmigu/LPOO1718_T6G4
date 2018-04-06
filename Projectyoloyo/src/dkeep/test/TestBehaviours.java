package dkeep.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dkeep.logic.Game;

public class TestBehaviours {

	char[] path = { 'a', 's', 'd', 'w' };
	char[][] testGuardMap = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X' }, 
			{ 'X', ' ', ' ', 'G', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'I', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'I', 'H', ' ', ' ', 'k', 'X' },
			{ 'X', 'X', 'X', 'X', 'X', 'X' } };

	char[][] testOgreMap = { 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' }, 
			{ 'X', ' ', ' ', ' ', 'O', ' ', 'K', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
			{ 'I', 'A', ' ', ' ', ' ', ' ', ' ', 'X' }, 
			{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
	
	char[][] testSmallOgreMap = { 
			{ 'X', 'X', 'X', 'X', 'X' }, 
			{ 'X', ' ', ' ', ' ', 'X' },
			{ 'X', ' ', 'O', ' ', 'X' },
			{ 'I', ' ', 'A', ' ', 'X' }, 
			{ 'X', 'X', 'X', 'X', 'X' } };

	@Test
	public void testRookieGuardMovement() {

		Game game = new Game();
		game.setMap(testGuardMap);
		game.setGuard("Rookie");
		game.getGuard().setPath(path);

		assertEquals(1, game.getGuard().getX());
		assertEquals(3, game.getGuard().getY());

		game.getGuard().moveGuard(testGuardMap);
		assertEquals(1, game.getGuard().getX());
		assertEquals(2, game.getGuard().getY());

		game.getGuard().moveGuard(testGuardMap);
		assertEquals(2, game.getGuard().getX());
		assertEquals(2, game.getGuard().getY());

		game.getGuard().moveGuard(testGuardMap);
		assertEquals(2, game.getGuard().getX());
		assertEquals(3, game.getGuard().getY());

		game.getGuard().moveGuard(testGuardMap);
		assertEquals(1, game.getGuard().getX());
		assertEquals(3, game.getGuard().getY());
	}

	@Test(timeout = 1000)
	public void testDrunkenGuardSleeping() {

		Game game = new Game();
		game.setMap(testGuardMap);
		game.setGuard("Drunken");
		game.getGuard().setPath(path);
		int i = 0;

		while (i != 10) {

			if (game.getGuard().getAsleep())
				i++;
			game.getGuard().moveGuard(testGuardMap);
		}
	}

	@Test(timeout = 1000)
	public void testDrunkenGuardReverse() {

		Game game = new Game();
		game.setMap(testGuardMap);
		game.setGuard("Drunken");
		game.getGuard().setPath(path);
		int i = 0;

		while (i != 10) {
			if (game.getGuard().getReverse())
				i++;
			game.getGuard().moveGuard(testGuardMap);
		}
	}
	
	@Test(timeout = 1000)
	public void testSuspiciousGuardReverse() {

		Game game = new Game();
		game.setMap(testGuardMap);
		game.setGuard("Suspicious");
		game.getGuard().setPath(path);
		int i = 0;

		while (i != 10) {
			if (game.getGuard().getReverse())
				i++;
			game.getGuard().moveGuard(testGuardMap);
		}
	}
	
	@Test(timeout = 1000)
	public void testStunOgre() {

		Game game = new Game();
		game.setMap(testSmallOgreMap);
		char[] path = {'s', 'w', 'w', 's', 'a', 'a', 's', 's', 's', 's' };
		
		int i = 0;
		while (i != path.length) {
			game.checkColisionOgreHero();
			game.getOgres()[0].moveOgre(testSmallOgreMap);
			game.getHero().moveHero('d', testSmallOgreMap, game);
			i++;
		}
	}
}
