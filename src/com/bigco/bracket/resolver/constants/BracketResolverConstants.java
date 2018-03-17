package com.bigco.bracket.resolver.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author divviswa
 *
 */
public class BracketResolverConstants {

	public final static char BRACKET = 'B';
	public final static Map<Character, Character> BRACKET_MATCHER = new HashMap<>();
	static {
		BRACKET_MATCHER.put(')','(');
		BRACKET_MATCHER.put('}','{');
		BRACKET_MATCHER.put(']','[');
	}
	
	public final static String VALID_SEQUENCE = "OKAY";
	public final static String IN_VALID_SEQUENCE = "BAD";
}
