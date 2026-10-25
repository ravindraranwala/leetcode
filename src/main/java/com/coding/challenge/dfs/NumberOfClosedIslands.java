package com.coding.challenge.dfs;

class NumberOfClosedIslands {
	private static int LAND = 0;
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	NumberOfClosedIslands() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 1, 1, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };
		assert closedIsland(grid1) == 2;

		final int[][] grid2 = { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
		assert closedIsland(grid2) == 1;

		final int[][] grid3 = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
		assert closedIsland(grid3) == 2;
	}

	static int closedIsland(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final boolean[][] d = new boolean[m][n];

		// handle perimeter cells first.
		// first row
		for (int j = 0; j < n; j++) {
			if (grid[0][j] == LAND && !d[0][j])
				dfs(0, j, d, grid, m, n);
		}

		// last row
		for (int j = 0; j < n; j++) {
			if (grid[m - 1][j] == LAND && !d[m - 1][j])
				dfs(m - 1, j, d, grid, m, n);
		}

		// first column
		for (int i = 0; i < m; i++) {
			if (grid[i][0] == LAND && !d[i][0])
				dfs(i, 0, d, grid, m, n);
		}

		// last column
		for (int i = 0; i < m; i++) {
			if (grid[i][n - 1] == LAND && !d[i][n - 1])
				dfs(i, n - 1, d, grid, m, n);
		}

		int c = 0;
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (grid[i][j] == LAND && !d[i][j]) {
					dfs(i, j, d, grid, m, n);
					c = c + 1;
				}
			}
		}
		return c;
	}

	private static void dfs(int i, int j, boolean[][] d, int[][] grid, int m, int n) {
		d[i][j] = true;
		for (int[] mv : MOVES) {
			final int r = i + mv[0];
			final int c = j + mv[1];
			if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == LAND && !d[r][c])
				dfs(r, c, d, grid, m, n);
		}
	}
}
