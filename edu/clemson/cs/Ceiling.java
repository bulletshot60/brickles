package edu.clemson.cs;
import java.awt.*;

class Ceiling extends StationaryPiece {
    protected Point _currentPosition2;

    public Ceiling(PlayingField fieldPtr, Point atPoint1, Point atPoint2) {
        super(fieldPtr, atPoint1);
        _currentPosition2 = atPoint2;
        this.newBoundingRect();
    }

    void newBoundingRect() {
        _boundingBox = new Rectangle(_currentPosition.x, _currentPosition.y,
            Math.abs(_currentPosition.x) + _currentPosition2.x, Math.abs(_currentPosition.y) + _currentPosition2.y);
    }

    public void collideWith(ArcadeGamePiece aPiece, Point atPoint) {
    }

    public void collideWithPaddle(Paddle aPaddle, Point atPoint) {
    }

    public void collideWithPuck(Puck aPuck, Point atPoint) {
        aPuck.reverseY();
    }
}
