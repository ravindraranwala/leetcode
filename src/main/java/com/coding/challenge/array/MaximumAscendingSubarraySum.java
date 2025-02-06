package com.coding.challenge.array;

class MaximumAscendingSubarraySum {
	MaximumAscendingSubarraySum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 10, 20, 30, 5, 10, 50 };
		assert maxAscendingSum(nums1) == 65;

		final int[] nums2 = { 10, 20, 30, 40, 50 };
		assert maxAscendingSum(nums2) == 150;

		final int[] nums3 = { 12, 17, 15, 13, 10, 11, 12 };
		assert maxAscendingSum(nums3) == 33;
	}

	static int maxAscendingSum(int[] nums) {
		final int n = nums.length;
		int sum = nums[0];

		for (int i = 1, s = nums[0]; i < n; i++) {
			if (nums[i] > nums[i - 1]) {
				s = s + nums[i];
				sum = Math.max(sum, s);
			} else
				s = nums[i];
		}
		return sum;
	}
}
