package com.coding.challenge.string;

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
		int cnt = 0;
		final int[] lastIdx = { -1, -1, -1 };
		for (int i = 0; i < n; i++) {
			lastIdx[s.charAt(i) - FIRST_LETTER] = i;
			cnt = cnt + Math.min(lastIdx[0], Math.min(lastIdx[1], lastIdx[2])) + 1;
		}
		return cnt;
	}
}
