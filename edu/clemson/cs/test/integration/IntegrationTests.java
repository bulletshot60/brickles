package edu.clemson.cs.test.integration;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.clemson.cs.BricklesView;
import javafx.util.Pair;

public class IntegrationTests {
	@Test
	public void gameLosableTest() {
		BricklesView view = new BricklesView();
		view.init();
		view.start();
		assertTrue(view != null);
		assertTrue(view.getGame().isOver() == false);
		assertTrue(view.getGame().isWon() == false);
		assertTrue(view.getGame().isLost() == false);
		view.getGame().lost();
		assertTrue(view.getGame().isOver() == true);
		assertTrue(view.getGame().isLost() == true);
		assertTrue(view.getGame().isWon() == false);
	}
	
	@Test
	public void gameLosableWinnable() {
		BricklesView view = new BricklesView();
		view.init();
		view.start();
		assertTrue(view != null);
		assertTrue(view.getGame().isOver() == false);
		assertTrue(view.getGame().isWon() == false);
		assertTrue(view.getGame().isLost() == false);
		view.getGame().won();
		assertTrue(view.getGame().isOver() == true);
		assertTrue(view.getGame().isWon() == true);
		assertTrue(view.getGame().isLost() == false);
	}
	
	@Test
	public void puckPositionObtainable() {
		BricklesView view = new BricklesView();
		view.init();
		view.start();
		assertTrue(view != null);
		assertTrue(view.getGame().getView().getPuckPosition() != null);
	}
	
	@Test
	public void paddlePositionObtainable() {
		BricklesView view = new BricklesView();
		view.init();
		view.start();
		assertTrue(view != null);
		assertTrue(view.getGame().getView().getPaddlePosition() != null);
	}
	
	@Test
	public void puckPositionSettable() {
		BricklesView view = new BricklesView();
		view.init();
		view.start();
		assertTrue(view != null);
		assertTrue(view.getGame().getView().getPuckPosition() != null);
		Pair<Integer, Integer> pair = new Pair<Integer, Integer>(1, 1);
		view.getGame().getView().setPuckPosition(pair);
		assertTrue(view.getGame().getView().getPuckPosition() != pair);
	}
	
	@Test
	public void paddlePositionSettable() {
		BricklesView view = new BricklesView();
		view.init();
		view.start();
		assertTrue(view != null);
		assertTrue(view.getGame().getView().getPaddlePosition() != null);
		Pair<Integer, Integer> pair = new Pair<Integer, Integer>(1, 1);
		view.getGame().getView().setPaddlePosition(pair);
		assertTrue(view.getGame().getView().getPaddlePosition() != pair);
	}
}
