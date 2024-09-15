package com.coding.challenge.binary.search;

import com.coding.challenge.BinarySearch;

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

		final int[] nums4 = { 1, 3 };
		assert search(nums4, 0) == -1;

		final int[] nums5 = { 3, 1 };
		assert search(nums5, 1) == 1;

		final int[] nums6 = { 5, 1, 3 };
		assert search(nums6, 1) == 1;
	}

	static int search(int[] nums, int target) {
		final int n = nums.length;
		final int i = partitionPoint(nums, target);
		if (target >= nums[i] && target <= nums[n - 1])
			// target is in the right hand side partition.
			return BinarySearch.search(nums, target, i, n - 1);
		else
			// target is in the left hand side partition.
			return BinarySearch.search(nums, target, 0, i - 1);
	}

	private static int partitionPoint(int[] nums, int target, int i, int j) {
		// trivial cases of the recursion comes first.
		if (i == j)
			return i;

		final int mid = (i + j) / 2;
		if (mid > 0 && nums[mid] < nums[mid - 1])
			return mid;

		if (nums[mid] >= nums[0])
			// move to right half
			return partitionPoint(nums, target, mid + 1, j);
		else
			// move to the left half.
			return partitionPoint(nums, target, i, mid - 1);
	}

	private static int partitionPoint(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		while (l < r) {
			final int mid = (l + r) / 2;
			if (mid > 0 && nums[mid] < nums[mid - 1])
				return mid;

			if (nums[mid] >= nums[0])
				l = mid + 1;
			else
				r = mid - 1;
		}
		return l;
	}
}
