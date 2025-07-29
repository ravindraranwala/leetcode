package com.coding.challenge.backtracking;

class CountNumberOfMaximumBitwiseORSubsets {
	CountNumberOfMaximumBitwiseORSubsets() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 1 };
		assert countMaxOrSubsets(nums1) == 2;

		final int[] nums2 = { 2, 2, 2 };
		assert countMaxOrSubsets(nums2) == 7;

		final int[] nums3 = { 3, 2, 1, 5 };
		assert countMaxOrSubsets(nums3) == 6;
	}

	static int countMaxOrSubsets(int[] nums) {
		int targetOr = 0;
		for (int val : nums)
			targetOr = targetOr | val;

		return backtracking(-1, targetOr, 0, nums);
	}

	private static int backtracking(int i, int targetOr, int currOr, int[] nums) {
		int c = 0;
		if (currOr == targetOr)
			c = 1;

		final int n = nums.length;
		for (int j = i + 1; j < n; j++)
			// choose, and then explore
			c = c + backtracking(j, targetOr, currOr | nums[j], nums);

		// implicit unchoose.
		return c;
	}
}
