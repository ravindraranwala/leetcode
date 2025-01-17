package com.coding.challenge.bit.manipulation;

class BitwiseXOROfAllPairings {
	BitwiseXOROfAllPairings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 2, 1, 3 };
		final int[] nums2 = { 10, 2, 5, 0 };
		assert xorAllNums(nums1, nums2) == 13;

		final int[] nums3 = { 1, 2 };
		final int[] nums4 = { 3, 4 };
		assert xorAllNums(nums3, nums4) == 0;

		final int[] nums5 = { 1, 2 };
		final int[] nums6 = { 3, 4, 5 };
		assert xorAllNums(nums5, nums6) == 3;

		final int[] nums7 = { 1, 2, 3 };
		final int[] nums8 = { 4, 5, 6 };
		assert xorAllNums(nums7, nums8) == 7;
	}

	static int xorAllNums(int[] nums1, int[] nums2) {
		final int m = nums1.length;
		final int n = nums2.length;
		if (m % 2 == 0 && n % 2 == 0)
			return 0;

		int xor1 = 0;
		for (int val : nums1)
			xor1 = xor1 ^ val;
		int xor2 = 0;
		for (int val : nums2)
			xor2 = xor2 ^ val;
		if (m % 2 == 1 && n % 2 == 1)
			return xor1 ^ xor2;
		if (m % 2 == 1)
			return xor2;
		return xor1;
	}
}
