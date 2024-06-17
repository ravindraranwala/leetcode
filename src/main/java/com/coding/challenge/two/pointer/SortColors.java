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
	 * just two partitions whereas here we have three partitions.
	 */
	static void sortColors(int[] nums) {
		final int n = nums.length;
		for (int i = 0, zeroIdx = -1, oneIdx = -1, twoIdx = -1; i < n; i++) {
			if (nums[i] == 0) {
				zeroIdx = zeroIdx + 1;
				oneIdx = oneIdx + 1;
				twoIdx = twoIdx + 1;
				exchange(nums, oneIdx, twoIdx);
				exchange(nums, zeroIdx, oneIdx);
			} else if (nums[i] == 1) {
				oneIdx = oneIdx + 1;
				twoIdx = twoIdx + 1;
				exchange(nums, oneIdx, twoIdx);
			} else
				twoIdx = twoIdx + 1;
		}
	}

	private static void exchange(int[] a, int i, int j) {
		final int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
