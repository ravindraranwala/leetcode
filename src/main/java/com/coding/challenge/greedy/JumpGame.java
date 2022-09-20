package com.coding.challenge.greedy;

class JumpGame {
	JumpGame() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 2, 3, 1, 1, 4 };
		assert canJump(numsOne);

		final int[] numsTwo = { 3, 2, 1, 0, 4 };
		assert !canJump(numsTwo);
	}

	/*
	 * Optimal greedy solution.
	 */
	static boolean canJump(int[] nums) {
		final int n = nums.length;
		int j = n - 1;

		for (int i = n - 2; i >= 0; i--) {
			if (i + nums[i] >= j)
				j = i;
		}
		return j == 0;
	}
}