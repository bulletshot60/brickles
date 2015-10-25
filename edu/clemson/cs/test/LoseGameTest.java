package edu.clemson.cs.test;

import static org.junit.Assert.*;

import org.assertj.swing.applet.AppletViewer;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.assertj.swing.launcher.AppletLauncher;
import org.junit.Test;

import edu.clemson.cs.BricklesView;

public class LoseGameTest extends AssertJSwingJUnitTestCase {
	AppletViewer viewer;
	
	@Override
	@SuppressWarnings("deprecation")
	protected void onSetUp() {
		viewer = AppletLauncher.applet(BricklesView.class).start();
		viewer.resize(450, 380);
	}
	
	@Test 
	public void shouldLostGameTest() {
		BricklesView applet = (BricklesView)viewer.getApplet();
		while(!applet.getGame().isOver()) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {
				
			}
		}
		assertTrue(applet.getGame().isLost());
	}
	
	@Override 
	public void onTearDown() {
		if(viewer != null) {
			viewer.unloadApplet();
		}
	}

}
