package org.opensourcedea.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.opensourcedea.dea.ModelType;


public class MiscTest {
	
	@Test
	/**
	 * Prints the number of models available in the ModelType class.
	 */
	public void testTest() {
		System.out.println("The number of available models is: " + ModelType.getNumberOfModelsAvailable());
		assertTrue(true);
	}

	
}
