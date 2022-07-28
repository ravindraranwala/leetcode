package com.coding.challenge.dc;

import java.util.HashSet;
import java.util.Set;

class LongestFibonacciSubsequenceBruteForce {
	LongestFibonacciSubsequenceBruteForce() {
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
		final Set<Integer> s = new HashSet<>();
		for (int i = 0; i < n; i++)
			s.add(arr[i]);

		int l = 0;
		for (int i = 2; i < n; i++) {
			for (int j = i - 1; j > 0 && arr[j] > arr[i] / 2; j--) {
				int n1 = arr[i] - arr[j];
				int n2 = arr[j];
				int len = 2;
				while (n1 < n2 && s.contains(n1)) {
					len = len + 1;
					final int tmp = n2;
					n2 = n1;
					n1 = tmp - n1;
				}
				l = Math.max(l, len);
			}
		}
		return l > 2 ? l : 0;
	}
}
