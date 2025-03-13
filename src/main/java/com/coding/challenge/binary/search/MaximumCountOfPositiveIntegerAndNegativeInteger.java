package com.coding.challenge.binary.search;

import com.coding.challenge.BinarySearch;

class MaximumCountOfPositiveIntegerAndNegativeInteger {
	MaximumCountOfPositiveIntegerAndNegativeInteger() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { -2, -1, -1, 1, 2, 3 };
		assert maximumCount(nums1) == 3;

		final int[] nums2 = { -3, -2, -1, 0, 0, 1, 2 };
		assert maximumCount(nums2) == 3;

		final int[] nums3 = { 5, 20, 66, 1314 };
		assert maximumCount(nums3) == 4;

		final int[] nums4 = { -1 };
		assert maximumCount(nums4) == 1;

		final int[] nums5 = { 0 };
		assert maximumCount(nums5) == 0;
	}

	static int maximumCount(int[] nums) {
		final int i = BinarySearch.successor(nums, -1);
		final int j = BinarySearch.predecessor(nums, 1);
		return Math.max(i, nums.length - 1 - j);
	}
}
