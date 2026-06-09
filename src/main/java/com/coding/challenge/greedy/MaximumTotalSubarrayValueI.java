package com.coding.challenge.greedy;

class MaximumTotalSubarrayValueI {
	MaximumTotalSubarrayValueI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 2 };
		assert maxTotalValue(nums1, 2) == 4;

		final int[] nums2 = { 4, 2, 5, 1 };
		assert maxTotalValue(nums2, 3) == 12;
	}

	static long maxTotalValue(int[] nums, int k) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int v : nums) {
			min = Math.min(min, v);
			max = Math.max(max, v);
		}

		return (max - min) * (long) k;
	}
}
