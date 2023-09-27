package com.coding.challenge.dfs;

class NumberOfEnclaves {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	NumberOfEnclaves() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };
		assert numEnclaves(gridOne) == 3;

		final int[][] gridTwo = { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
		assert numEnclaves(gridTwo) == 0;
	}

	static int numEnclaves(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		int c = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (grid[i][j] == 1)
					c = c + Math.max(visitGrid(grid, i, j), 0);

		return c;
	}

	private static int visitGrid(int[][] grid, int i, int j) {
		// discover it first.
		grid[i][j] = 0;
		int s = 1;
		for (int[] move : MOVES) {
			final int r = i + move[0];
			final int c = j + move[1];
			if (r == -1 || c == -1 || r == grid.length || c >= grid[0].length)
				s = s - 250000;
			else if (grid[r][c] == 1)
				s = s + visitGrid(grid, r, c);
		}
		return s;
	}
}
