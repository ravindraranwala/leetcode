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
		int pushes = 0;
		for (int i = 25; i >= 0 && f[i] > 0; i--) {
			if (i >= 18)
				pushes = pushes + f[i];
			else if (i >= 10)
				pushes = pushes + f[i] * 2;
			else if (i >= 2)
				pushes = pushes + f[i] * 3;
			else
				pushes = pushes + f[i] * 4;
		}
		return pushes;
	}
}
