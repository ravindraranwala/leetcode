package com.coding.challenge.dp;

class MaximumNonNegativeProductInMatrix {
	private static final int REM = 1000000007;

	MaximumNonNegativeProductInMatrix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { -1, -2, -3 }, { -2, -3, -3 }, { -3, -3, -2 } };
		assert maxProductPath(grid1) == -1;

		final int[][] grid2 = { { 1, -2, 1 }, { 1, -2, 1 }, { 3, -4, 1 } };
		assert maxProductPath(grid2) == 8;

		final int[][] grid3 = { { 1, 3 }, { 0, -4 } };
		assert maxProductPath(grid3) == 0;

		final int[][] grid4 = { { 1, -1, 2, 1, -1, 0, 0, 4, 3, 2, 0, -2, -2 },
				{ -2, 3, 3, -1, -1, 0, 0, -2, 4, -3, 3, 0, 0 }, { -4, -1, -1, -2, 2, -1, -2, -2, 0, 3, -1, -4, 1 },
				{ -3, 4, -3, 0, -3, 1, -3, 1, 4, 4, -4, -4, -2 }, { 3, -3, 1, 0, -1, -4, -4, -4, 3, 2, 2, 3, 3 },
				{ 2, -1, -1, -4, -3, -3, 4, 2, 3, 4, 4, -4, 0 }, { 4, -1, 2, -3, -1, -1, -3, -4, 4, 4, 4, -3, -1 },
				{ -3, -4, 4, -2, -1, 2, 3, -1, 2, 3, 4, 4, -4 }, { -3, -1, -2, 1, 1, -1, -3, -4, -3, 1, -3, 3, -4 },
				{ 2, 4, 4, 4, -3, -3, 1, -1, 3, 4, -1, 1, 4 }, { 2, -2, 0, 4, -1, 0, -2, 4, -4, 0, 0, 2, -3 },
				{ 1, 1, -3, 0, -4, -4, -4, -4, 0, -1, -4, -1, 0 }, { 3, -1, -3, -3, -3, -2, -1, 4, -1, -2, 4, 2, 3 } };
		assert maxProductPath(grid4) == 459630706;

		final int[][] grid5 = { { -1, -4, 2 }, { 4, 3, -1 }, { 2, -4, 4 }, { 1, -1, -4 } };
		assert maxProductPath(grid5) == 768;
	}

	static int maxProductPath(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final long[][] maxPath = new long[m][n];
		final long[][] minPath = new long[m][n];
		// trivial case of the recursion.
		maxPath[0][0] = grid[0][0];
		minPath[0][0] = grid[0][0];
		for (int j = 1; j < n; j++) {
			if (grid[0][j] >= 0) {
				maxPath[0][j] = maxPath[0][j - 1] * grid[0][j] * 1l;
				minPath[0][j] = minPath[0][j - 1] * grid[0][j] * 1l;
			} else {
				maxPath[0][j] = minPath[0][j - 1] * grid[0][j] * 1l;
				minPath[0][j] = maxPath[0][j - 1] * grid[0][j] * 1l;
			}
		}

		for (int i = 1; i < m; i++) {
			if (grid[i][0] >= 0) {
				maxPath[i][0] = maxPath[i - 1][0] * grid[i][0] * 1l;
				minPath[i][0] = minPath[i - 1][0] * grid[i][0] * 1l;
			} else {
				maxPath[i][0] = minPath[i - 1][0] * grid[i][0] * 1l;
				minPath[i][0] = maxPath[i - 1][0] * grid[i][0] * 1l;
			}
		}

		// recursive step.
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (grid[i][j] >= 0) {
					maxPath[i][j] = Math.max(maxPath[i][j - 1], maxPath[i - 1][j]) * grid[i][j] * 1l;
					minPath[i][j] = Math.min(minPath[i][j - 1], minPath[i - 1][j]) * grid[i][j] * 1l;
				} else {
					maxPath[i][j] = Math.min(minPath[i][j - 1], minPath[i - 1][j]) * grid[i][j] * 1l;
					minPath[i][j] = Math.max(maxPath[i][j - 1], maxPath[i - 1][j]) * grid[i][j] * 1l;
				}
			}
		}

		return maxPath[m - 1][n - 1] >= 0 ? (int) (maxPath[m - 1][n - 1] % REM) : -1;
	}
}
