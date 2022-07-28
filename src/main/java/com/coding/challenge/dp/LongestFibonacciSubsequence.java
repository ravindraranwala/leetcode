package com.coding.challenge.dp;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
		final Set<Integer> s = new HashSet<>();
		for (int i = 0; i < n; i++)
			s.add(arr[i]);

		final Map<Entry<Integer, Integer>, Integer> t = new HashMap<>();
		int l = 0;
		for (int i = 2; i < n; i++) {
			for (int j = i - 1; j > 0 && arr[j] > arr[i] / 2; j--) {
				final int n1 = arr[i] - arr[j];
				final int n2 = arr[j];
				final SimpleImmutableEntry<Integer, Integer> key = new AbstractMap.SimpleImmutableEntry<>(n1, n2);
				final SimpleImmutableEntry<Integer, Integer> newKey = new AbstractMap.SimpleImmutableEntry<>(n2, n1 + n2);
				if (t.containsKey(key))
					t.put(newKey, t.get(key) + 1);
				if (!t.containsKey(key) && n1 < n2 && s.contains(n1))
					t.put(newKey, 3);
				l = Math.max(l, t.getOrDefault(newKey, 0));
			}
		}
		return l;
	}
}
