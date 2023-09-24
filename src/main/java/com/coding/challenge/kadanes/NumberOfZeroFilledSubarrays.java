package com.coding.challenge.kadanes;

class NumberOfZeroFilledSubarrays {
	NumberOfZeroFilledSubarrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 3, 0, 0, 2, 0, 0, 4 };
		assert zeroFilledSubarray(numsOne) == 6;

		final int[] numsTwo = { 0, 0, 0, 2, 0, 0 };
		assert zeroFilledSubarray(numsTwo) == 9;

		final int[] numsThree = { 2, 10, 2019 };
		assert zeroFilledSubarray(numsThree) == 0;
	}

	static long zeroFilledSubarray(int[] nums) {
		final int n = nums.length;
		long c = 0;

		for (int i = 0, j = 0; j < n; j++) {
			if (nums[j] == 0)
				c = c + j - i + 1;
			else
				i = j + 1;
		}
		return c;
	}
}
