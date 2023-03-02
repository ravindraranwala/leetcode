package com.coding.challenge.sliding.window;

class MinimumOperationsToReduceX {
	MinimumOperationsToReduceX() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 1, 4, 2, 3 };
		assert minOperations(numsOne, 5) == 2;

		final int[] numsTwo = { 5, 6, 7, 8, 9 };
		assert minOperations(numsTwo, 4) == -1;

		final int[] numsThree = { 3, 2, 20, 1, 1, 3 };
		assert minOperations(numsThree, 10) == 5;

		final int[] numsFour = { 1, 1 };
		assert minOperations(numsFour, 3) == -1;

		final int[] numsFive = { 8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819,
				1231, 6309 };
		assert minOperations(numsFive, 134365) == 16;
	}

	static int minOperations(int[] nums, int x) {
		final int n = nums.length;
		int total = 0;
		for (int val : nums)
			total = total + val;
		if (x > total)
			return -1;
		if (x == total)
			return n;
		int l = 0;

		for (int i = 0, j = 0, windowSum = 0, expSum = total - x; j < n; j++) {
			windowSum = windowSum + nums[j];
			while (windowSum > expSum) {
				windowSum = windowSum - nums[i];
				i = i + 1;
			}
			if (windowSum == expSum)
				l = Math.max(l, j - i + 1);
		}
		return l == 0 ? -1 : n - l;
	}
}
