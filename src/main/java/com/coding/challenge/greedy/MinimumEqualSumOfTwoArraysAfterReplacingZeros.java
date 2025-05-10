package com.coding.challenge.greedy;

class MinimumEqualSumOfTwoArraysAfterReplacingZeros {
	MinimumEqualSumOfTwoArraysAfterReplacingZeros() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 2, 0, 1, 0 };
		final int[] nums2 = { 6, 5, 0 };
		assert minSum(nums1, nums2) == 12;

		final int[] nums3 = { 2, 0, 2, 0 };
		final int[] nums4 = { 1, 4 };
		assert minSum(nums3, nums4) == -1;
	}

	static long minSum(int[] nums1, int[] nums2) {
		long s1 = 0;
		int c1 = 0;
		for (int val : nums1) {
			s1 = s1 + val;
			if (val == 0)
				c1 = c1 + 1;
		}

		long s2 = 0;
		int c2 = 0;
		for (int val : nums2) {
			s2 = s2 + val;
			if (val == 0)
				c2 = c2 + 1;
		}

		if (s1 + c1 > s2 + c2 && c2 > 0)
			return s1 + c1;
		if (s2 + c2 > s1 + c1 && c1 > 0)
			return s2 + c2;
		if (s1 + c1 == s2 + c2)
			return s1 + c1;

		return -1;
	}
}
