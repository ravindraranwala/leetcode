package com.coding.challenge.dp;

class PathSumDivisibleByK {
	private static final int MOD = 1000000007;

	PathSumDivisibleByK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 5, 2, 4 }, { 3, 0, 5 }, { 0, 7, 2 } };
		assert 2 == numberOfPaths(gridOne, 3);

		final int[][] gridTwo = { { 0, 0 } };
		assert 1 == numberOfPaths(gridTwo, 5);

		final int[][] gridThree = { { 7, 3, 4, 9 }, { 2, 3, 6, 2 }, { 2, 3, 7, 0 } };
		assert 10 == numberOfPaths(gridThree, 1);
	}

	static int numberOfPaths(int[][] grid, int k) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[][][] p = new int[m][n][k];
		// base case of the recurrence
		p[m - 1][n - 1][grid[m - 1][n - 1] % k] = 1;
		for (int i = m - 2; i >= 0; i--)
			for (int l = 0; l < k; l++)
				p[i][n - 1][(l + grid[i][n - 1]) % k] = p[i + 1][n - 1][l];

		for (int j = n - 2; j >= 0; j--)
			for (int l = 0; l < k; l++)
				p[m - 1][j][(l + grid[m - 1][j]) % k] = p[m - 1][j + 1][l];

		// recursive step.
		for (int i = m - 2; i >= 0; i--)
			for (int j = n - 2; j >= 0; j--)
				for (int l = 0; l < k; l++)
					p[i][j][(l + grid[i][j]) % k] = (p[i + 1][j][l] + p[i][j + 1][l]) % MOD;

		return p[0][0][0];
	}
}
