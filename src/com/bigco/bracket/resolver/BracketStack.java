package com.bigco.bracket.resolver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author divviswa
 * Custom implementation of Stack extending the JDK stack class
 */
public class BracketStack extends Stack<BracketNode> {
	private static final long serialVersionUID = 1L;

	public BracketNode peekFirst() {
		int len = size();
		if(len > 0)
			return (BracketNode) this.elementData[0];
		return null;
	}
	
	public BracketNode removeFirst() {
		int len = size();
		if(len > 0) {
			BracketNode n = (BracketNode) this.elementData[0];
			this.elementData = Arrays.copyOfRange(this.elementData, 1, this.elementData.length);
			this.elementCount--;
			return n;
		}
		return null;
	}
	
	public Set<Integer> getInvalidpositions() {
		Set<Integer> invalidpositions = new HashSet<>();
		for(Object node : this.elementData) {
			BracketNode n = (BracketNode) node;
			if(n != null)
				invalidpositions.add(n.getPosition());
		}
		return invalidpositions;
	}
	
}