package edu.clemson.cs.test.unit;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.clemson.cs.BricklesPlayingField;
import edu.clemson.cs.BricklesView;
import edu.clemson.cs.Brick;
import edu.clemson.cs.Puck;
import java.awt.*;

public class BrickTests {
	public Brick initBrick(int x, int y) {
		BricklesView view = new BricklesView();
    	view.init();
    	view.start();
    	BricklesPlayingField playingField = new BricklesPlayingField(view.getGame());
    	Brick brick = new Brick(playingField, new Point(x, y), view);
    	return brick;
	}
	
    @Test
    public void constructorTest() {
    	Brick brick = initBrick(5, 5);
    	assertTrue(brick != null);
    }

    @Test
    public void collideWithPuckTest() {
    	Brick brick = initBrick(5, 5);
    	assertTrue(brick != null);
    	Puck puck = new Puck();
    	brick.collideWithPuck(puck, new Point(100, 100));
    	assertTrue(brick.isHit() == false);
    	brick = initBrick(150, 90);
    	brick.collideWithPuck(puck, new Point(6, 6));
    	assertTrue(brick.isHit() == true);
    }
    
    @Test
    public void isHitTest() {
    	Brick brick = initBrick(150, 90);
    	assertTrue(brick.isHit() == false);
    	Puck puck = new Puck();
    	brick.collideWithPuck(puck, new Point(6, 6));
    	assertTrue(brick.isHit() == true);
    }
}
