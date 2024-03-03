package com.coding.challenge.counting;

class MinimumAddToMakeParenthesesValid {
	MinimumAddToMakeParenthesesValid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minAddToMakeValid("())") == 1;
		assert minAddToMakeValid("(((") == 3;
		assert minAddToMakeValid("()))((") == 4;
	}

	static int minAddToMakeValid(String s) {
		int open = 0;
		int closed = 0;
		int inserts = 0;
		final int n = s.length();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(')
				open = open + 1;
			else
				closed = closed + 1;
			if (closed > open + inserts)
				inserts = inserts + 1;
		}

		if (open + inserts > closed)
			inserts = inserts + open + inserts - closed;
		return inserts;
	}
}
