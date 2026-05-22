package com.coding.challenge.binary.search;

import com.coding.challenge.BinarySearch;
import com.coding.challenge.dc.FindMinimumInRotatedSortedArray;

class SearchInRotatedSortedArray {
	SearchInRotatedSortedArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
		assert search(nums1, 0) == 4;

		final int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
		assert search(nums2, 3) == -1;

		final int[] nums3 = { 1 };
		assert search(nums3, 0) == -1;
	}

	static int search(int[] nums, int target) {
		final int n = nums.length;
		final int k = FindMinimumInRotatedSortedArray.findPeak(nums, 0, n - 1);
		final int i = BinarySearch.search(nums, target, 0, k);
		if (i != -1)
			return i;

		return BinarySearch.search(nums, target, k + 1, n - 1);
	}
}
