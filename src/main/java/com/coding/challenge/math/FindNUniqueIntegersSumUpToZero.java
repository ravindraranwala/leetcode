package com.coding.challenge.math;

import java.util.Arrays;

class FindNUniqueIntegersSumUpToZero {
	FindNUniqueIntegersSumUpToZero() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] ans1 = { -1, 1, -2, 2, 0 };
		assert Arrays.equals(ans1, sumZero(5));

		final int[] ans2 = { -1, 1, 0 };
		assert Arrays.equals(ans2, sumZero(3));

		final int[] ans3 = { 0 };
		assert Arrays.equals(ans3, sumZero(1));
	}

	static int[] sumZero(int n) {
		final int[] a = new int[n];
		final int maxElt = n / 2;
		for (int x = 1; x <= maxElt; x++) {
			final int p = x * 2;
			a[p - 2] = -x;
			a[p - 1] = x;
		}
		return a;
	}
}
