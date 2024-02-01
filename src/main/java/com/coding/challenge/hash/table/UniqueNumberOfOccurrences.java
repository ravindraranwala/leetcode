package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class UniqueNumberOfOccurrences {
	UniqueNumberOfOccurrences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 1, 2, 2, 1, 1, 3 };
		assert uniqueOccurrences(arr1);

		final int[] arr2 = { 1, 2 };
		assert !uniqueOccurrences(arr2);

		final int[] arr3 = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
		assert uniqueOccurrences(arr3);
	}

	static boolean uniqueOccurrences(int[] arr) {
		final Map<Integer, Integer> f = new HashMap<>();
		for (int v : arr)
			f.merge(v, 1, Integer::sum);

		return new HashSet<>(f.values()).size() == f.size();
	}
}
