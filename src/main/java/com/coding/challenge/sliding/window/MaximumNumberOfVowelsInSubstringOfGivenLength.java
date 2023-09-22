package com.coding.challenge.sliding.window;

class MaximumNumberOfVowelsInSubstringOfGivenLength {
	MaximumNumberOfVowelsInSubstringOfGivenLength() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maxVowels("abciiidef", 3) == 3;
		assert maxVowels("aeiou", 2) == 2;
		assert maxVowels("leetcode", 3) == 2;
	}

	static int maxVowels(String s, int k) {
		// Fixed size window.
		final int n = s.length();
		int maxVowelsCnt = 0;
		for (int i = 0, vowelsCnt = 0; i < n; i++) {
			if (isVowel(s.charAt(i)))
				vowelsCnt = vowelsCnt + 1;

			if (i >= k - 1) {
				maxVowelsCnt = Math.max(maxVowelsCnt, vowelsCnt);
				if (isVowel(s.charAt(i - k + 1)))
					vowelsCnt = vowelsCnt - 1;
			}
		}
		return maxVowelsCnt;
	}

	private static boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}
