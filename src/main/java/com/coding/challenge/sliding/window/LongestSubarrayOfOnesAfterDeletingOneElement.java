package com.coding.challenge.sliding.window;

class LongestSubarrayOfOnesAfterDeletingOneElement {
	LongestSubarrayOfOnesAfterDeletingOneElement() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 1, 0, 1 };
		assert longestSubarray(nums1) == 3;

		final int[] nums2 = { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
		assert longestSubarray(nums2) == 5;

		final int[] nums3 = { 1, 1, 1 };
		assert longestSubarray(nums3) == 2;
	}

	static int longestSubarray(int[] nums) {
		final int n = nums.length;
		int l = 0;
		int i = 0;
		int j = 0;
		int zeros = 0;
		while (j < n) {
			if (nums[j] == 0)
				zeros = zeros + 1;
			if (zeros == 2)
				l = Math.max(l, j - i);
			while (zeros == 2) {
				if (nums[i] == 0)
					zeros = zeros - 1;
				i = i + 1;
			}
			j = j + 1;
		}
		l = Math.max(l, j - i);
		return l - 1;
	}
}
