package com.coding.challenge.dfs;

class CheckValidPathInGrid {
	private static int[][] CONNECTION_ONE = { { 0, 1 }, { 1, 0 }, { 1, 0 }, { 0, 1 }, { -1, 0 }, { -1, 0 } };
	private static int[][] CONNECTION_TWO = { { 0, -1 }, { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	CheckValidPathInGrid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 2, 4, 3 }, { 6, 5, 2 } };
		assert hasValidPath(gridOne);

		final int[][] gridTwo = { { 1, 2, 1 }, { 1, 2, 1 } };
		assert !hasValidPath(gridTwo);

		final int[][] gridThree = { { 1, 1, 2 } };
		assert !hasValidPath(gridThree);

		final int[][] gridFour = { { 4, 1 }, { 6, 1 } };
		assert hasValidPath(gridFour);

		final int[][] gridFive = { { 1 } };
		assert hasValidPath(gridFive);

		final int[][] gridSix = { { 2, 6 } };
		assert !hasValidPath(gridSix);

		final int[][] gridSeven = { { 2, 3, 6, 5, 6, 1, 6, 6 }, { 5, 6, 3, 5, 1, 5, 4, 2 }, { 5, 3, 6, 1, 4, 1, 6, 3 },
				{ 2, 2, 4, 2, 5, 6, 2, 3 }, { 2, 2, 2, 4, 6, 2, 4, 5 }, { 1, 6, 5, 6, 4, 2, 4, 6 },
				{ 2, 2, 6, 5, 1, 3, 6, 6 }, { 6, 5, 2, 3, 2, 3, 2, 6 }, { 2, 2, 3, 3, 3, 3, 6, 1 },
				{ 5, 3, 3, 2, 2, 2, 1, 1 } };
		assert !hasValidPath(gridSeven);
	}

	static boolean hasValidPath(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		if (m == 1 && n == 1)
			return true;
		
		final int street = grid[0][0];
		final int[] connOne = CONNECTION_ONE[street - 1];
		final int[] connTwo = CONNECTION_TWO[street - 1];
		final boolean[][] d = new boolean[m][n];
		d[0][0] = true;
		boolean ans = false;
		if (connOne[0] >= 0 && connOne[1] >= 0 && connOne[0] < m && connOne[1] < n)
			ans = ans || visitGrid(grid, d, 0, 0, connOne[0], connOne[1], m, n);
		if (connTwo[0] >= 0 && connTwo[1] >= 0 && connTwo[0] < m && connTwo[1] < n)
			ans = ans || visitGrid(grid, d, 0, 0, connTwo[0], connTwo[1], m, n);

		return ans;
	}

	static boolean visitGrid(int[][] grid, boolean[][] d, int sx, int sy, int tx, int ty, int m, int n) {
		d[tx][ty] = true;
		final int street = grid[tx][ty];
		final int[] connOne = CONNECTION_ONE[street - 1];
		final int[] connTwo = CONNECTION_TWO[street - 1];
		if (tx == m - 1 && ty == n - 1 && sx == tx + connOne[0] && sy == ty + connOne[1])
			return true;
		if (tx == m - 1 && ty == n - 1 && sx == tx + connTwo[0] && sy == ty + connTwo[1])
			return true;
		if (sx == tx + connOne[0] && sy == ty + connOne[1] && tx + connTwo[0] < m && tx + connTwo[0] >= 0
				&& ty + connTwo[1] < n && ty + connTwo[1] >= 0 && !d[tx + connTwo[0]][ty + connTwo[1]])
			return visitGrid(grid, d, tx, ty, tx + connTwo[0], ty + connTwo[1], m, n);
		if (sx == tx + connTwo[0] && sy == ty + connTwo[1] && tx + connOne[0] < m && tx + connOne[0] >= 0
				&& ty + connOne[1] < n && ty + connOne[1] >= 0 && !d[tx + connOne[0]][ty + connOne[1]])
			return visitGrid(grid, d, tx, ty, tx + connOne[0], ty + connOne[1], m, n);

		return false;
	}
}
