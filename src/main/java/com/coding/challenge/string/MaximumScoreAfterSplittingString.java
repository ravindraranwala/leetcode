package com.coding.challenge.string;

class MaximumScoreAfterSplittingString {
	private static final char ZERO = '0';

	MaximumScoreAfterSplittingString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxScore("011101") == 5;
		assert maxScore("00111") == 5;
		assert maxScore("1111") == 3;
	}

	static int maxScore(String s) {
		int totalOnes = 0;
		for (char ch : s.toCharArray())
			totalOnes = totalOnes + ch - ZERO;

		int score = 0;
		final int n = s.length();
		for (int i = 0, oneCnt = 0; i < n - 1; i++) {
			oneCnt = oneCnt + s.charAt(i) - ZERO;
			score = Math.max(score, i + 1 - oneCnt + totalOnes - oneCnt);
		}
		return score;
	}
}
