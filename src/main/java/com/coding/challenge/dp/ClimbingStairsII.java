package com.coding.challenge.dp;

class ClimbingStairsII {
	ClimbingStairsII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] costs1 = { 1, 2, 3, 4 };
		assert climbStairs(4, costs1) == 13;

		final int[] costs2 = { 5, 1, 6, 2 };
		assert climbStairs(4, costs2) == 11;

		final int[] costs3 = { 9, 8, 3 };
		assert climbStairs(3, costs3) == 12;

		final int[] costs4 = { 9 };
		assert climbStairs(1, costs4) == 10;
	}

	static int climbStairs(int n, int[] costs) {
		final int[] c = new int[n + 1];
		c[1] = 1 + costs[0];
		if (n == 1)
			return c[1];

		c[2] = Math.min(c[0] + 4, c[1] + 1) + costs[1];
		for (int j = 3; j <= n; j++)
			c[j] = Math.min(Math.min(c[j - 1] + 1, c[j - 2] + 4), c[j - 3] + 9) + costs[j - 1];

		return c[n];
	}
}
