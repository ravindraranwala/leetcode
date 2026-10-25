package com.coding.challenge.string;

class MinimumAddToMakeParenthesesValid {
	private static final char OPEN_BRACKET = '(';
	private static final char CLOSE_BRACKET = ')';

	MinimumAddToMakeParenthesesValid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minAddToMakeValid("())") == 1;
		assert minAddToMakeValid("(((") == 3;
	}

	static int minAddToMakeValid(String s) {
		int addedOpenBrackets = 0;
		int openBrackets = 0;
		for (char ch : s.toCharArray()) {
			if (ch == OPEN_BRACKET)
				openBrackets = openBrackets + 1;
			else if (ch == CLOSE_BRACKET && openBrackets == 0)
				addedOpenBrackets = addedOpenBrackets + 1;
			else
				openBrackets = openBrackets - 1;
		}
		return addedOpenBrackets + openBrackets;
	}
}
