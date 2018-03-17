package com.bigco.bracket.resolver;

/**
 * @author divviswa
 *
 */
public class BracketNode {
	private char parantheses;
	private int position;
	
	BracketNode(char c, int position) {
		this.parantheses = c;
		this.position = position;
	}
	
	public char getParantheses() {
		return parantheses;
	}
	public void setParantheses(char parantheses) {
		this.parantheses = parantheses;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
	
}
