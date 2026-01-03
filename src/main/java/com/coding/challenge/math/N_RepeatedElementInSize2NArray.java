package com.coding.challenge.math;

class N_RepeatedElementInSize2NArray {
	N_RepeatedElementInSize2NArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 3 };
		assert repeatedNTimes(nums1) == 3;

		final int[] nums2 = { 2, 1, 2, 5, 3, 2 };
		assert repeatedNTimes(nums2) == 2;

		final int[] nums3 = { 5, 1, 5, 2, 5, 3, 5, 4 };
		assert repeatedNTimes(nums3) == 5;
	}

	static int repeatedNTimes(int[] nums) {
		final int l = nums.length;
		for (int i = 0; i + 2 < l; i = i + 3) {
			if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2])
				return nums[i];
			if (nums[i + 1] == nums[i + 2])
				return nums[i + 1];
		}

		return nums[l - 1];
	}
}
