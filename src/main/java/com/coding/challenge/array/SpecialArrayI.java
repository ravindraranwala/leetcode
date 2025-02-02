package com.coding.challenge.array;

class SpecialArrayI {
	SpecialArrayI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 1 };
		assert isArraySpecial(nums1);

		final int[] nums2 = { 2, 1, 4 };
		assert isArraySpecial(nums2);

		final int[] nums3 = { 4, 3, 1, 6 };
		assert !isArraySpecial(nums3);
	}

	static boolean isArraySpecial(int[] nums) {
		final int n = nums.length;
		for (int i = 1; i < n; i++)
			if ((nums[i - 1] + nums[i]) % 2 == 0)
				return false;

		return true;
	}
}
