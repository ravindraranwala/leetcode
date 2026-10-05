package com.coding.challenge.recursion;

class ScoreOfParentheses {
	private static final char OPEN_BRACKET = '(';
	private static final char CLOSE_BRACKET = ')';

	ScoreOfParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert scoreOfParentheses("()") == 1;
		assert scoreOfParentheses("(())") == 2;
		assert scoreOfParentheses("()()") == 2;
		assert scoreOfParentheses("(()(()))") == 6;
	}

	static int scoreOfParentheses(String s) {
		return parse(s, 0)[0] / 2;
	}

	private static int[] parse(String s, int i) {
		if (s.charAt(i) == CLOSE_BRACKET)
			return new int[] { 1, i + 1 };

		int sum = 0;
		int j = i;
		final int n = s.length();
		while (j < n && s.charAt(j) == OPEN_BRACKET) {
			final int[] a = parse(s, j + 1);
			sum = sum + a[0];
			j = a[1];
		}
		return new int[] { sum * 2, Math.min(j + 1, n) };
	}
}
