package com.coding.challenge.binary.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.coding.challenge.BinarySearch;

class FindRightInterval {
	FindRightInterval() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] intervals1 = { { 1, 2 } };
		final int[] a1 = { -1 };
		assert Arrays.equals(a1, findRightInterval(intervals1));

		final int[][] intervals2 = { { 3, 4 }, { 2, 3 }, { 1, 2 } };
		final int[] a2 = { -1, 0, 1 };
		assert Arrays.equals(a2, findRightInterval(intervals2));

		final int[][] intervals3 = { { 1, 4 }, { 2, 3 }, { 3, 4 } };
		final int[] a3 = { -1, 2, -1 };
		assert Arrays.equals(a3, findRightInterval(intervals3));
	}

	static int[] findRightInterval(int[][] intervals) {
		final Map<Integer, Integer> t = new HashMap<>();
		final int n = intervals.length;
		final int[] s = new int[n];
		final int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			t.put(intervals[i][0], i);
			s[i] = intervals[i][0];
		}
		Arrays.sort(s);
		for (int i = 0; i < n; i++) {
			final int rightIdx = BinarySearch.successor(s, intervals[i][1] - 1);
			if (rightIdx < n)
				a[i] = t.get(s[rightIdx]);
			else
				a[i] = -1;
		}
		return a;
	}
}
