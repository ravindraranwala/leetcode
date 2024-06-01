package com.coding.challenge.string;

class ScoreOfString {
	ScoreOfString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert scoreOfString("hello") == 13;
		assert scoreOfString("zaz") == 50;
	}

	static int scoreOfString(String s) {
		final int n = s.length();
		int score = 0;
		for (int i = 1; i < n; i++)
			score = score + Math.abs(s.charAt(i) - s.charAt(i - 1));
		return score;
	}
}
