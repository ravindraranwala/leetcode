package com.coding.challenge.stack;

class MaximumNestingDepthOfTheParentheses {
	private static final char OPEN_BRACKET = '(';
	private static final char CLOSE_BRACKET = ')';

	MaximumNestingDepthOfTheParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxDepth("(1+(2*3)+((8)/4))+1") == 3;
		assert maxDepth("(1)+((2))+(((3)))") == 3;
		assert maxDepth("()(())((()()))") == 3;
	}

	static int maxDepth(String s) {
		int d = 0;
		int currDepth = 0;
		for (char ch : s.toCharArray()) {
			if (ch == OPEN_BRACKET) {
				currDepth = currDepth + 1;
				d = Math.max(d, currDepth);
			} else if (ch == CLOSE_BRACKET)
				currDepth = currDepth - 1;
		}
		return d;
	}
}
