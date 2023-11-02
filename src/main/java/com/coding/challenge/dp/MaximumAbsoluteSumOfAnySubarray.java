package com.coding.challenge.dp;

class MaximumAbsoluteSumOfAnySubarray {
	MaximumAbsoluteSumOfAnySubarray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, -3, 2, 3, -4 };
		assert maxAbsoluteSum(numsOne) == 5;

		final int[] numsTwo = { 2, -5, 1, -4, 3, -2 };
		assert maxAbsoluteSum(numsTwo) == 8;
	}

	static int maxAbsoluteSum(int[] nums) {
		int largestSum = Integer.MIN_VALUE;
		int smallestSum = Integer.MAX_VALUE;
		final int n = nums.length;

		for (int i = 0, prevMin = 0, prevMax = 0; i < n; i++) {
			prevMin = Math.min(prevMin + nums[i], nums[i]);
			prevMax = Math.max(prevMax + nums[i], nums[i]);
			smallestSum = Math.min(smallestSum, prevMin);
			largestSum = Math.max(largestSum, prevMax);
		}
		return Math.max(Math.abs(smallestSum), Math.abs(largestSum));
	}
}
