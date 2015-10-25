package edu.clemson.cs.test.unit;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.clemson.cs.BricklesGame;
import edu.clemson.cs.BricklesView;

public class BricklesGameTests {
	public BricklesGame initGame() {
		BricklesView view = new BricklesView();
		view.init();
		view.start();
		return view.getGame();
	}
	
	@Test
	public void testConstructor() {
		BricklesGame game = initGame();
		new BricklesGame(game.getView());
		assertTrue(true); // no exception thrown
	}
	
	@Test
	public void testGetView() {
		BricklesGame game = initGame();
		assertTrue(game.getView() instanceof BricklesView);
	}
	
	@Test
	public void testWon() {
		BricklesGame game = initGame();
		assertTrue(game.isLost() == false);
		assertTrue(game.isOver() == false);
		assertTrue(game.isWon() == false);
		game.won();
		assertTrue(game.isLost() == false);
		assertTrue(game.isOver() == true);
		assertTrue(game.isWon() == true);
	}
	
	@Test 
	public void testLost() {
		BricklesGame game = initGame();
		assertTrue(game.isLost() == false);
		assertTrue(game.isOver() == false);
		assertTrue(game.isWon() == false);
		game.lost();
		assertTrue(game.isLost() == true);
		assertTrue(game.isOver() == true);
		assertTrue(game.isWon() == false);
	}
}
