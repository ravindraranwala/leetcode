package com.coding.challenge.math;

import java.util.Arrays;

class TransformedArray {
	TransformedArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, -2, 1, 1 };
		final int[] a1 = { 1, 1, 1, 3 };
		assert Arrays.equals(a1, constructTransformedArray(nums1));

		final int[] nums2 = { -1, 4, -1 };
		final int[] a2 = { -1, -1, 4 };
		assert Arrays.equals(a2, constructTransformedArray(nums2));
	}

	static int[] constructTransformedArray(int[] nums) {
		final int n = nums.length;
		final int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			if (nums[i] >= 0) {
				final int j = (i + nums[i]) % n;
				result[i] = nums[j];
			} else {
				final int leftMoves = -nums[i] % n;
				final int rightMoves = n - leftMoves;
				result[i] = nums[(i + rightMoves) % n];
			}
		}
		return result;
	}
}
