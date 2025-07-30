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
	}

	static int longestSubarray(int[] nums) {
		final int n = nums.length;
		int maxElt = 0;
		for (int val : nums)
			maxElt = Math.max(maxElt, val);

		int l = 0;
		for (int i = 0, c = 0; i < n; i++) {
			if (nums[i] == maxElt)
				c = c + 1;
			else
				c = 0;

			l = Math.max(l, c);
		}
		return l;
	}
}
