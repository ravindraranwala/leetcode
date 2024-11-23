package com.coding.challenge.matrix;

class CountUnguardedCellsInTheGrid {
	private static final char GUARD = 'g';
	private static final char WALL = 'w';
	private static final char MONITORED = 'm';

	CountUnguardedCellsInTheGrid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] guards1 = { { 0, 0 }, { 1, 1 }, { 2, 3 } };
		final int[][] walls1 = { { 0, 1 }, { 2, 2 }, { 1, 4 } };
		assert countUnguarded(4, 6, guards1, walls1) == 7;

		final int[][] guards2 = { { 1, 1 } };
		final int[][] walls2 = { { 0, 1 }, { 1, 0 }, { 2, 1 }, { 1, 2 } };
		assert countUnguarded(3, 3, guards2, walls2) == 4;
	}

	static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
		final char[][] grid = new char[m][n];
		for (int[] g : guards)
			grid[g[0]][g[1]] = GUARD;

		for (int[] w : walls)
			grid[w[0]][w[1]] = WALL;

		for (int[] guard : guards) {
			for (int c = guard[1] + 1; c < n && grid[guard[0]][c] != GUARD && grid[guard[0]][c] != WALL; c++)
				grid[guard[0]][c] = MONITORED;

			for (int c = guard[1] - 1; c >= 0 && grid[guard[0]][c] != GUARD && grid[guard[0]][c] != WALL; c--)
				grid[guard[0]][c] = MONITORED;

			for (int r = guard[0] + 1; r < m && grid[r][guard[1]] != GUARD && grid[r][guard[1]] != WALL; r++)
				grid[r][guard[1]] = MONITORED;

			for (int r = guard[0] - 1; r >= 0 && grid[r][guard[1]] != GUARD && grid[r][guard[1]] != WALL; r--)
				grid[r][guard[1]] = MONITORED;

		}

		int c = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (grid[i][j] == Character.MIN_VALUE)
					c = c + 1;

		return c;
	}
}
