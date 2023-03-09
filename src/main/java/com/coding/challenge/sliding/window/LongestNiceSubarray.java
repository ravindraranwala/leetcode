package com.coding.challenge.sliding.window;

class LongestNiceSubarray {
	LongestNiceSubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 3, 8, 48, 10 };
		assert longestNiceSubarray(numsOne) == 3;

		final int[] numsTwo = { 3, 1, 5, 11, 13 };
		assert longestNiceSubarray(numsTwo) == 1;
	}

	static int longestNiceSubarray(int[] nums) {
		final int n = nums.length;
		int l = 0;
		for (int i = 0, j = 0, or = 0, sum = 0; j < n; j++) {
			sum = sum + nums[j];
			// Bitwise XOR ^ operator also would do
			while ((or | nums[j]) < sum) {
				or = or - nums[i];
				sum = sum - nums[i];
				i = i + 1;
			}
			or = or | nums[j];
			l = Math.max(l, j - i + 1);
		}
		return l;
	}
}
