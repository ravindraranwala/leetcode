package com.coding.challenge.array;

class CountSubarraysOfLengthThreeWithCondition {
	CountSubarraysOfLengthThreeWithCondition() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1, 2, 1, 4, 1 };
		assert countSubarrays(nums1) == 1;

		final int[] nums2 = { 1, 1, 1 };
		assert countSubarrays(nums2) == 0;
	}

	static int countSubarrays(int[] nums) {
		final int n = nums.length;
		int c = 0;
		for (int i = 2; i < n; i++)
			if ((nums[i] + nums[i - 2]) * 2 == nums[i - 1])
				c = c + 1;

		return c;
	}
}
