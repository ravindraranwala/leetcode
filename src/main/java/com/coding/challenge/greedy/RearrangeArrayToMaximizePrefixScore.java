package com.coding.challenge.greedy;

import java.util.Arrays;

class RearrangeArrayToMaximizePrefixScore {
	RearrangeArrayToMaximizePrefixScore() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, -1, 0, 1, -3, 3, -3 };
		assert maxScore(nums1) == 6;

		final int[] nums2 = { -2, -3, 0 };
		assert maxScore(nums2) == 0;
	}

	static int maxScore(int[] nums) {
		Arrays.sort(nums);
		final int n = nums.length;
		int c = 0;
		long s = 0;
		for (int i = n - 1; i >= 0; i--) {
			s = s + nums[i];
			if (s > 0)
				c = c + 1;
		}
		return c;
	}
}
