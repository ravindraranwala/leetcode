package com.coding.challenge.sliding.window;

class LongestAlphabeticalContinuousSubstring {
	LongestAlphabeticalContinuousSubstring() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert longestContinuousSubstring("abacaba") == 2;
		assert longestContinuousSubstring("abcde") == 5;
		assert longestContinuousSubstring("adabcd") == 4;
	}

	static int longestContinuousSubstring(String s) {
		final int n = s.length();
		int l = 1;
		for (int i = 0, j = 1; j < n; j++) {
			if (s.charAt(j - 1) + 1 == s.charAt(j))
				l = Math.max(l, j - i + 1);
			else
				i = j;
		}
		return l;
	}
}
