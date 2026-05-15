package com.coding.challenge.hash.table;

class CheckIfArrayIsGood {
	CheckIfArrayIsGood() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 1, 3 };
		assert !isGood(nums1);

		final int[] nums2 = { 1, 3, 3, 2 };
		assert isGood(nums2);

		final int[] nums3 = { 1, 1 };
		assert isGood(nums3);

		final int[] nums4 = { 3, 4, 4, 1, 2, 1 };
		assert !isGood(nums4);
	}

	static boolean isGood(int[] nums) {
		final int n = nums.length;
		final int[] f = new int[n];

		for (int i = 0; i < n; i++) {
			if (nums[i] < 1 || nums[i] >= n)
				return false;

			f[nums[i]] = f[nums[i]] + 1;
		}

		for (int j = 1; j < n - 1; j++)
			if (f[j] != 1)
				return false;

		return f[n - 1] == 2;
	}
}
