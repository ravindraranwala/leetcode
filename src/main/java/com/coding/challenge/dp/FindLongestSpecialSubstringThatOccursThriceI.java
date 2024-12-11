package com.coding.challenge.dp;

class FindLongestSpecialSubstringThatOccursThriceI {
	private static final char FIRST_LETTER = 'a';

	FindLongestSpecialSubstringThatOccursThriceI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maximumLength("aaaa") == 2;
		assert maximumLength("abcdef") == -1;
		assert maximumLength("abcaba") == 1;
		assert maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde") == 2;
	}

	static int maximumLength(String s) {
		final int n = s.length();
		int len = -1;
		final boolean[][] special = new boolean[n][n];

		// trivial case of the recursion.
		final int[] freq = new int[26];
		for (int i = 0; i < n; i++) {
			final char ch = s.charAt(i);
			special[i][i] = true;
			freq[ch - FIRST_LETTER] = freq[ch - FIRST_LETTER] + 1;
		}
		
		for (int i = 0; i < 26; i++)
			if (freq[i] >= 3)
				len = 1;

		for (int l = 2; l <= n; l++) {
			final int[] f = new int[26];
			for (int i = 0; i < n - l + 1; i++) {
				final int j = i + l - 1;
				final char ch = s.charAt(j);
				if (special[i][j - 1] && s.charAt(i) == ch) {
					special[i][j] = true;
					f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;
				}
			}
			for (int i = 0; i < 26; i++)
				if (f[i] >= 3)
					len = l;
		}
		return len;
	}
}
