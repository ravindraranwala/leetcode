package com.coding.challenge.counting;

class MinimumInsertionsToBalanceParenthesesString {
	MinimumInsertionsToBalanceParenthesesString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minInsertions("(()))") == 1;
		assert minInsertions("())") == 0;
		assert minInsertions("))())(") == 3;
		assert minInsertions("((((((") == 12;
		assert minInsertions("(()))(()))()())))") == 4;
		assert minInsertions("(((()(()((())))(((()())))()())))(((()(()()((()()))") == 31;
	}

	static int minInsertions(String s) {
		final int n = s.length();
		int inserts = 0;
		int i = 0;
		int opening = 0;
		while (i < n) {
			while (i < n && s.charAt(i) == '(') {
				opening = opening + 1;
				i = i + 1;
			}
			int closing = 0;
			while (i < n && s.charAt(i) == ')') {
				closing = closing + 1;
				i = i + 1;
			}

			final int requiredOpening = (closing + 1) / 2;
			if (opening < requiredOpening) {
				inserts = inserts + requiredOpening - opening;
				opening = 0;
			} else
				opening = opening - requiredOpening;
			
			if (closing % 2 == 1)
				inserts = inserts + 1; // additional closing parentheses inserted.
		}
		/*
		 * handle the remaining ( if any. additional closing parentheses )) inserted for
		 * each corresponding (.
		 */
		inserts = inserts + opening * 2;
		return inserts;
	}
}
