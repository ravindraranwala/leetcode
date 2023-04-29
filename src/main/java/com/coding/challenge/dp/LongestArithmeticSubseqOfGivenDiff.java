package com.coding.challenge.dp;

import java.util.HashMap;
import java.util.Map;

class LongestArithmeticSubseqOfGivenDiff {
	LongestArithmeticSubseqOfGivenDiff() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arrOne = { 1, 2, 3, 4 };
		assert longestSubsequence(arrOne, 1) == 4;

		final int[] arrTwo = { 1, 3, 5, 7 };
		assert longestSubsequence(arrTwo, 1) == 1;

		final int[] arrThree = { 1, 5, 7, 8, 5, 3, 4, 2, 1 };
		assert longestSubsequence(arrThree, -2) == 4;
	}

	static int longestSubsequence(int[] arr, int difference) {
		final int n = arr.length;
		final Map<Integer, Integer> t = new HashMap<>();
		int maxLen = 1;

		for (int i = 0; i < n; i++) {
			final int currLen = t.getOrDefault(arr[i] - difference, 0) + 1;
			t.put(arr[i], currLen);
			maxLen = Math.max(maxLen, currLen);
		}

		return maxLen;
	}
}
