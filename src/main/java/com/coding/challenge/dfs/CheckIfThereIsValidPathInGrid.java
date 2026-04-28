package com.coding.challenge.dfs;

class CheckIfThereIsValidPathInGrid {
	private static final int[][][] ADJ_LIST = { { { -1, -1 }, { -1, -1 } }, { { 0, -1 }, { 0, 1 } },
			{ { -1, 0 }, { 1, 0 } }, { { 0, -1 }, { 1, 0 } }, { { 0, 1 }, { 1, 0 } }, { { 0, -1 }, { -1, 0 } },
			{ { -1, 0 }, { 0, 1 } } };

	CheckIfThereIsValidPathInGrid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 2, 4, 3 }, { 6, 5, 2 } };
		assert hasValidPath(grid1);

		final int[][] grid2 = { { 1, 2, 1 }, { 1, 2, 1 } };
		assert !hasValidPath(grid2);

		final int[][] grid3 = { { 1, 1, 2 } };
		assert !hasValidPath(grid3);

		final int[][] grid4 = { { 4, 1 }, { 6, 1 } };
		assert hasValidPath(grid4);

		final int[][] grid5 = { { 4, 3, 1 }, { 5, 6, 2 } };
		assert !hasValidPath(grid5);
	}

	static boolean hasValidPath(int[][] grid) {
		return traverse(grid, 0, 0, new boolean[grid.length][grid[0].length]);
	}

	private static boolean traverse(int[][] grid, int i, int j, boolean[][] d) {
		d[i][j] = true;
		final int m = grid.length;
		final int n = grid[0].length;
		if (i == m - 1 && j == n - 1)
			return true;

		for (int[] move : ADJ_LIST[grid[i][j]]) {
			final int r = i + move[0];
			final int c = j + move[1];
			if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && !d[r][c]) {
				for (int[] direction : ADJ_LIST[grid[r][c]]) {
					final int p = r + direction[0];
					final int q = c + direction[1];
					if (i == p && j == q && traverse(grid, r, c, d))
						return true;
				}
			}
		}
		return false;
	}
}
