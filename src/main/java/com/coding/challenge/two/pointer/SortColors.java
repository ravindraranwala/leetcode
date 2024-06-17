package com.coding.challenge.two.pointer;

import java.util.Arrays;

class SortColors {
	SortColors() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 0, 2, 1, 1, 0 };
		sortColors(nums1);
		final int[] expected1 = { 0, 0, 1, 1, 2, 2 };
		assert Arrays.equals(expected1, nums1);

		final int[] nums2 = { 2, 0, 1 };
		sortColors(nums2);
		final int[] expected2 = { 0, 1, 2 };
		assert Arrays.equals(expected2, nums2);
	}

	/*
	 * An extension of the Quick Sort Partition algorithm. In Quick Sort, we have
	 * just two partitions whereas here we have four partitions.
	 */
	static void sortColors(int[] nums) {
		final int n = nums.length;
		for (int k = 0, i = -1, j = -1; k < n; k++) {
			if (nums[k] == 0) {
				i = i + 1;
				j = j + 1;
				exchange(nums, j, k);
				exchange(nums, i, j);
			} else if (nums[k] == 1) {
				j = j + 1;
				exchange(nums, j, k);
			}
		}
	}

	private static void exchange(int[] a, int i, int j) {
		final int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
