package com.coding.challenge.dp;

class MinimumPathSum {
	MinimumPathSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		assert minPathSum(gridOne) == 7;

		final int[][] gridTwo = { { 1, 2, 3 }, { 4, 5, 6 } };
		assert minPathSum(gridTwo) == 12;
	}

	static int minPathSum(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[][] p = new int[m][n];
		p[m - 1][n - 1] = grid[m - 1][n - 1];

		// base case of the recursion
		for (int i = m - 2; i >= 0; i--)
			p[i][n - 1] = p[i + 1][n - 1] + grid[i][n - 1];

		for (int j = n - 2; j >= 0; j--)
			p[m - 1][j] = p[m - 1][j + 1] + grid[m - 1][j];

		for (int i = m - 2; i >= 0; i--)
			for (int j = n - 2; j >= 0; j--)
				p[i][j] = Math.min(p[i][j + 1], p[i + 1][j]) + grid[i][j];

		return p[0][0];
	}
}
