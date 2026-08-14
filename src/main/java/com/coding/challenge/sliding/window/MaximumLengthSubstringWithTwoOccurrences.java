package com.coding.challenge.sliding.window;

class MaximumLengthSubstringWithTwoOccurrences {
	private static final int ALPHABET_SIZE = 26;
	private static final char FIRST_LETTER = 'a';

	MaximumLengthSubstringWithTwoOccurrences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maximumLengthSubstring("bcbbbcba") == 4;
		assert maximumLengthSubstring("aaaa") == 2;
	}

	static int maximumLengthSubstring(String s) {
		return maximumLengthSubstring(s, 2);
	}

	private static int maximumLengthSubstring(String s, int k) {
		final int n = s.length();
		int l = 0;
		final int[] freq = new int[ALPHABET_SIZE];
		for (int i = 0, j = 0; j < n; j++) {
			final char ch = s.charAt(j);
			freq[ch - FIRST_LETTER] = freq[ch - FIRST_LETTER] + 1;
			while (freq[ch - FIRST_LETTER] > k) {
				final char leftCh = s.charAt(i);
				freq[leftCh - FIRST_LETTER] = freq[leftCh - FIRST_LETTER] - 1;
				i = i + 1;
			}
			l = Math.max(l, j - i + 1);
		}
		return l;
	}
}
