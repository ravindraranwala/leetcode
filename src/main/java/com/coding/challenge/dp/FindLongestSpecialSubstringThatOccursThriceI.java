package com.coding.challenge.dp;

import java.util.Arrays;

class FindLongestSpecialSubstringThatOccursThriceI {
	private static final char FIRST_LETTER = 'a';

	FindLongestSpecialSubstringThatOccursThriceI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert maximumLengthLinear("aaaa") == 2;
		assert maximumLength("aaaa") == 2;
		
		assert maximumLengthLinear("abcdef") == -1;
		assert maximumLength("abcdef") == -1;
		
		assert maximumLength("abcaba") == 1;
		assert maximumLengthLinear("abcaba") == 1;
		
		assert maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde") == 2;
		assert maximumLengthLinear("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde") == 2;
	}

	static int maximumLength(String s) {
		final int n = s.length();
		int len = -1;
		final boolean[][] special = new boolean[n][n];

		// trivial case of the recursion.
		final int[] freq = new int[26];
		for (int i = 0; i < n; i++) {
			final char ch = s.charAt(i);
			special[i][i] = true;
			freq[ch - FIRST_LETTER] = freq[ch - FIRST_LETTER] + 1;
		}

		for (int i = 0; i < 26; i++)
			if (freq[i] >= 3)
				len = 1;

		for (int l = 2; l <= n; l++) {
			final int[] f = new int[26];
			for (int i = 0; i < n - l + 1; i++) {
				final int j = i + l - 1;
				final char ch = s.charAt(j);
				if (special[i][j - 1] && s.charAt(i) == ch) {
					special[i][j] = true;
					f[ch - FIRST_LETTER] = f[ch - FIRST_LETTER] + 1;
				}
			}
			for (int i = 0; i < 26; i++)
				if (f[i] >= 3)
					len = l;
		}
		return len;
	}

	// string matching algorithm.
	static int maximumLengthLinear(String s) {
		final int n = s.length();
		int len = -1;
		final int[][] a = new int[26][3];
		// init.
		for (int i = 0; i < 26; i++) {
			a[i][0] = -1;
			a[i][1] = -1;
			a[i][2] = -1;
		}

		for (int i = 0, c = 0; i < n; i++) {
			c = c + 1;
			if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
				final int[] arr = a[s.charAt(i) - FIRST_LETTER];
				final int j = min(arr[0], arr[1], arr[2]);
				if (c > arr[j])
					arr[j] = c;
				c = 0;
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
