package com.coding.challenge.math;

import java.util.Arrays;

class MinimumMovesToEqualArrayElementsII {
	MinimumMovesToEqualArrayElementsII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 1, 2, 3 };
		assert minMoves2(numsOne) == 2;

		final int[] numsTwo = { 1, 10, 2, 9 };
		assert minMoves2(numsTwo) == 16;
	}

	static int minMoves2(int[] nums) {
		final int n = nums.length;
		Arrays.sort(nums);
		final int median = nums[n/ 2];
		int moves = 0;
		for (int num : nums)
			moves = moves + Math.abs(num - median);

		return moves;
	}
}
