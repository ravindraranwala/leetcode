package com.coding.challenge.backtracking;

class PathWithMaximumGold {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	PathWithMaximumGold() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
		assert getMaximumGold(grid1) == 24;

		final int[][] grid2 = { { 1, 0, 7 }, { 2, 0, 6 }, { 3, 4, 5 }, { 0, 3, 0 }, { 9, 0, 20 } };
		assert getMaximumGold(grid2) == 28;
	}

	static int getMaximumGold(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		int gold = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (grid[i][j] > 0)
					gold = Math.max(gold, backtrack(grid, i, j));

		return gold;
	}

	private static int backtrack(int[][] grid, int r, int c) {
		// choose.
		final int curr = grid[r][c];
		grid[r][c] = 0;
		int gold = 0;
		// explore
		for (int[] move : MOVES) {
			final int i = r + move[0];
			final int j = c + move[1];
			if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] > 0)
				gold = Math.max(gold, backtrack(grid, i, j));
		}
		// unchoose.
		grid[r][c] = curr;
		return gold + grid[r][c];
	}
}
