package com.coding.challenge.dc;

class ScoreOfParentheses {
	ScoreOfParentheses() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert scoreOfParentheses("()") == 1;
		assert scoreOfParentheses("(())") == 2;
		assert scoreOfParentheses("()()") == 2;
		assert scoreOfParentheses("(()())(())") == 6;
		assert scoreOfParentheses("(())()(())()") == 6;
	}

	static int scoreOfParentheses(String s) {
		return findScore(s, 0, s.length() - 1);
	}

	private static int findScore(String s, int i, int j) {
		if (j == i + 1)
			return 1;
		for (int k = i, o = 0, c = 0; k <= j; k++) {
			if (s.charAt(k) == '(')
				o = o + 1;
			else
				c = c + 1;
			if (o == c) {
				if (k < j)
					return findScore(s, i, k) + findScore(s, k + 1, j);
				else
					return findScore(s, i + 1, j - 1) * 2;
			}
		}
		throw new AssertionError();
	}
}
