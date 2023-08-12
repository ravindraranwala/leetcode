package com.coding.challenge.sorting;

import java.util.Arrays;
import java.util.Comparator;

class SortIntegersByThePowerValue {
	SortIntegersByThePowerValue() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert getKth(12, 15, 2) == 13;
		assert getKth(7, 11, 4) == 7;
	}

	static int getKth(int lo, int hi, int k) {
		final int n = hi - lo + 1;
		final int[][] a = new int[n][2];
		for (int i = lo; i <= hi; i++) {
			final int p = powVal(i);
			a[i - lo] = new int[] { i, p };
		}
		Arrays.sort(a, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				final int c = Integer.compare(a[1], b[1]);
				if (c != 0)
					return c;
				return Integer.compare(a[0], b[0]);
			}
		});
		return a[k - 1][0];
	}

	private static int powVal(int n) {
		if (n == 1)
			return 0;
		if (n % 2 == 0)
			return powVal(n / 2) + 1;
		else
			return powVal(n * 3 + 1) + 1;
	}
}
