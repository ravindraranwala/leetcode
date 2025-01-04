package com.coding.challenge.prefix.sum;

class NumberOfWaysToSplitArray {
	NumberOfWaysToSplitArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 10, 4, -8, 7 };
		assert waysToSplitArray(nums1) == 2;

		final int[] nums2 = { 2, 3, 1, 0 };
		assert waysToSplitArray(nums2) == 2;
	}

	static int waysToSplitArray(int[] nums) {
		long s = 0;
		for (int num : nums)
			s = s + num;

		int c = 0;
		final int n = nums.length;
		long preSum = 0;
		for (int i = 0; i < n - 1; i++) {
			preSum = preSum + nums[i];
			if (preSum >= s - preSum)
				c = c + 1;
		}
		return c;
	}
}
