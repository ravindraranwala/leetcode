package com.coding.challenge.dp;

class MaximumAlternatingSubsequenceSum {
	MaximumAlternatingSubsequenceSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 4, 2, 5, 3 };
		assert maxAlternatingSum(numsOne) == 7;

		final int[] numsTwo = { 5, 6, 7, 8 };
		assert maxAlternatingSum(numsTwo) == 8;

		final int[] numsThree = { 6, 2, 1, 2, 4, 5 };
		assert maxAlternatingSum(numsThree) == 10;

		final int[] numsFour = { 19, 9, 1, 6, 14, 11, 9, 5, 7, 11 };
		assert maxAlternatingSum(numsFour) == 38;
	}

	static long maxAlternatingSum(int[] nums) {
		final int n = nums.length;
		// trivial case of the recursion.
		long sln = nums[0];
		for (int i = 1, lastPickedVal = nums[0], minVal = 100001; i < n; i++) {
			final long s1 = sln - lastPickedVal + nums[i];
			final long s2 = sln - minVal + nums[i];
			final long s = Math.max(Math.max(s1, s2), nums[i]);
			if (s > sln) {
				// pick the current element.
				sln = s;
				lastPickedVal = nums[i];
				minVal = 100001;
			} else
				minVal = Math.min(minVal, nums[i]);
		}
		return sln;
	}
}
