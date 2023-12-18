package com.coding.challenge.binary.search;

import java.util.Arrays;

import com.coding.challenge.BinarySearch;

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

		final int[][] items4 = { { 193, 732 }, { 781, 962 }, { 864, 954 }, { 749, 627 }, { 136, 746 }, { 478, 548 },
				{ 640, 908 }, { 210, 799 }, { 567, 715 }, { 914, 388 }, { 487, 853 }, { 533, 554 }, { 247, 919 },
				{ 958, 150 }, { 193, 523 }, { 176, 656 }, { 395, 469 }, { 763, 821 }, { 542, 946 }, { 701, 676 } };
		final int[] queries4 = { 885, 1445, 1580, 1309, 205, 1788, 1214, 1404, 572, 1170, 989, 265, 153, 151, 1479,
				1180, 875, 276, 1584 };
		final int[] ans4 = { 962, 962, 962, 962, 746, 962, 962, 962, 946, 962, 962, 919, 746, 746, 962, 962, 962, 919,
				962 };
		assert Arrays.equals(ans4, maximumBeauty(items4, queries4));
	}

	static int[] maximumBeauty(int[][] items, int[] queries) {
		final int n = queries.length;
		final int[] ans = new int[n];
		Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

		final int m = items.length;
		final int[] maxBeauty = new int[m];
		final int[] price = new int[m];
		for (int i = 0, b = 0; i < m; i++) {
			b = Math.max(b, items[i][1]);
			maxBeauty[i] = b;
			price[i] = items[i][0];
		}

		for (int i = 0; i < n; i++) {
			final int j = BinarySearch.predecessor(price, queries[i] + 1);
			if (j >= 0)
				ans[i] = maxBeauty[j];
		}
		return ans;
	}
}
