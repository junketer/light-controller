package com.djt.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTestCase {

	@Test
	public void testNoArgs() {
		int RC = Main.run(new String[0]);
		assertNotEquals(0, RC);
	}

	
	@Test
	public void testInvalidArgs() {
		int RC = Main.run(new String[] {"FooBar"} );
		assertNotEquals(0, RC);
		assertEquals(Main.RC_UNKNOWN, RC);
		
	}
	

	@Test
	public void testSequence() {
		Main.runOnce("Sequence");
		
	}
	
	@Test
	public void testColour() {
		Main.runOnce("Colour");
		
	}
	
	@Test
	public void testAlternate() {
		Main.runOnce("Alternate");
		
	}
}
