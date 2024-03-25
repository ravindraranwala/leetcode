package com.coding.challenge.dp;

class NumberOfDiceRollsWithTargetSum {
	private static final int REM = 1000000007;

	NumberOfDiceRollsWithTargetSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numRollsToTarget(1, 6, 3) == 1;
		assert numRollsToTarget(2, 6, 7) == 6;
		assert numRollsToTarget(30, 30, 500) == 222616187;
	}

	static int numRollsToTarget(int n, int k, int target) {
		final int[][] t = new int[target + 1][n + 1];
		// trivial case of the recursion.
		final int bound = Math.min(k, target);
		for (int i = 1; i <= bound; i++)
			t[i][1] = 1;

		for (int i = 1; i <= target; i++)
			for (int j = 2; j <= n; j++)
				for (int f = 1; f <= k; f++)
					if (i > f)
						t[i][j] = (t[i][j] + t[i - f][j - 1]) % REM;
		return t[target][n];
	}
}
