package com.coding.challenge.dfs;

class MaximumNumberOfFishInGrid {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	MaximumNumberOfFishInGrid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 0, 2, 1, 0 }, { 4, 0, 0, 3 }, { 1, 0, 0, 4 }, { 0, 3, 2, 0 } };
		assert findMaxFish(grid1) == 7;

		final int[][] grid2 = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 1 } };
		assert findMaxFish(grid2) == 1;
	}

	static int findMaxFish(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final boolean[][] d = new boolean[m][n];

		int f = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (grid[i][j] > 0 && !d[i][j])
					f = Math.max(f, dfsVisit(grid, d, i, j));
		return f;
	}

	private static int dfsVisit(int[][] grid, boolean[][] d, int i, int j) {
		d[i][j] = true;
		int f = grid[i][j];
		for (int[] m : MOVES) {
			final int r = i + m[0];
			final int c = j + m[1];
			if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] > 0 && !d[r][c])
				f = f + dfsVisit(grid, d, r, c);
		}
		return f;
	}
}
