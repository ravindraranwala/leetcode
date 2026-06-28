package com.coding.challenge.greedy;

import java.util.Arrays;

class MaximumTotalSumOfKSelectedElements {
	MaximumTotalSumOfKSelectedElements() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 6, 1, 2, 9 };
		assert maxSum(nums1, 3, 2) == 26;

		final int[] nums2 = { 3, 7, 5, 2 };
		assert maxSum(nums2, 2, 4) == 43;

		final int[] nums3 = { 4, 4 };
		assert maxSum(nums3, 1, 1) == 4;
	}

	static long maxSum(int[] nums, int k, int mul) {
		final int n = nums.length;
		Arrays.sort(nums);
		long s = 0;
		long currMul = mul;

		for (int i = 1; i <= k; i++) {
			if (currMul > 0)
				s = s + nums[n - i] * currMul;
			else
				s = s + nums[n - i];

			currMul = currMul - 1;
		}
		return s;
	}
}
