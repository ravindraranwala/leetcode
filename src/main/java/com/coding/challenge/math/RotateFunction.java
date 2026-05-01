package com.coding.challenge.math;

class RotateFunction {
	RotateFunction() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 4, 3, 2, 6 };
		assert maxRotateFunction(nums1) == 26;

		final int[] nums2 = { 100 };
		assert maxRotateFunction(nums2) == 0;
	}

	static int maxRotateFunction(int[] nums) {
		final int n = nums.length;
		int prevF = 0;
		int s = 0;
		for (int i = 0; i < n; i++) {
			prevF = prevF + i * nums[i];
			s = s + nums[i];
		}

		int maxF = prevF;
		for (int i = 1; i < n; i++) {
			final int currF = prevF - (nums[n - i] * (n - 1)) + s - nums[n - i];
			maxF = Math.max(maxF, currF);
			prevF = currF;
		}

		return maxF;
	}
}
