package com.coding.challenge.binary.search;

class FindMinimumInRotatedSortedArray {
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

		final int[] nums4 = { 1 };
		assert findMin(nums4) == 1;

		final int[] nums5 = { 2, 1 };
		assert findMin(nums5) == 1;
	}

	static int findMin(int[] nums) {
		final int n = nums.length;
		if (nums[0] <= nums[n - 1])
			return nums[0];

		return findMin(nums, 0, n - 1);
	}

	private static int findMin(int[] nums, int i, int j) {
		final int mid = (i + j) / 2;
		if (nums[mid] >= nums[0])
			return findMin(nums, mid + 1, j);
		if (nums[mid] < nums[mid - 1])
			return nums[mid];

		return findMin(nums, i, mid - 1);
	}
}
