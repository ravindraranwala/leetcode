package com.coding.challenge.greedy;

class SmallestPalindromicRearrangementI {
	private static final char FIRST_LETTER = 'a';
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	SmallestPalindromicRearrangementI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert "z".equals(smallestPalindrome("z"));
		assert "abbba".equals(smallestPalindrome("babab"));
		assert "acddca".equals(smallestPalindrome("daccad"));
		assert "yey".equals(smallestPalindrome("yey"));
	}

	static String smallestPalindrome(String s) {
		final int[] f = new int[26];
		for (char ch : s.toCharArray())
			f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;

		final int n = s.length();
		final char[] ans = new char[n];
		for (int i = 0, j = 0; i < 26; i++) {
			final char ch = ALPHABET.charAt(i);
			int remainingFreq = f[i];
			while (remainingFreq > 1) {
				ans[j] = ch;
				ans[n - 1 - j] = ch;
				j = j + 1;
				remainingFreq = remainingFreq - 2;
			}
			if (remainingFreq == 1)
				ans[n / 2] = ch;
		}
		return String.valueOf(ans);
	}
}
