package com.coding.challenge.general;

class MaximumProductOfWordLengths {
	private static final char FIRST_LETTER = 'a';

	MaximumProductOfWordLengths() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] wordsOne = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
		assert maxProduct(wordsOne) == 16;

		final String[] wordsTwo = { "a", "ab", "abc", "d", "cd", "bcd", "abcd" };
		assert maxProduct(wordsTwo) == 4;

		final String[] wordsThree = { "a", "aa", "aaa", "aaaa" };
		assert maxProduct(wordsThree) == 0;
	}

	static int maxProduct(String[] words) {
		final int n = words.length;
		final boolean[][] f = new boolean[n][26];

		for (int i = 0; i < n; i++)
			for (char ch : words[i].toCharArray())
				f[i][ch - FIRST_LETTER] = true;

		int p = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int l = words[i].length() * words[j].length();
				for (int k = 0; k < 26 && l > 0; k++)
					if ((f[i][k] && f[j][k]))
						l = 0;

				p = Math.max(p, l);
			}
		}
		return p;
	}
}
