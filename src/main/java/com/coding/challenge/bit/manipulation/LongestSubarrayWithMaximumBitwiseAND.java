package com.coding.challenge.bit.manipulation;

class LongestSubarrayWithMaximumBitwiseAND {
	LongestSubarrayWithMaximumBitwiseAND() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 3, 2, 2 };
		assert longestSubarray(nums1) == 2;

		final int[] nums2 = { 1, 2, 3, 4 };
		assert longestSubarray(nums2) == 1;

		final int[] nums3 = { 323376, 323376, 323376, 323376, 323376, 323376, 323376, 75940, 75940 };
		assert longestSubarray(nums3) == 7;
	}

	private static int longestSubarray(int[] nums) {
		// Find the largest element in the array first.
		int maxValue = 0;
		for (int num : nums)
			maxValue = Math.max(maxValue, num);

		/*
		 * Now use the sliding window to find the longest subarray containing this max
		 * value.
		 */
		int l = 1;
		final int n = nums.length;
		for (int i = -1, j = 0; j < n; j++) {
			if (nums[j] == maxValue)
				l = Math.max(l, j - i);
			else
				// start a new window.
				i = j;
		}
		return l;
	}

	private static int longestSubarrayOnePass(int[] nums) {
		int maxValue = 0;
		/*
		 * Now use the sliding window to find the longest subarray containing this max
		 * value.
		 */
		int l = 1;
		final int n = nums.length;
		for (int i = -1, j = 0; j < n; j++) {
			if (nums[j] == maxValue)
				l = Math.max(l, j - i);
			else if (nums[j] > maxValue) {
				maxValue = nums[j];
				// start a new window.
				i = j - 1;
				l = 1;
			} else
				// start a new window.
				i = j;

		}
		return l;
	}
}
