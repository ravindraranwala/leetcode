package com.coding.challenge.string;

class UniqueLength3PalindromicSubsequences {
	private static final char FIRST_LETTER = 'a';

	UniqueLength3PalindromicSubsequences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert countPalindromicSubsequence("aabca") == 3;
		assert countPalindromicSubsequence("adc") == 0;
		assert countPalindromicSubsequence("bbcbaba") == 4;
	}

	static int countPalindromicSubsequence(String s) {
		final int n = s.length();
		final int[] lastOccurrence = new int[26];
		for (int i = 0; i < n; i++)
			lastOccurrence[s.charAt(i) - FIRST_LETTER] = i;

		final int[] firstOccurrence = new int[26];
		for (int i = n - 1; i >= 0; i--)
			firstOccurrence[s.charAt(i) - FIRST_LETTER] = i;

		int c = 0;
		for (int i = 0; i < 26; i++) {
			final int l = firstOccurrence[i];
			final int r = lastOccurrence[i];
			final int[] a = new int[26];
			for (int j = l + 1; j < r; j++)
				a[s.charAt(j) - FIRST_LETTER] = 1;

			for (int k = 0; k < 26; k++)
				c = c + a[k];
		}

		return c;
	}
}
