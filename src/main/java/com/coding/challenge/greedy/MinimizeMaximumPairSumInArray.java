package com.coding.challenge.greedy;

import java.util.Arrays;

class MinimizeMaximumPairSumInArray {
	MinimizeMaximumPairSumInArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 5, 2, 3 };
		assert minPairSum(nums1) == 7;

		final int[] nums2 = { 3, 5, 4, 2, 4, 6 };
		assert minPairSum(nums2) == 8;
	}

	static int minPairSum(int[] nums) {
		final int n = nums.length;
		Arrays.sort(nums);
		int ans = 0;
		for (int i = 0, mid = n / 2; i < mid; i++)
			ans = Math.max(ans, nums[i] + nums[n - 1 - i]);

		return ans;
	}
}
