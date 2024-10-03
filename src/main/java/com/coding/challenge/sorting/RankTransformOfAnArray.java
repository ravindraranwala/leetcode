package com.coding.challenge.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class RankTransformOfAnArray {
	RankTransformOfAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 40, 10, 20, 30 };
		final int[] e1 = { 4, 1, 2, 3 };
		assert Arrays.equals(e1, arrayRankTransform(arr1));

		final int[] arr2 = { 100, 100, 100 };
		final int[] e2 = { 1, 1, 1 };
		assert Arrays.equals(e2, arrayRankTransform(arr2));

		final int[] arr3 = { 37, 12, 28, 9, 100, 56, 80, 5, 12 };
		final int[] e3 = { 5, 3, 4, 2, 8, 6, 7, 1, 3 };
		assert Arrays.equals(e3, arrayRankTransform(arr3));

		assert Arrays.equals(new int[0], arrayRankTransform(new int[0]));
	}

	static int[] arrayRankTransform(int[] arr) {
		final int n = arr.length;

		final int[] r = new int[n];
		for (int i = 0; i < n; i++)
			r[i] = arr[i];
		Arrays.sort(r);

		final Map<Integer, Integer> rankTable = new HashMap<>();
		for (int i = 0, rank = 1; i < n; i++) {
			if (!rankTable.containsKey(r[i])) {
				rankTable.put(r[i], rank);
				rank = rank + 1;
			}
		}

		for (int i = 0; i < n; i++)
			r[i] = rankTable.get(arr[i]);

		return r;
	}
}
