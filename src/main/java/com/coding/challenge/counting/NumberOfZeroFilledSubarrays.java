package com.coding.challenge.counting;

class NumberOfZeroFilledSubarrays {
	NumberOfZeroFilledSubarrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 3, 0, 0, 2, 0, 0, 4 };
		assert zeroFilledSubarray(nums1) == 6;

		final int[] nums2 = { 0, 0, 0, 2, 0, 0 };
		assert zeroFilledSubarray(nums2) == 9;

		final int[] nums3 = { 2, 10, 2019 };
		assert zeroFilledSubarray(nums3) == 0;
	}

	static long zeroFilledSubarray(int[] nums) {
		final int n = nums.length;
		long ans = 0;
		for (int i = 0, c = 0; i < n; i++) {
			if (nums[i] == 0)
				c = c + 1;
			else
				c = 0;

			ans = ans + c;
		}
		return ans;
	}
}
