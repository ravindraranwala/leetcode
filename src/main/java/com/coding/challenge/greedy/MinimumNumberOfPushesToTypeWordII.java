package com.coding.challenge.greedy;

import java.util.Arrays;

class MinimumNumberOfPushesToTypeWordII {
	private static final char FIRST_LETTER = 'a';
	
	MinimumNumberOfPushesToTypeWordII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert minimumPushes("abcde") == 5;
		assert minimumPushes("xyzxyzxyzxyz") == 12;
		assert minimumPushes("aabbccddeeffgghhiiiiii") == 24;
	}

	static int minimumPushes(String word) {
		final int[] f = new int[26];
		for (char ch : word.toCharArray())
			f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;

		Arrays.sort(f);
		int p = 4 * (f[0] + f[1]);
		for (int i = 2; i < 10; i++)
			p = p + 3 * f[i];
		for (int i = 10; i < 18; i++)
			p = p + 2 * f[i];
		for (int i = 18; i < 26; i++)
			p = p + f[i];

		return p;
    }
}
