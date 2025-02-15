package com.coding.challenge.hash.table;

class MaxSumOfPairWithEqualSumOfDigits {
	MaxSumOfPairWithEqualSumOfDigits() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] nums1 = { 18, 43, 36, 13, 7 };
		assert maximumSum(nums1) == 54;

		final int[] nums2 = { 10, 12, 19, 14 };
		assert maximumSum(nums2) == -1;
	}

	static int maximumSum(int[] nums) {
		final int[] t = new int[90];
		int ans = -1;
		for (int val : nums) {
			final int sum = digitSum(val);
			if (t[sum] != 0 && t[sum] + val > ans)
				ans = t[sum] + val;

			if (val > t[sum])
				t[sum] = val;
		}

		return ans;
	}

	private static int digitSum(int num) {
		int currNum = num;
		int s = 0;
		while (currNum > 0) {
			s = s + (currNum % 10);
			currNum = currNum / 10;
		}
		return s;
	}
}
