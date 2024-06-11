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
		final int[] a = radixSort(heights, 3);
		int c = 0;
		for (int i = 0; i < n; i++)
			if (a[i] != heights[i])
				c = c + 1;

		return c;
	}

	private static int[] radixSort(int[] a, int d) {
		int[] b = a;
		for (int i = 0; i < d; i++)
			b = countingSort(b, 9, i);
		return b;
	}

	private static int[] countingSort(int[] a, int k, int d) {
		final int n = a.length;
		final int[] b = new int[n];
		final int[] c = new int[k + 1];

		final int denominator = (int) Math.pow(10, d);
		for (int j = 0; j < n; j++) {
			final int digit = (a[j] / denominator) % (k + 1);
			c[digit] = c[digit] + 1;
		}

		for (int i = 1; i <= k; i++)
			c[i] = c[i] + c[i - 1];

		for (int j = n - 1; j >= 0; j--) {
			final int digit = (a[j] / denominator) % (k + 1);
			b[c[digit] - 1] = a[j];
			c[digit] = c[digit] - 1;
		}
		return b;
	}
}
