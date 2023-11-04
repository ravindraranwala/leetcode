package com.coding.challenge.two.pointer;

import java.util.Arrays;

class RangeSumOfSortedSubarraySums {
	RangeSumOfSortedSubarraySums() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 3, 4 };
		assert rangeSum(numsOne, 4, 1, 5) == 13;

		final int[] numsTwo = { 1, 2, 3, 4 };
		assert rangeSum(numsTwo, 4, 3, 4) == 6;

		final int[] numsThree = { 1, 2, 3, 4 };
		assert rangeSum(numsThree, 4, 1, 10) == 50;
	}

	static int rangeSum(int[] nums, int n, int left, int right) {
		final int arrLen = (n * (n + 1)) / 2;
		final int[] s = new int[arrLen];
		for (int i = 0, k = 0; i < n; i++) {
			int runningSum = 0;
			for (int j = i; j < n; j++) {
				runningSum = runningSum + nums[j];
				s[k] = runningSum;
				k = k + 1;
			}
		}
		Arrays.sort(s);
		int sum = 0;
		for (int i = left - 1; i < right; i++)
			sum = (sum + s[i]) % 1000000007;
		return sum;
	}
}
