package com.coding.challenge.dp;

class FertilePyramids {

	FertilePyramids() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] m1 = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 } };
		int cnt = countPyramids(m1);
		assert cnt == 2;

		final int[][] m2 = { { 1, 1, 1 }, { 1, 1, 1 } };
		cnt = countPyramids(m2);
		assert cnt == 2;

		final int[][] m3 = { { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 0, 1, 0, 0, 1 } };
		cnt = countPyramids(m3);
		assert cnt == 13;
	}

	static int countPyramids(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[][] p = new int[m][n];
		final int[][] q = new int[m][n]; // inverse pyramids.

		// base case of the recursion
		for (int i = 0; i < m; i++) {
			p[i][0] = 0;
			p[i][n - 1] = 0;
			q[i][0] = 0;
			q[i][n - 1] = 0;
		}

		for (int j = 1; j < n - 1; j++) {
			p[m - 1][j] = 0;
			q[0][j] = 0;
		}

		int ans = 0;
		// compute pyramidal plots, starting from the bottom
		for (int i = m - 2; i >= 0; i--) {
			for (int j = 1; j < n - 1; j++) {
				if (grid[i][j] == 1 && grid[i + 1][j - 1] == 1 && grid[i + 1][j] == 1 && grid[i + 1][j + 1] == 1) {
					p[i][j] = Math.min(p[i + 1][j - 1], Math.min(p[i + 1][j], p[i + 1][j + 1])) + 1;
					ans = ans + p[i][j];
				} else
					p[i][j] = 0;
			}
		}

		// compute inverse pyramidal plots, starting from the top
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (grid[i][j] == 1 && grid[i - 1][j - 1] == 1 && grid[i - 1][j] == 1 && grid[i - 1][j + 1] == 1) {
					q[i][j] = Math.min(q[i - 1][j - 1], Math.min(q[i - 1][j], q[i - 1][j + 1])) + 1;
					ans = ans + q[i][j];
				} else
					q[i][j] = 0;
			}
		}
		return ans;
	}
}
