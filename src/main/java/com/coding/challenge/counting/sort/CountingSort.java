package com.coding.challenge.counting.sort;

public class CountingSort {
	private CountingSort() {
		throw new AssertionError();
	}

	public static int[] countingSort(int[] a, int k) {
		final int n = a.length;
		final int[] b = new int[n];
		final int[] c = new int[k + 1];

		for (int j = 0; j < n; j++)
			c[a[j]] = c[a[j]] + 1;

		for (int i = 1; i <= k; i++)
			c[i] = c[i - 1] + c[i];

		for (int j = n - 1; j >= 0; j--) {
			b[c[a[j]] - 1] = a[j];
			c[a[j]] = c[a[j]] - 1;
		}
		return b;
	}
}
