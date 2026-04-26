package com.coding.challenge.dfs;

class DetectCyclesIn2DGrid {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	DetectCyclesIn2DGrid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[][] gridOne = { { 'a', 'a', 'a', 'a' }, { 'a', 'b', 'b', 'a' }, { 'a', 'b', 'b', 'a' },
				{ 'a', 'a', 'a', 'a' } };
		assert containsCycle(gridOne);

		final char[][] gridTwo = { { 'c', 'c', 'c', 'a' }, { 'c', 'd', 'c', 'c' }, { 'c', 'c', 'e', 'c' },
				{ 'f', 'c', 'c', 'c' } };
		assert containsCycle(gridTwo);

		final char[][] gridThree = { { 'a', 'b', 'b' }, { 'b', 'z', 'b' }, { 'b', 'b', 'a' } };
		assert !containsCycle(gridThree);
	}

	static boolean containsCycle(char[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final boolean[][] d = new boolean[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (!d[i][j] && dfsVisit(grid, grid[i][j], d, i, j, -1, -1))
					return true; // cycle detected.

		return false;
	}

	private static boolean dfsVisit(char[][] grid, char letter, boolean[][] d, int i, int j, int prevRow, int prevCol) {
		d[i][j] = true;
		for (int[] m : MOVES) {
			final int r = i + m[0];
			final int c = j + m[1];
			if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == letter
					&& (r != prevRow || c != prevCol)) {
				if (d[r][c])
					return true; // cycle detected.
				else if (dfsVisit(grid, letter, d, r, c, i, j))
					return true;
			}
		}
		return false;
	}
}
