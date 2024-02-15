package com.coding.challenge.counting;

class MaximumNestingDepthOfParentheses {
	MaximumNestingDepthOfParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxDepth("(1+(2*3)+((8)/4))+1") == 3;
	}

	static int maxDepth(String s) {
		final int n = s.length();
		int d = 0;
		for (int i = 0, open = 0, closed = 0; i < n; i++) {
			if (s.charAt(i) == '(')
				open = open + 1;
			else if (s.charAt(i) == ')')
				closed = closed + 1;
			d = Math.max(d, open - closed);
		}
		return d;
	}
}
