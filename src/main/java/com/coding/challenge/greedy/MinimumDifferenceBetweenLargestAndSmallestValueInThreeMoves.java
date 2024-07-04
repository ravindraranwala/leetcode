package com.coding.challenge.greedy;

import java.util.Arrays;

class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
	MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 5, 3, 2, 4 };
		assert minDifference(nums1) == 0;

		final int[] nums2 = { 1, 5, 0, 10, 14 };
		assert minDifference(nums2) == 1;
	}

	static int minDifference(int[] nums) {
		final int n = nums.length;
		if (n < 5)
			return 0;
		Arrays.sort(nums);
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= 3; i++)
			ans = Math.min(ans, nums[n - 1 - i] - nums[3 - i]);

		return ans;
	}
}
