package com.coding.challenge.two.pointer;

class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
	LongestStrictlyIncreasingOrStrictlyDecreasingSubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 4, 3, 3, 2 };
		assert longestMonotonicSubarray(nums1) == 2;

		final int[] nums2 = { 3, 3, 3, 3 };
		assert longestMonotonicSubarray(nums2) == 1;

		final int[] nums3 = { 3, 2, 1 };
		assert longestMonotonicSubarray(nums3) == 3;
	}

	static int longestMonotonicSubarray(int[] nums) {
		final int n = nums.length;
		int l = 1;
		for (int i = 0, j = 1; j < n; j++) {
			if (nums[j] > nums[j - 1])
				l = Math.max(l, j - i + 1);
			else
				i = j;
		}

		for (int i = 0, j = 1; j < n; j++) {
			if (nums[j] < nums[j - 1])
				l = Math.max(l, j - i + 1);
			else
				i = j;
		}

		return l;
	}
}
