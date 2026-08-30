package com.coding.challenge.sliding.window;

class RemovingMinimumAndMaximumFromArray {
	RemovingMinimumAndMaximumFromArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 10, 7, 5, 4, 1, 8, 6 };
		assert minimumDeletions(nums1) == 5;

		final int[] nums2 = { 0, -4, 19, 1, 8, -2, -3, 5 };
		assert minimumDeletions(nums2) == 3;

		final int[] nums3 = { 101 };
		assert minimumDeletions(nums3) == 1;
	}

	static int minimumDeletions(int[] nums) {
		final int n = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int val : nums) {
			min = Math.min(min, val);
			max = Math.max(max, val);
		}

		int l = 0;
		for (int i = 0, j = 0; j < n; j++) {
			if (nums[j] == min || nums[j] == max)
				i = j + 1;

			l = Math.max(l, j - i + 1);
		}

		return n - l;
	}
}
