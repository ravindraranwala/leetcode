package com.coding.challenge.radix.sort;

import java.util.Arrays;

class SortAnArray {
	SortAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 5, 2, 3, 1 };
		System.out.println(Arrays.toString(sortArray(nums1)));

		final int[] nums2 = { 5, 1, 1, 2, 0, 0 };
		System.out.println(Arrays.toString(sortArray(nums2)));
	}

	static int[] sortArray(int[] nums) {
		// perform a linear transformation of the vector space.
		final int additiveFactor = 50000;
		final int n = nums.length;
		for (int i = 0; i < n; i++)
			nums[i] = nums[i] + additiveFactor;
		final int[] sortedNums = RadixSort.radixSort(nums, 6);
		// perform a reverse transformation.
		for (int i = 0; i < n; i++)
			sortedNums[i] = sortedNums[i] - additiveFactor;
		return sortedNums;
	}
}
