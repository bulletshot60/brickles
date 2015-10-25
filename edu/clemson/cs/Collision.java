package edu.clemson.cs;
import java.awt.*;

public class Collision extends Exception {
    private static final long serialVersionUID = 1L;
    
	protected MovablePiece mPiece;
    protected ArcadeGamePiece aPiece;
    protected Point location;
    
    public Collision(MovablePiece movablePiece, ArcadeGamePiece arcadeGamePiece, Point point) {
        location = point;
        mPiece = movablePiece;
        aPiece = arcadeGamePiece;
    }

    public void occur() {
        mPiece.collideWith(aPiece, location);
    }
}
