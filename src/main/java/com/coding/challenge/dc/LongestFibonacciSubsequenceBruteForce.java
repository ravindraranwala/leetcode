package com.coding.challenge.dc;

import java.util.HashSet;
import java.util.Set;

public class LongestFibonacciSubsequenceBruteForce {

	public static void main(String[] args) {
		final int[] a1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int len = lenLongestFibSubseq(a1);
		System.out.println(len);

		final int[] a2 = { 1, 3, 7, 11, 12, 14, 18 };
		len = lenLongestFibSubseq(a2);
		System.out.println(len);

		final int[] a3 = { 1, 2, 3 };
		len = lenLongestFibSubseq(a3);
		System.out.println(len);
	}

	static int lenLongestFibSubseq(int[] arr) {
		final int n = arr.length;
		// Must have at least 3 items.
		if (n < 3)
			return 0;

		final Set<Integer> s = new HashSet<>();
		for (int i = 0; i < n; i++)
			s.add(arr[i]);

		int l = 0;
		for (int i = 2; i < n; i++) {
			for (int j = 0; j < n && arr[j] < Math.ceil(arr[i] / 2.0); j++) {
				int len = 0;
				if (s.contains(arr[i] - arr[j]))
					len = lenLongestFibSubseqRec(s, arr[j], arr[i] - arr[j], arr[i]);
				l = Math.max(l, len);
			}
		}
		return l;
	}

	static int lenLongestFibSubseqRec(Set<Integer> s, int n1, int n2, int n3) {
		// base case of our recursion
		// n2 should be coming after the predecessor n1. Otherwise, it's not a fibonacci
		// sequence.
		if (n1 >= n2)
			return 0;
		if (!s.contains(n1))
			return 0;

		final int len = lenLongestFibSubseqRec(s, n2 - n1, n1, n2);
		if (len == 0)
			return 3;

		return len + 1;
	}
}
