package com.coding.challenge.math;

class MinimumMovesToEqualArrayElements {
	MinimumMovesToEqualArrayElements() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 3 };
		assert minMoves(numsOne) == 3;

		final int[] numsTwo = { 1, 1, 1 };
		assert minMoves(numsTwo) == 0;

		final int[] numsThree = { 5, 6, 8, 8, 5 };
		assert minMoves(numsThree) == 7;
	}

	static int minMoves(int[] nums) {
		int smallest = nums[0];
		for (int num : nums)
			smallest = Math.min(smallest, num);

		int m = 0;
		for (int num : nums)
			m = m + num - smallest;

		return m;
	}
}
