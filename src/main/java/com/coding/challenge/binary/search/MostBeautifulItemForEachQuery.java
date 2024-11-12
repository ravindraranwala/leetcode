package com.coding.challenge.binary.search;

import java.util.Arrays;

class MostBeautifulItemForEachQuery {
	MostBeautifulItemForEachQuery() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] items1 = { { 1, 2 }, { 3, 2 }, { 2, 4 }, { 5, 6 }, { 3, 5 } };
		final int[] queries1 = { 1, 2, 3, 4, 5, 6 };
		final int[] ans1 = { 2, 4, 5, 5, 6, 6 };
		assert Arrays.equals(ans1, maximumBeauty(items1, queries1));

		final int[][] items2 = { { 1, 2 }, { 1, 2 }, { 1, 3 }, { 1, 4 } };
		final int[] queries2 = { 1 };
		final int[] ans2 = { 4 };
		assert Arrays.equals(ans2, maximumBeauty(items2, queries2));

		final int[][] items3 = { { 10, 1000 } };
		final int[] queries3 = { 5 };
		final int[] ans3 = { 0 };
		assert Arrays.equals(ans3, maximumBeauty(items3, queries3));
	}

	static int[] maximumBeauty(int[][] items, int[] queries) {
		final int m = queries.length;
		final int n = items.length;
		Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

		for (int i = 1; i < n; i++)
			items[i][1] = Math.max(items[i][1], items[i - 1][1]);

		final int[] a = new int[m];
		for (int j = 0; j < m; j++) {
			final int k = predecessor(items, queries[j] + 1);
			if (k >= 0)
				a[j] = items[k][1];
		}
		return a;
	}

	static int predecessor(int[][] a, int target) {
		int l = 0;
		int r = a.length;
		while (l < r) {
			final int mid = (l + r) / 2;
			if (a[mid][0] < target)
				l = mid + 1;
			else
				r = mid;
		}
		return l - 1;
	}
}
