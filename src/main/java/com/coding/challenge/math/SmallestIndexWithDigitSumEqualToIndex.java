package com.coding.challenge.math;

import com.coding.challenge.util.math.NumUtil;

class SmallestIndexWithDigitSumEqualToIndex {
	SmallestIndexWithDigitSumEqualToIndex() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 2 };
		assert smallestIndex(nums1) == 2;

		final int[] nums2 = { 1, 10, 11 };
		assert smallestIndex(nums2) == 1;

		final int[] nums3 = { 1, 2, 3 };
		assert smallestIndex(nums3) == -1;
	}

	static int smallestIndex(int[] nums) {
		final int n = nums.length;
		for (int i = 0; i < n; i++)
			if (i == NumUtil.digitSum(nums[i]))
				return i;

		return -1;
	}
}
