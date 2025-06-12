package com.coding.challenge.array;

class MaximumDifferenceBetweenAdjacentElementsInCircularArray {
	MaximumDifferenceBetweenAdjacentElementsInCircularArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 4 };
		assert maxAdjacentDistance(nums1) == 3;

		final int[] nums2 = { -5, -10, -5 };
		assert maxAdjacentDistance(nums2) == 5;
	}

	static int maxAdjacentDistance(int[] nums) {
		final int n = nums.length;
		int maxDiff = Math.abs(nums[0] - nums[n - 1]);
		for (int i = 1; i < n; i++)
			maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i - 1]));

		return maxDiff;
	}
}
