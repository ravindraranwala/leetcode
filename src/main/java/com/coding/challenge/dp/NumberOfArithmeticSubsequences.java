package com.coding.challenge.dp;

import java.util.HashMap;
import java.util.Map;

class NumberOfArithmeticSubsequences {
	NumberOfArithmeticSubsequences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 2, 4, 6, 8, 10 };
		assert numberOfArithmeticSlices(numsOne) == 7;

		final int[] numsTwo = { 7, 7, 7, 7, 7 };
		assert numberOfArithmeticSlices(numsTwo) == 16;

		final int[] numsThree = { 2, 4, 6, 7, 7, 7, 7, 7 };
		assert numberOfArithmeticSlices(numsThree) == 17;

		final int[] numsFour = { 1 };
		assert numberOfArithmeticSlices(numsFour) == 0;

		final int[] numsFive = { 2, 4 };
		assert numberOfArithmeticSlices(numsFive) == 0;

		final int[] numsSix = { 0, 2000000000, -294967296 };
		assert numberOfArithmeticSlices(numsSix) == 0;

		final int[] numsSeven = { 7, 7, 7, 7, 7, 7 };
		assert numberOfArithmeticSlices(numsSeven) == 42;
	}

	static int numberOfArithmeticSlices(int[] nums) {
		final int n = nums.length;
		final Map<Long, Integer>[] a = new Map[n];
		int c = 0;

		for (int i = 0; i < n; i++) {
			final Map<Long, Integer> m = new HashMap<>();
			for (int j = 0; j < i; j++) {
				final long d = nums[i] - (long) nums[j];
				final int cnt = a[j].getOrDefault(d, 0);
				m.merge(d, cnt + 1, Integer::sum);
				c = c + cnt;
			}
			a[i] = m;
		}
		return c;
	}
}
