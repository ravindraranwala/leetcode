package com.coding.challenge.dc;

class FindPeakElement {
	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 1 };
		assert findPeakElement(nums1) == 2;

		final int[] nums2 = { 1, 2, 1, 3, 5, 6, 4 };
		assert findPeakElement(nums2) == 5;

		final int[] nums3 = { 2, 1 };
		assert findPeak(nums3, 0, 1) == 0;

		final int[] nums4 = { 1, 2 };
		assert findPeak(nums4, 0, 1) == 1;

		final int[] nums5 = { 1 };
		assert findPeak(nums5, 0, 0) == 0;
	}

	static int findPeakElement(int[] nums) {
		return findPeak(nums, 0, nums.length - 1);
	}

	private static int findPeak(int[] nums, int i, int j) {
		if (i == j)
			return i;
		if (j - i + 1 == 2) {
			if (nums[i] > nums[j])
				return i;
			else
				return j;
		}
		final int mid = (i + j) / 2;
		if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
			return mid;
		if (nums[mid + 1] > nums[mid - 1])
			return findPeak(nums, mid + 1, j);
		else
			return findPeak(nums, i, mid - 1);
	}
}
