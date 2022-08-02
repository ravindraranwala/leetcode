package com.coding.challenge.dp;

import java.util.HashMap;
import java.util.Map;

class LongestFibonacciSubsequence {
	LongestFibonacciSubsequence() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] a1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int len = lenLongestFibSubseq(a1);
		assert len == 5;
		
		final int[] a2 = { 1, 3, 7, 11, 12, 14, 18 };
		len = lenLongestFibSubseq(a2);
		assert len == 3;

		final int[] a3 = { 1, 2, 3 };
		len = lenLongestFibSubseq(a3);
		assert len == 3;
	}

	static int lenLongestFibSubseq(int[] arr) {
		final int n = arr.length;
		final Map<Integer, Integer> idx = new HashMap<>();
		for (int i = 0; i < n; i++)
			idx.put(arr[i], i);

		final Map<Integer, Integer> t = new HashMap<>();
		int l = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				final int a = arr[i] - arr[j];

				final int aIdx = idx.getOrDefault(a, -1);

				if (aIdx >= 0 && aIdx < j) {
					final int len = t.getOrDefault(aIdx * n + j, 2) + 1;
					t.put(j * n + i, len);
					l = Math.max(l, len);
				}
			}
		}
		return l;
	}
}
