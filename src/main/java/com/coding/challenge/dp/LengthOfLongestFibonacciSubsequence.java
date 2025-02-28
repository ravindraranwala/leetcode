package com.coding.challenge.dp;

import java.util.HashMap;
import java.util.Map;

class LengthOfLongestFibonacciSubsequence {
	LengthOfLongestFibonacciSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		assert lenLongestFibSubseq(arr1) == 5;

		final int[] arr2 = { 1, 3, 7, 11, 12, 14, 18 };
		assert lenLongestFibSubseq(arr2) == 3;

		final int[] arr3 = { 2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50 };
		assert lenLongestFibSubseq(arr3) == 5;

		final int[] arr4 = { 1, 3, 5 };
		assert lenLongestFibSubseq(arr4) == 0;
	}

	static int lenLongestFibSubseq(int[] arr) {
		final int n = arr.length;
		final Map<Integer, Integer> t = new HashMap<>();
		final int[][] l = new int[n][n];
		int len = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				final int beforePrev = arr[i] - arr[j];
				if (beforePrev < arr[j] && t.containsKey(beforePrev)) {
					final int k = t.get(beforePrev);
					l[j][i] = l[k][j] + 1;
					len = Math.max(len, l[j][i]);
				} else
					l[j][i] = 2;
			}
			t.put(arr[i], i);
		}
		return len;
	}
}
