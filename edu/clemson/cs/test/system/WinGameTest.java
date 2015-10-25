package edu.clemson.cs.test.system;

import static org.junit.Assert.*;

import org.assertj.swing.applet.AppletViewer;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.assertj.swing.launcher.AppletLauncher;
import org.junit.Test;

import edu.clemson.cs.BricklesView;
import javafx.util.Pair;

public class WinGameTest extends AssertJSwingJUnitTestCase {
	AppletViewer viewer;
	
	@Override
	@SuppressWarnings("deprecation")
	protected void onSetUp() {
		viewer = AppletLauncher.applet(BricklesView.class).start();
		viewer.resize(450, 380);
	}
	
	@Test 
	public void shouldWinGameTest() {
		BricklesView applet = (BricklesView)viewer.getApplet();
		while(!applet.getGame().isOver()) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				;
			}
			try {
				Pair<Integer, Integer> puckPosition = applet.getGame().getView().getPuckPosition();
				Pair<Integer, Integer> paddlePosition = applet.getGame().getView().getPaddlePosition();
				applet.getGame().getView().setPaddlePosition(new Pair<Integer, Integer>(puckPosition.getKey(), paddlePosition.getValue()));
			} catch(Exception e) {
				System.out.println(e.getMessage());;
			}
		}
		assertTrue(applet.getGame().isWon());
	}
	
	@Override 
	public void onTearDown() {
		if(viewer != null) {
			viewer.unloadApplet();
		}
	}

}
