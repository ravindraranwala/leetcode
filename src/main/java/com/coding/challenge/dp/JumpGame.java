package com.coding.challenge.dp;

class JumpGame {
	JumpGame() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] numsOne = { 2, 3, 1, 1, 4 };
		System.out.println(canJump(numsOne));

		final int[] numsTwo = { 3, 2, 1, 0, 4 };
		System.out.println(canJump(numsTwo));
	}

	static boolean canJump(int[] nums) {
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
}
