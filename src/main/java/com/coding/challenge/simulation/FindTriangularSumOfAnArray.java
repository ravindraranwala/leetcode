package com.coding.challenge.simulation;

class FindTriangularSumOfAnArray {
	FindTriangularSumOfAnArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 3, 4, 5 };
		assert triangularSum(nums1) == 8;

		final int[] nums2 = { 5 };
		assert triangularSum(nums2) == 5;
	}

	static int triangularSum(int[] nums) {
		final int n = nums.length;
		for (int l = n - 1; l > 0; l--)
			for (int i = 0; i < l; i++)
				nums[i] = (nums[i] + nums[i + 1]) % 10;

		return nums[0];
	}
}
