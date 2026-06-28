package com.coding.challenge.greedy;

import java.util.Arrays;

class MaximumElementAfterDecreasingAndRearranging {
	MaximumElementAfterDecreasingAndRearranging() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 2, 1, 2, 1 };
		assert maximumElementAfterDecrementingAndRearranging(nums1) == 2;

		final int[] nums2 = { 100, 1, 1000 };
		assert maximumElementAfterDecrementingAndRearranging(nums2) == 3;

		final int[] nums3 = { 1, 2, 3, 4, 5 };
		assert maximumElementAfterDecrementingAndRearranging(nums3) == 5;
	}

	static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		final int n = arr.length;
		Arrays.sort(arr);
		int maxVal = 0;
		for (int i = 0; i < n; i++)
			if (arr[i] > maxVal)
				maxVal = maxVal + 1;

		return maxVal;
	}
}
