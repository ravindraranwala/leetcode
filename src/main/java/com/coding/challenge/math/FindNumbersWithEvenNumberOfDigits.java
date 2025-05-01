package com.coding.challenge.math;

class FindNumbersWithEvenNumberOfDigits {
	FindNumbersWithEvenNumberOfDigits() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 12, 345, 2, 6, 7896 };
		assert findNumbers(nums1) == 2;

		final int[] nums2 = { 555, 901, 482, 1771 };
		assert findNumbers(nums2) == 1;
	}

	static int findNumbers(int[] nums) {
		int c = 0;
		for (int val : nums)
			if ((val >= 10 && val < 100) || (val >= 1000 && val < 10000) || (val >= 100000 && val < 1000000)
					|| (val >= 10000000 && val < 100000000))
				c = c + 1;

		return c;
	}
}
