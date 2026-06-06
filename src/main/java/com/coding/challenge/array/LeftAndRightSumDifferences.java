package com.coding.challenge.array;

import java.util.Arrays;

class LeftAndRightSumDifferences {
	LeftAndRightSumDifferences() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] exp1 = { 15, 1, 11, 22 };
		final int[] nums1 = { 10, 4, 8, 3 };
		assert Arrays.equals(leftRightDifference(nums1), exp1);

		final int[] nums2 = { 0 };
		final int[] exp2 = { 0 };
		assert Arrays.equals(leftRightDifference(nums2), exp2);
	}

	static int[] leftRightDifference(int[] nums) {
		int sum = 0;
		for (int v : nums)
			sum = sum + v;

		final int n = nums.length;
		final int[] a = new int[n];
		for (int i = 0, leftSum = 0; i < n; i++) {
			a[i] = Math.abs(leftSum - sum + leftSum + nums[i]);
			leftSum = leftSum + nums[i];
		}
		return a;
	}
}
