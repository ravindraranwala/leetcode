package com.coding.challenge.dc;

public class FindMinimumInRotatedSortedArray {
	FindMinimumInRotatedSortedArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 3, 4, 5, 1, 2 };
		assert findMin(nums1) == 1;

		final int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
		assert findMin(nums2) == 0;

		final int[] nums3 = { 11, 13, 15, 17 };
		assert findMin(nums3) == 11;
	}

	static int findMin(int[] nums) {
		final int n = nums.length;
		final int i = findPeak(nums, 0, n - 1);
		return nums[(i + 1) % n];
	}

	public static int findPeak(int[] a, int i, int j) {
		if (i == j)
			return i;

		final int mid = (i + j + 1) / 2;
		if (a[mid] < a[i])
			return findPeak(a, i, mid - 1);
		else
			return findPeak(a, mid, j);
	}
}
