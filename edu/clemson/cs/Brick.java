package edu.clemson.cs;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *The general class for Bricks.
 *@author John D. McGregor
 *@version 1.0
 */
class Brick extends StationaryPiece {
    protected boolean _isHit;

    /**
     *The constructor initializes the display attributes of the Brick.
     *@param fieldPtr The playingField in which the Brick will reside
     *@param initialPosition Its positionin that playingField
     *@param theView that will show the Brick
     */
    public Brick(BricklesPlayingField fieldPtr, Point initialPosition, BricklesView theView) {
        super(fieldPtr, initialPosition);
        try {
			_bitmap = ImageIO.read(new File("images/brick.gif"));
		} catch (IOException e) {
			_bitmap = null;
		}
        if (_bitmap == null)
            theView.showStatus("BitMap not loaded");
        _extent = new Dimension(60, 20);
        _isHit = false;
        _boundingBox = new Rectangle(_currentPosition, _extent);
    }

    /**
     *Since a Brick is stationary it can not collide with a Paddle
     *@param aPaddle the paddle in the playingField
     *@param aPoint the point of collision
     */
    public void collideWithPaddle(Paddle aPaddle, Point aPoint) {
    }

    /**
     *@param aPaddle the paddle in the playingField
     *@param aPoint the point of collision
     */
    public void collideWithPuck(Puck aPuck, Point aPoint) {
        if (this._boundingBox.intersects(aPuck.getBoundingBox()) && !_isHit) {
            aPuck.reverseY();
            _isHit = true;
        }
    }

    /** Accessor used to test condition */
    public boolean isHit() {
        return _isHit;
    }
}
