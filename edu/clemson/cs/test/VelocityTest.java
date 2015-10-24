package edu.clemson.cs.test;

import org.junit.*;
import static org.junit.Assert.*;
import edu.clemson.cs.*;

public class VelocityTest {
	
	@Test
	public void testSetDirection() {
		Velocity out= new Velocity();
	    out.setDirection(45);
	    assertEquals("Result", 45, out.getDirection());
	}
	
	@Test
	public void testSetDirection2() {
		Velocity out= new Velocity(35,45);
	    assertEquals("Result", 45, out.getDirection());
	}
	
	@Test
	public void testSetDirection3() {
		Velocity out= new Velocity(35,45);
		/* Assert we have a valid object */
		assertNotNull(out);
		int s = (Integer)PrivateAccessor.getPrivateField(out, "direction");
		assertEquals(s, 45);
	}
	
	@Test
	public void testConstructor() {
		try {
			new RobustVelocity(-3,90);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testReverseX() {
		Velocity out= new Velocity(20,180);
	    out.reverseX();
	    //System.out.println("speed " + out.getSpeedX());
	    assertEquals("Result", 360, out.getDirection());
	    //assertEquals("Result", 20, out.getSpeedX());
	}
	
	@Test
	public void testReverseX2() {
		Velocity out= new Velocity(20,90);
	    out.reverseX();
	    assertEquals("Result", 90, out.getDirection());
	}

}
