package com.coding.challenge.dp;

class MaximumNumberOfJumpsToReachTheLastIndex {
	MaximumNumberOfJumpsToReachTheLastIndex() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 6, 4, 1, 2 };
		assert maximumJumps(nums1, 2) == 3;

		final int[] nums2 = { 1, 3, 6, 4, 1, 2 };
		assert maximumJumps(nums2, 3) == 5;

		final int[] nums3 = { 1, 3, 6, 4, 1, 2 };
		assert maximumJumps(nums3, 0) == -1;
	}

	static int maximumJumps(int[] nums, int target) {
		final int n = nums.length;
		final int[] s = new int[n];

		for (int i = n - 2; i >= 0; i--) {
			s[i] = -1;
			for (int k = i + 1; k < n; k++) {
				final int d = nums[k] - nums[i];
				if (s[k] != -1 && d >= -target && d <= target)
					s[i] = Math.max(s[i], s[k] + 1);
			}
		}
		return s[0];
	}
}
