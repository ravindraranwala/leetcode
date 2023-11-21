package com.coding.challenge.prefix.sum;

import java.util.Arrays;

class RemovingMinimumNumberOfMagicBeans {
	RemovingMinimumNumberOfMagicBeans() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] beansOne = { 4, 1, 6, 5 };
		assert minimumRemoval(beansOne) == 4;

		final int[] beansTwo = { 2, 10, 3, 2 };
		assert minimumRemoval(beansTwo) == 7;
	}

	static long minimumRemoval(int[] beans) {
		final int n = beans.length;
		Arrays.sort(beans);
		final long[] postfixSum = new long[n];
		postfixSum[n - 1] = beans[n - 1];
		for (int i = n - 2; i >= 0; i--)
			postfixSum[i] = postfixSum[i + 1] + beans[i];

		long r = Long.MAX_VALUE;
		long prefixSum = 0;
		for (int i = 0; i < n; i++) {
			r = Math.min(r, postfixSum[i] - beans[i] * (long) (n - i) + prefixSum);
			prefixSum = prefixSum + beans[i];
		}
		return r;
	}
}
