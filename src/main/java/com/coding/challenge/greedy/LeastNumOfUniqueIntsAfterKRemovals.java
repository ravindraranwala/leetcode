package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class LeastNumOfUniqueIntsAfterKRemovals {
	LeastNumOfUniqueIntsAfterKRemovals() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arrOne = { 5, 5, 4 };
		assert findLeastNumOfUniqueInts(arrOne, 1) == 1;

		final int[] arrTwo = { 4, 3, 1, 1, 3, 3, 2 };
		assert findLeastNumOfUniqueInts(arrTwo, 3) == 2;

		final int[] arrThree = { 1, 1, 2, 2, 3, 3 };
		assert findLeastNumOfUniqueInts(arrThree, 3) == 2;
	}

	static int findLeastNumOfUniqueInts(int[] arr, int k) {
		final Map<Integer, Integer> f = new HashMap<>();
		for (int val : arr)
			f.merge(val, 1, Integer::sum);

		final int n = f.size();
		final int[] freq = new int[n];
		int i = 0;
		for (int val : f.values()) {
			freq[i] = val;
			i = i + 1;
		}

		Arrays.sort(freq);
		int d = 0;
		for (int j = 0; j < n && k >= freq[j]; j++, d++)
			k = k - freq[j];
		return n - d;
	}
}
