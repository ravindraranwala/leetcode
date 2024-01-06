package com.coding.challenge.bit.manipulation;

class SingleNumber {
	SingleNumber() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 2, 1 };
		assert singleNumber(nums1) == 1;

		final int[] nums2 = { 4, 1, 2, 1, 2 };
		assert singleNumber(nums2) == 4;

		final int[] nums3 = { 1 };
		assert singleNumber(nums3) == 1;
	}

	static int singleNumber(int[] nums) {
		int ans = 0;
		for (int val : nums)
			ans = ans ^ val;

		return ans;
	}
}
