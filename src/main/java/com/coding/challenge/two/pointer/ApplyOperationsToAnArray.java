package com.coding.challenge.two.pointer;

import java.util.Arrays;

class ApplyOperationsToAnArray {
	ApplyOperationsToAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 2, 1, 1, 0 };
		final int[] exp1 = { 1, 4, 2, 0, 0, 0 };
		assert Arrays.equals(exp1, applyOperations(nums1));

		final int[] nums2 = { 0, 1 };
		final int[] exp2 = { 1, 0 };
		assert Arrays.equals(exp2, applyOperations(nums2));
	}

	static int[] applyOperations(int[] nums) {
		// apply the rules first.
		final int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				// binary addition is faster than multiplication.
				nums[i] = nums[i] + nums[i];
				nums[i + 1] = 0;
			}
		}

		// then move zeros to the end.
		// partition step. Similar to Quicksort Partitioning step.
		for (int i = 0, k = -1; i < n; i++) {
			if (nums[i] != 0) {
				k = k + 1;
				final int tmp = nums[i];
				nums[i] = 0;
				nums[k] = tmp;
			}
		}
		return nums;
	}
}
