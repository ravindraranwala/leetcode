package com.coding.challenge.dp;

class NumberOfIncreasingPathsInGrid {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	private static final int MOD = 1000000000 + 7;

	NumberOfIncreasingPathsInGrid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 1, 1 }, { 3, 4 } };
		assert countPaths(gridOne) == 8;

		final int[][] gridTwo = { { 1 }, { 2 } };
		assert countPaths(gridTwo) == 3;
	}

	static int countPaths(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[][] p = new int[m][n];
		int c = 0;

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				// undiscovered vertex.
				if (p[i][j] == 0)
					c = (c + visitIncreasingPaths(grid, p, i, j)) % MOD;

		return c;
	}

	private static int visitIncreasingPaths(int[][] grid, int[][] p, int i, int j) {
		// block just discovered.
		p[i][j] = 1;
		int paths = 0;
		// adjacency list.
		for (int[] m : MOVES) {
			final int r = i + m[0];
			final int c = j + m[1];
			if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[i][j] < grid[r][c]) {
				if (p[r][c] == 0)
					paths = (paths + visitIncreasingPaths(grid, p, r, c)) % MOD;
				p[i][j] = (p[i][j] + p[r][c]) % MOD;
			}
		}
		return (paths + p[i][j]) % MOD;
	}
}
