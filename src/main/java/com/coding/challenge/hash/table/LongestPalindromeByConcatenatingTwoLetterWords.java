package com.coding.challenge.hash.table;

class LongestPalindromeByConcatenatingTwoLetterWords {
	private static final char FIRST_LETTER = 'a';

	LongestPalindromeByConcatenatingTwoLetterWords() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words1 = { "lc", "cl", "gg" };
		assert longestPalindrome(words1) == 6;

		final String[] words2 = { "ab", "ty", "yt", "lc", "cl", "ab" };
		assert longestPalindrome(words2) == 8;

		final String[] words3 = { "cc", "ll", "xx" };
		assert longestPalindrome(words3) == 2;

		final String[] words4 = { "dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc" };
		assert longestPalindrome(words4) == 22;
	}

	static int longestPalindrome(String[] words) {
		final int[][] t = new int[26][26];
		for (String w : words)
			t[w.charAt(0) - FIRST_LETTER][w.charAt(1)
					- FIRST_LETTER] = t[w.charAt(0) - FIRST_LETTER][w.charAt(1) - FIRST_LETTER] + 1;

		int l = 0;
		// examine above diagonal entries.
		for (int i = 0; i < 26; i++)
			for (int j = i + 1; j < 26; j++)
				l = l + Math.min(t[i][j], t[j][i]) * 4;
		
		// examine entries along the diagonal of the square matrix.
		boolean midWord = false;
		for (int i = 0; i < 26; i++) {
			if (t[i][i] % 2 == 1)
				midWord = true;
			
			l = l + t[i][i] / 2 * 4;
		}
		return midWord ? l + 2 : l;
	}
}
