package com.coding.challenge.greedy;

import java.util.Arrays;

class MinimumDifferenceBetweenHighestAndLowestOfKScores {
	MinimumDifferenceBetweenHighestAndLowestOfKScores() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 90 };
		assert minimumDifference(nums1, 1) == 0;

		final int[] nums2 = { 9, 4, 1, 7 };
		assert minimumDifference(nums2, 2) == 2;
	}

	static int minimumDifference(int[] nums, int k) {
		Arrays.sort(nums);
		final int n = nums.length;
		int ans = Integer.MAX_VALUE;
		for (int i = k - 1; i < n; i++)
			ans = Math.min(ans, nums[i] - nums[i - k + 1]);

		return ans;
	}
}
