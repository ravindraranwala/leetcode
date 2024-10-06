package com.coding.challenge.sliding.window;

class PermutationInString {
	private static final char FIRST_LETTER = 'a';

	PermutationInString() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert checkInclusion("ab", "eidbaooo");
		assert !checkInclusion("ab", "eidboaoo");
	}

	static boolean checkInclusion(String s1, String s2) {
		final int m = s1.length();
		final int[] f1 = new int[26];
		for (char ch : s1.toCharArray())
			f1[ch - FIRST_LETTER] = f1[ch - FIRST_LETTER] + 1;

		final int[] f = new int[26];
		final int n = s2.length();

		for (int i = 0; i < n; i++) {
			f[s2.charAt(i) - FIRST_LETTER] = f[s2.charAt(i) - FIRST_LETTER] + 1;
			// Fixed size window.
			if (i >= m - 1) {
				boolean p = true;
				for (int k = 0; k < 26; k++)
					p = p && f[k] == f1[k];

				if (p)
					return true;

				f[s2.charAt(i - m + 1) - FIRST_LETTER] = f[s2.charAt(i - m + 1) - FIRST_LETTER] - 1;
			}
		}
		return false;
	}
}
