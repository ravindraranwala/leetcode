package com.coding.challenge.math;

class CountPartitionsWithEvenSumDifference {
	CountPartitionsWithEvenSumDifference() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 10, 10, 3, 7, 6 };
		assert countPartitions(nums1) == 4;

		final int[] nums2 = { 1, 2, 2 };
		assert countPartitions(nums2) == 0;

		final int[] nums3 = { 2, 4, 6, 8 };
		assert countPartitions(nums3) == 3;
	}

	static int countPartitions(int[] nums) {
		int sumModTwo = 0;
		for (int val : nums)
			sumModTwo = (sumModTwo + val % 2) % 2;

		return sumModTwo == 0 ? nums.length - 1 : 0;
	}
}
