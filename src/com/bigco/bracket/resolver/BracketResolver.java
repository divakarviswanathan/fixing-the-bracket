package com.bigco.bracket.resolver;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import com.bigco.bracket.resolver.constants.BracketResolverConstants;

/**
 * @author divviswa
 *
 */

public class BracketResolver {
	
	public static void main(String[] args) {
		BracketResolver resolver = new BracketResolver();
		Scanner scanner = new Scanner(System.in);
		int mode;
		try {
			while(true) {
				System.out.println("Press \n 1 for Simple Mode \n 2 for Complexmode \n 0 To quit");
				mode = scanner.nextInt();
				
				if(mode == 0)
					break;
				
				scanner.nextLine();//To consume the new line character entered with the program mode 
				
				System.out.println("Enter the bracket description");
				String s = scanner.nextLine();
				
				if (mode == 1) {
					System.out.println(resolver.isValidSequence(s) ? BracketResolverConstants.VALID_SEQUENCE 
							: BracketResolverConstants.IN_VALID_SEQUENCE);
				} else if (mode == 2) {
					resolver.printIfFixed(s, resolver.fixTheDescription(s));
				}
				
			}
		} finally {
			scanner.close();
		}
	}
	
	/**
	 * @param original
	 * @param modified
	 * 
	 * Prints the modified version of the description
	 */
	public void printIfFixed(String original, String modified) {
		if(!original.equals(modified)) {
			System.out.println("Fixed version of " + original + "\t"+modified);
		}
	}
	
	/**
	 * @param sequence
	 * @return
	 * 
	 * Returns the best possible fixed description, if invalid. 
	 */
	public String fixTheDescription(String sequence) {
		if (isValidSequence(sequence)) {
			return sequence;
		} else if(sequence != null) {
			BracketStack myStack = new BracketStack();
			for (int i = 0; i < sequence.length(); i++) {
				char c = sequence.charAt(i);
				if (c != BracketResolverConstants.BRACKET) {
					if (BracketResolverConstants.BRACKET_MATCHER.containsKey(c)) {
						try {
							if (myStack.peek() != null && BracketResolverConstants.BRACKET_MATCHER.get(c)
									.equals(myStack.peek().getParantheses())) {
								myStack.pop();
							} else {
								if (myStack.peekFirst() != null && BracketResolverConstants.BRACKET_MATCHER.get(c)
										.equals(myStack.peekFirst().getParantheses())) {
									myStack.removeFirst();
								} else {
									myStack.push(new BracketNode(c, i));
								}
							}
						} catch (EmptyStackException ece) {
							myStack.push(new BracketNode(c, i));
						}
					} else {
						myStack.push(new BracketNode(c, i));
					}
				}
			}
			Set<Integer> invalidpositions = myStack.getInvalidpositions();
			StringBuilder correctedVersion = new StringBuilder();
			for (int i = 0; i < sequence.length(); i++) {
				if (!invalidpositions.contains(i)) {
					correctedVersion.append(sequence.charAt(i));
				}
			}
			return correctedVersion.toString();
		} else {
			return "";
		}
		
	}
	
	/**
	 * @param sequence
	 * @return
	 * 
	 * Checks if the sequence is valid
	 */
	public boolean isValidSequence(String sequence) {
		if (sequence != null) {
			Stack<Character> charStack = new Stack<>();
			for (int i = 0; i < sequence.length(); i++) {
				char c = sequence.charAt(i);
				if (c != BracketResolverConstants.BRACKET) {
					if (!BracketResolverConstants.BRACKET_MATCHER.containsKey(c)) {
						charStack.push(c);
					} else {
						try {
							if (charStack.pop() != BracketResolverConstants.BRACKET_MATCHER.get(c)) {
								return false;
							}
						} catch (EmptyStackException ece) {
							return false;
						}
					}
				}
			}
			return charStack.isEmpty();
		} else {
			return false;
		}
	}

}
