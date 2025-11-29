package com.coding.challenge.math;

class MinimumOperationsToMakeArraySumDivisibleByK {
	MinimumOperationsToMakeArraySumDivisibleByK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 9, 7 };
		assert minOperations(nums1, 5) == 4;

		final int[] nums2 = { 4, 1, 3 };
		assert minOperations(nums2, 4) == 0;

		final int[] nums3 = { 3, 2 };
		assert minOperations(nums3, 6) == 5;
	}

	static int minOperations(int[] nums, int k) {
		int m = 0;
		for (int v : nums)
			m = (m + (v % k)) % k;

		return m;
	}
}
