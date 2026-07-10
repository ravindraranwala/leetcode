package com.coding.challenge.array;

import java.util.Arrays;

class PathExistenceQueriesInGraphI {
	PathExistenceQueriesInGraphI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3 };
		final int[][] queries1 = { { 0, 0 }, { 0, 1 } };
		final boolean[] a1 = { true, false };
		assert Arrays.equals(a1, pathExistenceQueries(2, nums1, 1, queries1));

		final int[] nums2 = { 2, 5, 6, 8 };
		final int[][] queries2 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 } };
		final boolean[] a2 = { false, false, true, true };
		assert Arrays.equals(a2, pathExistenceQueries(4, nums2, 2, queries2));

		final int[] nums3 = { 569, 10949 };
		final int[][] queries3 = { { 0, 0 }, { 1, 0 } };
		final boolean[] a3 = { true, true };
		assert Arrays.equals(a3, pathExistenceQueries(2, nums3, 56389, queries3));

		final int[] nums4 = { 24030, 49322, 60026, 94469 };
		final int[][] queries4 = { { 2, 2 }, { 1, 3 } };
		final boolean[] a4 = { true, false };
		assert Arrays.equals(a4, pathExistenceQueries(4, nums4, 15879, queries4));
	}

	static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
		final int[] invalidEdges = new int[n];
		for (int i = 1; i < n; i++) {
			if (nums[i] - nums[i - 1] > maxDiff)
				invalidEdges[i] = invalidEdges[i - 1] + 1;
			else
				invalidEdges[i] = invalidEdges[i - 1];
		}

		final int m = queries.length;
		final boolean[] a = new boolean[m];
		for (int k = 0; k < m; k++) {
			final int low = Math.min(queries[k][0], queries[k][1]);
			final int high = Math.max(queries[k][0], queries[k][1]);
			a[k] = invalidEdges[low] == invalidEdges[high];
		}
		return a;
	}
}
