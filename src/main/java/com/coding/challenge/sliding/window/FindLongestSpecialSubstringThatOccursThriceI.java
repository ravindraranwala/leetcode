package com.coding.challenge.sliding.window;

import java.util.Arrays;

class FindLongestSpecialSubstringThatOccursThriceI {
	private static final char FIRST_LETTER = 'a';

	FindLongestSpecialSubstringThatOccursThriceI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maximumLength("aaaa") == 2;
		assert maximumLength("abcdef") == -1;
		assert maximumLength("abcaba") == 1;
		assert maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde") == 2;
	}

	// Sliding window and counting algorithm - linear time.
	static int maximumLength(String s) {
		final int n = s.length();
		int len = -1;
		final int[][] a = new int[26][3];
		// init.
		for (int i = 0; i < 26; i++) {
			a[i][0] = -1;
			a[i][1] = -1;
			a[i][2] = -1;
		}

		for (int i = 0, j = 0; j <= n; j++) {
			if (j == n || s.charAt(i) != s.charAt(j)) {
				final int[] arr = a[s.charAt(i) - FIRST_LETTER];
				final int k = min(arr[0], arr[1], arr[2]);
				if (j - i > arr[k])
					arr[k] = j - i;
				// slap a new window here.
				i = j;
			}
		}

		for (int[] f : a) {
			Arrays.sort(f);
			len = Math.max(len, f[0]);
			if (f[2] > 1)
				len = Math.max(len, Math.min(f[1], f[2] - 1));
			if (f[2] > 2)
				len = Math.max(len, f[2] - 2);
		}
		return len;
	}

	private static int min(int a, int b, int c) {
		if (a <= b) {
			if (a <= c)
				return 0;

			return 2;
		} else {
			if (b <= c)
				return 1;
			return 2;
		}
	}
}
