package com.coding.challenge.array;

class MaximumDifferenceBetweenIncreasingElements {
	MaximumDifferenceBetweenIncreasingElements() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 7, 1, 5, 4 };
		assert maximumDifference(nums1) == 4;

		final int[] nums2 = { 9, 4, 3, 2 };
		assert maximumDifference(nums2) == -1;

		final int[] nums3 = { 1, 5, 2, 10 };
		assert maximumDifference(nums3) == 9;
	}

	static int maximumDifference(int[] nums) {
		final int n = nums.length;
		int maxDiff = -1;
		for (int i = n - 1, maxElt = Integer.MIN_VALUE; i >= 0; i--) {
			if (maxElt > nums[i])
				maxDiff = Math.max(maxDiff, maxElt - nums[i]);
			else
				maxElt = nums[i];
		}
		return maxDiff;
	}
}
