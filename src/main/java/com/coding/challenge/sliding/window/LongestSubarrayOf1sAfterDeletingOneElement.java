package com.coding.challenge.sliding.window;

class LongestSubarrayOf1sAfterDeletingOneElement {
	LongestSubarrayOf1sAfterDeletingOneElement() {
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

		for (int i = 0, j = 0, k = -1; j < n; j++) {
			if (nums[j] == 0) {
				i = k + 1;
				k = j;
			}

			// delete one element.
			l = Math.max(l, j - i);
		}
		return l;
	}
}
