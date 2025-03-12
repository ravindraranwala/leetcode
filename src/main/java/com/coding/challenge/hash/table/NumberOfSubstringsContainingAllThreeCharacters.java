package com.coding.challenge.hash.table;

class NumberOfSubstringsContainingAllThreeCharacters {
	private static final char FIRST_LETTER = 'a';

	NumberOfSubstringsContainingAllThreeCharacters() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numberOfSubstrings("abcabc") == 10;
		assert numberOfSubstrings("aaacb") == 3;
		assert numberOfSubstrings("abc") == 1;
	}

	static int numberOfSubstrings(String s) {
		final int n = s.length();
		final int[] lastIdx = { -1, -1, -1 };
		int c = 0;
		for (int i = 0; i < n; i++) {
			lastIdx[s.charAt(i) - FIRST_LETTER] = i;
			c = c + Math.min(lastIdx[0], Math.min(lastIdx[1], lastIdx[2])) + 1;
		}
		return c;
	}
}
