package com.coding.challenge.math;

class MinimumElementAfterReplacementWithDigitSum {
	MinimumElementAfterReplacementWithDigitSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 10, 12, 13, 14 };
		assert minElement(nums1) == 1;

		final int[] nums2 = { 1, 2, 3, 4 };
		assert minElement(nums2) == 1;

		final int[] nums3 = { 999, 19, 199 };
		assert minElement(nums3) == 10;
	}

	static int minElement(int[] nums) {
		int minDigitSum = Integer.MAX_VALUE;
		for (int num : nums)
			minDigitSum = Math.min(minDigitSum, digitSum(num));

		return minDigitSum;
	}

	private static int digitSum(int num) {
		int ds = 0;
		for (int currNum = num; currNum > 0; currNum = currNum / 10)
			ds = ds + currNum % 10;

		return ds;
	}
}
