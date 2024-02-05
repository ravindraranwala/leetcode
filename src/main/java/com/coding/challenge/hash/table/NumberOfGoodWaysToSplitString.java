package com.coding.challenge.hash.table;

class NumberOfGoodWaysToSplitString {
	private static final char FIRST_LETTER = 'a';

	NumberOfGoodWaysToSplitString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numSplits("aacaba") == 2;

		assert numSplits("abcd") == 1;
	}

	static int numSplits(String s) {
		final int n = s.length();
		final int[] rightDistinct = new int[n];
		final boolean[] rightSet = new boolean[n];
		for (int i = n - 1, d = 0; i >= 0; i--) {
			if (!rightSet[s.charAt(i) - FIRST_LETTER]) {
				d = d + 1;
				rightSet[s.charAt(i) - FIRST_LETTER] = true;
			}
			rightDistinct[i] = d;
		}

		int c = 0;
		final boolean[] leftSet = new boolean[26];
		for (int i = 0, d = 0; i < n - 1; i++) {
			if (!leftSet[s.charAt(i) - FIRST_LETTER]) {
				d = d + 1;
				leftSet[s.charAt(i) - FIRST_LETTER] = true;
			}
			if (d == rightDistinct[i + 1])
				c = c + 1;
		}

		return c;
	}
}
