package com.coding.challenge.math;

class FindGreatestCommonDivisorOfArray {
	FindGreatestCommonDivisorOfArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 5, 6, 9, 10 };
		assert findGCD(nums1) == 2;

		final int[] nums2 = { 7, 5, 6, 8, 3 };
		assert findGCD(nums2) == 1;

		final int[] nums3 = { 3, 3 };
		assert findGCD(nums3) == 3;
	}

	static int findGCD(int[] nums) {
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		for (int val : nums) {
			minVal = Math.min(minVal, val);
			maxVal = Math.max(maxVal, val);
		}
		return GCD.gcd(maxVal, minVal);
	}
}
