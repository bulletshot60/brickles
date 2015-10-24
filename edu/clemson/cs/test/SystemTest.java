package edu.clemson.cs.test;

import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.junit.Assert.*;

import java.awt.Frame;

import org.assertj.swing.core.GenericTypeMatcher;

import static org.assertj.swing.finder.WindowFinder.findFrame;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.Test;

import edu.clemson.cs.BricklesView;

public class SystemTest extends AssertJSwingJUnitTestCase {

	@Override
	protected void onSetUp() {
		application(BricklesView.class).start();
		findFrame(new GenericTypeMatcher<Frame>(Frame.class) {
		  protected boolean isMatching(Frame frame) {
		    return "Your application title".equals(frame.getTitle()) && frame.isShowing();
		  }
		}).using(robot());
	}
	
	@Test
	public void testOpenWindow() {
		assertEquals(2, 2);
	}

}
