package com.coding.challenge.radix.sort;

import java.util.Arrays;

class SortTheJumbledNumbers {

	SortTheJumbledNumbers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] mappings1 = { 8, 9, 4, 0, 2, 1, 3, 5, 7, 6 };
		final int[] nums1 = { 991, 338, 38 };
		final int[] sorted1 = { 338, 38, 991 };
		assert Arrays.equals(sorted1, sortJumbled(mappings1, nums1));

		final int[] mappings2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		final int[] nums2 = { 789, 456, 123 };
		final int[] sorted2 = { 123, 456, 789 };
		assert Arrays.equals(sorted2, sortJumbled(mappings2, nums2));

		final int[] mappings3 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		final int[] nums3 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		final int[] sorted3 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		assert Arrays.equals(sorted3, sortJumbled(mappings3, nums3));
	}

	static int[] sortJumbled(int[] mapping, int[] nums) {
		return radixSort(nums, 10, mapping);
	}

	private static int[] radixSort(int[] nums, int d, int[] mapping) {
		int[] b = nums;
		for (int i = 0; i < d; i++)
			b = countingSort(b, 9, i, mapping);
		return b;
	}

	private static int[] countingSort(int[] nums, int k, int d, int[] mapping) {
		// Stable sort.
		final int n = nums.length;
		final int[] b = new int[n];
		final int[] c = new int[k + 1];

		final int denominator = (int) Math.pow(10, d);
		for (int j = 0; j < n; j++) {
			final int digit = nums[j] == 0 || nums[j] >= denominator ? mapping[(nums[j] / denominator) % (k + 1)] : 0;
			c[digit] = c[digit] + 1;
		}

		for (int i = 1; i <= k; i++)
			c[i] = c[i] + c[i - 1];

		for (int j = n - 1; j >= 0; j--) {
			final int digit = nums[j] == 0 || nums[j] >= denominator ? mapping[(nums[j] / denominator) % (k + 1)] : 0;
			b[c[digit] - 1] = nums[j];
			c[digit] = c[digit] - 1;
		}
		return b;
	}
}
