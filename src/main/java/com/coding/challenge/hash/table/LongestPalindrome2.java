package com.coding.challenge.hash.table;

class LongestPalindrome2 {
	private static final char LOWER_CASE_FIRST_LETTER = 'a';
	private static final char UPPER_CASE_FIRST_LETTER = 'A';

	LongestPalindrome2() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert longestPalindrome("abccccdd") == 7;
		assert longestPalindrome("a") == 1;
	}

	static int longestPalindrome(String s) {
		final int[] lowerFreq = new int[26];
		final int[] upperFreq = new int[26];
		for (char ch : s.toCharArray()) {
			if (Character.isLowerCase(ch))
				lowerFreq[ch - LOWER_CASE_FIRST_LETTER] = lowerFreq[ch - LOWER_CASE_FIRST_LETTER] + 1;
			else
				upperFreq[ch - UPPER_CASE_FIRST_LETTER] = upperFreq[ch - UPPER_CASE_FIRST_LETTER] + 1;
		}

		int oddFreqCnt = 0;
		for (int i = 0; i < 26; i++) {
			if (lowerFreq[i] % 2 == 1)
				oddFreqCnt = oddFreqCnt + 1;
			if (upperFreq[i] % 2 == 1)
				oddFreqCnt = oddFreqCnt + 1;
		}

		final int n = s.length();
		if (oddFreqCnt == 0)
			return n;
		return n - oddFreqCnt + 1;
	}
}
