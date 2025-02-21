package com.coding.challenge.backtracking;

class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
	private int cnt = 0;
	private final StringBuilder ans = new StringBuilder();

	TheKthLexicographicalStringOfAllHappyStringsOfLengthN() {

	}

	public static void main(String[] args) {
		assert "c".equals(new TheKthLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(1, 3));
		assert "".equals(new TheKthLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(1, 4));
		assert "cab".equals(new TheKthLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(3, 9));
	}

	String getHappyString(int n, int k) {
		final char[] letters = { 'a', 'b', 'c' };
		backtrack(letters, n, k, Character.MIN_VALUE);
		return ans.reverse().toString();
	}

	private void backtrack(char[] letters, int n, int k, char lastCh) {
		// base case of the recursion.
		if (n == 0) {
			cnt = cnt + 1;
			return;
		}
		for (char ch : letters) {
			// choose.
			if (lastCh != ch) {
				// explore
				backtrack(letters, n - 1, k, ch);
				if (cnt == k) {
					ans.append(ch);
					return;
				}
			}
			// implicit unchoose.
		}
	}
}
