package com.bigco.bracket.resolver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author divviswa
 *
 */
class BracketResolverTest {

	private static BracketResolver resolver = new BracketResolver();
	
	@Test
	void testValidSequence() {
		assertTrue(resolver.isValidSequence("(B)"));
	}
	
	@Test
	void testEmptySequence() {
		assertTrue(resolver.isValidSequence(""));
	}
	
	@Test
	void testInValidSequence() {
		assertFalse(resolver.isValidSequence("[{B}"));
	}
	
	@Test
	void testNullSequence() {
		assertFalse(resolver.isValidSequence(null));
	}
	
	@Test
	void testDescriptionFixSample1() {
		String expected = "[B]";
		assertEquals(expected, resolver.fixTheDescription("[{B]"));
	}
	
	@Test
	void testDescriptionFixSample2() {
		String expected = "{(B)}{(B)(B)}";
		assertEquals(expected, resolver.fixTheDescription("{(B)}{(B)(B)}]"));
	}
	
	@Test
	void testDescriptionFixNull() {
		String expected = "";
		assertEquals(expected, resolver.fixTheDescription(null));
	}
	
	@Test
	void testDescriptionFixEmpty() {
		String expected = "";
		assertEquals(expected, resolver.fixTheDescription(""));
	}
	
	@Test
	void testDescriptionFixUnbalanced() {
		String expected = "[{(B]})";
		assertEquals(expected, resolver.fixTheDescription("[{(B]})"));
	}
}
