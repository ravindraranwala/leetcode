package com.coding.challenge.radix.sort;

class RadixSort {
	RadixSort() {
		throw new AssertionError();
	}

	static int[] radixSort(int[] a, int d) {
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
