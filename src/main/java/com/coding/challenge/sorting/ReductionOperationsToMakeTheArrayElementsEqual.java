package com.coding.challenge.sorting;

import java.util.Arrays;

class ReductionOperationsToMakeTheArrayElementsEqual {
	ReductionOperationsToMakeTheArrayElementsEqual() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 5, 1, 3 };
		assert reductionOperations(nums1) == 3;

		final int[] nums2 = { 1, 1, 1 };
		assert reductionOperations(nums2) == 0;

		final int[] nums3 = { 1, 1, 2, 2, 3 };
		assert reductionOperations(nums3) == 4;
	}

	static int reductionOperations(int[] nums) {
		Arrays.sort(nums);
		final int n = nums.length;
		int ops = 0;
		for (int i = n - 1, j = n - 1, c = 0; j >= 0;) {
			c = c + i - j;
			ops = ops + c;
			i = j;
			while (j >= 0 && nums[i] == nums[j])
				j = j - 1;
		}
		return ops;
	}
}
