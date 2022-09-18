package com.coding.challenge.dp;

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
	 * Sub-optimal dynamic programming solution.
	 */
	static boolean canJumpV1(int[] nums) {
		final int n = nums.length;
		final boolean[] r = new boolean[n];
		for (int i = 0; i < n; i++)
			r[i] = false;
		r[n - 1] = true;

		for (int i = n - 2; i >= 0; i--) {
			final int f = Math.min(i + nums[i], n - 1);
			for (int j = i + 1; j <= f; j++)
				r[i] = r[i] || r[j];
		}
		return r[0];
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
