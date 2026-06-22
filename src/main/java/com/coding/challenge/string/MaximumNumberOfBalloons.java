package com.coding.challenge.string;

class MaximumNumberOfBalloons {
	private static final char FIRST_LETTER = 'a';

	MaximumNumberOfBalloons() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxNumberOfBalloons("nlaebolko") == 1;
		assert maxNumberOfBalloons("loonbalxballpoon") == 2;
		assert maxNumberOfBalloons("leetcode") == 0;
	}

	static int maxNumberOfBalloons(String text) {
		final int[] f = new int[26];
		for (char ch : text.toCharArray())
			f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;

		return Math.min(f[1], Math.min(f[0], Math.min(f[11] / 2, Math.min(f[14] / 2, f[13]))));
	}
}
