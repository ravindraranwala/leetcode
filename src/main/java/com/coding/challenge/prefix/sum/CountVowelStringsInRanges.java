package com.coding.challenge.prefix.sum;

import java.util.Arrays;

class CountVowelStringsInRanges {
	CountVowelStringsInRanges() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final String[] words1 = { "aba", "bcb", "ece", "aa", "e" };
		final int[][] queries1 = { { 0, 2 }, { 1, 4 }, { 1, 1 } };
		final int[] a1 = { 2, 3, 0 };
		assert Arrays.equals(a1, vowelStrings(words1, queries1));

		final String[] words2 = { "a", "e", "i" };
		final int[][] queries2 = { { 0, 2 }, { 0, 1 }, { 2, 2 } };
		final int[] a2 = { 3, 2, 1 };
		assert Arrays.equals(a2, vowelStrings(words2, queries2));
	}

	static int[] vowelStrings(String[] words, int[][] queries) {
		final int n = words.length;
		final int[] v = new int[n];
		for (int i = 0; i < n; i++) {
			final String w = words[i];
			if (isVowel(w.charAt(0)) && isVowel(w.charAt(w.length() - 1)))
				v[i] = 1;
		}

		// prefix sum values
		for (int i = 1; i < n; i++)
			v[i] = v[i - 1] + v[i];

		// answering the queries.
		final int m = queries.length;
		final int[] ans = new int[m];
		for (int j = 0; j < m; j++) {
			if (queries[j][0] == 0)
				ans[j] = v[queries[j][1]];
			else
				ans[j] = v[queries[j][1]] - v[queries[j][0] - 1];
		}

		return ans;
	}

	private static boolean isVowel(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}
