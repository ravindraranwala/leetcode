package com.coding.challenge.radix.sort;

class HeightChecker {
	HeightChecker() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] heights1 = { 1, 1, 4, 2, 1, 3 };
		assert heightChecker(heights1) == 3;

		final int[] heights2 = { 5, 1, 2, 3, 4 };
		assert heightChecker(heights2) == 5;

		final int[] heights3 = { 1, 2, 3, 4, 5 };
		assert heightChecker(heights3) == 0;
	}

	static int heightChecker(int[] heights) {
		final int n = heights.length;
		final int[] a = RadixSort.radixSort(heights, 3);
		int c = 0;
		for (int i = 0; i < n; i++)
			if (a[i] != heights[i])
				c = c + 1;

		return c;
	}
}
