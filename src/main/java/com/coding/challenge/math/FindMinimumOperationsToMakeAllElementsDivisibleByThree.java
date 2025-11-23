package com.coding.challenge.math;

class FindMinimumOperationsToMakeAllElementsDivisibleByThree {
	FindMinimumOperationsToMakeAllElementsDivisibleByThree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 4 };
		assert minimumOperations(nums1) == 3;

		final int[] nums2 = { 3, 6, 9 };
		assert minimumOperations(nums2) == 0;
	}

	static int minimumOperations(int[] nums) {
		int c = 0;
		for (int v : nums) {
			final int r = v % 3;
			c = c + Math.min(r, 3 - r);
		}
		return c;
	}
}
