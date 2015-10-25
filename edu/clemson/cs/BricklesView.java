package edu.clemson.cs;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import javafx.util.Pair;

/**
 *This class implements the View half of the Model/View architecture. It is an Applet to be able to run on remote browsers
 * It is a MouseMotionListener to "track" the mouse to move the paddle
 * It is a MouseListener to detect button presses to pause the game
 */
public class BricklesView extends JApplet implements MouseMotionListener, MouseListener {
    private static final long serialVersionUID = 1L;
    
	static final int fieldX = 0;
    static final int fieldY = 0;
    static final int fieldWidth = 440;
    static final int fieldHeight = 320;
    static final int _mouseSensitivity = 3;
    int flipflop;
    protected int xPaddle;
    protected int yPaddle;
    protected Puck thePuck;
    protected Paddle thePaddle;
    protected Brick theBrick;
    protected BrickPile theBrickPile;
    protected Dimension dim;
    protected BricklesGame _game;

    /** This is the default constructor that only adds the listeners */
    public BricklesView() {
        addMouseMotionListener(this);
        addMouseListener(this);
    }

    /** This routine initializes the drawing field and the off screen image used to improve the animation quality */
    public void init() {
        flipflop = 0;
        setBackground(Color.white);
        resize(fieldWidth, fieldHeight);
        dim = this.getSize();
        xPaddle = (int)(fieldWidth / 2);
        yPaddle = (int)(fieldHeight * .75);
    }

    /** THis is where the game starts It is the method called when the Applet is ready to start */
    public void start() {
        _game = new BricklesGame(this);
        _game.start();
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e) { }
        repaint();
    }

    /** Standard applet routine */
    public void update(Graphics g) {
        paint(g);
    }

    /**
     *This is the main routine for drawing the screen Several message are sent to the "model" to obtain current information
     * Only the location of the paddle is obtained directly from mouse events
     */
    public void paint(Graphics g) {
    	if(!_game.isOver()) {
	        g.setColor(getBackground());
	        g.fillRect(0, 0, dim.width, dim.height);
	        g.setColor(getForeground());
	        g.drawRect(1, 1, dim.width - 1, dim.height - 1);
	        g.drawImage(thePaddle.getBitMap(), thePaddle.getPosition().x, thePaddle.getPosition().y, this);
	        if (!(thePuck == null)) {
	            g.drawImage(thePuck.getBitMap(), thePuck.getPosition().x, thePuck.getPosition().y, this);
	        }
	        if (!(theBrickPile == null)) {
	            for (int i = 0; i < theBrickPile.getSize(); i++) {
	                theBrick = theBrickPile.getBrickAt(i);
	                if (!theBrick.isHit()) {
	                    g.drawImage(theBrick.getBitMap(), theBrick.getPosition().x, theBrick.getPosition().y, this);
	                }
	            }
	        }
    	} else {
    		try {
	    		if(_game.isWon()) {
	    			g.drawImage(ImageIO.read(new File("images/won.gif")), 0, 0, this);
	    		} else {
	    			g.drawImage(ImageIO.read(new File("images/lost.gif")), 0, 0, this);
	    		}
    		} catch (Exception e) {
    			;
    		}
    	}
        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e) { }
    }

    /** Updates the position of the mouse FlipFlop allows some mouse events to be ignored */
    public void mouseMoved(MouseEvent e) {
        flipflop++;
        //System.out.println("Inside\n");
        if ((flipflop % _mouseSensitivity) == 0) {
            //System.out.println("About to report x\n");
            //System.out.println("Mouse moved ! "+e.getX()+"\n");
            flipflop = 0;
            xPaddle = e.getX();
            thePaddle.setPosition(xPaddle, thePaddle.getPosition().y);
        }
        //	repaint();
    }

    public void mouseDragged(MouseEvent evt) {
    }

    public void mouseClicked(MouseEvent evt) {
    }

    public void mouseEntered(MouseEvent evt) {
    }

    public void mouseExited(MouseEvent evt) {
    }

    public void mousePressed(MouseEvent evt) {
    }

    public void mouseReleased(MouseEvent evt) {
    }

    /** Returns the width of the playingField */
    public int getFieldWidth() {
        return fieldWidth;
    }

    /** Returns the height of the playingField */
    public int getFieldHeight() {
        return fieldHeight;
    }

    protected void setPaddle(Paddle newPaddle) {
        thePaddle = newPaddle;
    }

    /** Gives the View a reference to the current Puck */
    protected void setPuck(Puck newPuck) {
        thePuck = newPuck;
    }

    /** Gives the View a reference to the BrickPile */
    protected void setBrickPile(BrickPile newBrickPile) {
        theBrickPile = newBrickPile;
    }

    /** Provides acces to the message window at the bottom of the Applet window */
    public void showMessage(String str) {
        showStatus(str);
    }

    /** Provides access to the current Paddle */
    protected Paddle getPaddle() {
        return thePaddle;
    }

    /** Provides access to the BrickPile */
    protected BrickPile getBrickPile() {
        return theBrickPile;
    }
    
    public BricklesGame getGame() {
    	return _game;
    }
    
    public Pair<Integer, Integer> getPuckPosition() {
    	return new Pair<Integer, Integer>(thePuck.getPosition().x, thePuck.getPosition().y);
    }
    
    public Pair<Integer, Integer> getPaddlePosition() {
    	return new Pair<Integer, Integer>(thePaddle.getPosition().x, thePaddle.getPosition().y);
    }
    
    public void setPuckPosition(Pair<Integer, Integer> position) {
    	thePuck.setPosition(position.getKey(), position.getValue());
    }
    
    public void setPaddlePosition(Pair<Integer, Integer> position) {
    	thePaddle.setPosition(position.getKey(), position.getValue());
    }
}
