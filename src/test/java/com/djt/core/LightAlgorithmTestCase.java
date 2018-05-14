package com.djt.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class LightAlgorithmTestCase {

	@Test
	public void testInvalidAlgorithmType() {
		
		LightAlgorithmType type;
		try {
			type = LightAlgorithmType.valueOf("FooBar");
		} catch (IllegalArgumentException e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
		}
		
	}

	@Test
	public void testSequenceAlgorithmType() {
		
		LightAlgorithmType type= LightAlgorithmType.Alternate;
		try {
			type = LightAlgorithmType.valueOf("Sequence");
		} catch (IllegalArgumentException e) {
			fail("Expected to get a type");
		}
		assertEquals(type, LightAlgorithmType.Sequence);
	}

	@Test
	public void testColorAlgorithmType() {
		
		LightAlgorithmType type= LightAlgorithmType.Alternate;
		try {
			type = LightAlgorithmType.valueOf("Colour");
		} catch (IllegalArgumentException e) {
			fail("Expected to get a type");
		}
		assertEquals(type, LightAlgorithmType.Colour);
	}

}
