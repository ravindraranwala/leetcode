package com.coding.challenge.string;

class CountTheNumberOfConsistentStrings {
	private static final char FIRST_LETTER = 'a';

	CountTheNumberOfConsistentStrings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String allowed1 = "ab";
		final String[] words1 = { "ad", "bd", "aaab", "baa", "badab" };
		assert countConsistentStrings(allowed1, words1) == 2;

		final String allowed2 = "abc";
		final String[] words2 = { "a", "b", "c", "ab", "ac", "bc", "abc" };
		assert countConsistentStrings(allowed2, words2) == 7;

		final String allowed3 = "cad";
		final String[] words3 = { "cc", "acd", "b", "ba", "bac", "bad", "ac", "d" };
		assert countConsistentStrings(allowed3, words3) == 4;
	}

	static int countConsistentStrings(String allowed, String[] words) {
		final short[] a = new short[26];
		for (char ch : allowed.toCharArray())
			a[ch - FIRST_LETTER] = 1;

		int c = 0;
		for (String w : words) {
			int consistency = 1;
			final int n = w.length();
			for (int i = 0; i < n && consistency == 1; i++)
				consistency = a[w.charAt(i) - FIRST_LETTER];

			c = c + consistency;
		}
		return c;
	}
}
