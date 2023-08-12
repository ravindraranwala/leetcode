package com.coding.challenge.dfs;

class CountSubIslands {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	CountSubIslands() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 },
				{ 1, 1, 0, 1, 1 } };
		final int[][] gridTwo = { { 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0 },
				{ 0, 1, 0, 1, 0 } };
		assert countSubIslands(gridOne, gridTwo) == 3;

		final int[][] gridThree = { { 1, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 },
				{ 1, 0, 1, 0, 1 } };
		final int[][] gridFour = { { 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0 },
				{ 1, 0, 0, 0, 1 } };
		assert countSubIslands(gridThree, gridFour) == 2;
	}

	static int countSubIslands(int[][] grid1, int[][] grid2) {
		final int m = grid2.length;
		final int n = grid2[0].length;
		int c = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (grid2[i][j] == 1 && visitIsland(grid1, grid2, i, j, m, n))
					c = c + 1;

		return c;
	}

	private static boolean visitIsland(int[][] grid1, int[][] grid2, int i, int j, int m, int n) {
		grid2[i][j] = 0;
		boolean subIsland = grid1[i][j] == 1;
		for (int[] move : MOVES) {
			final int k = i + move[0];
			final int l = j + move[1];
			if (k >= 0 && k < m && l >= 0 && l < n && grid2[k][l] == 1)
				// do NOT use the short circuit && operator here.
				subIsland = subIsland & visitIsland(grid1, grid2, k, l, m, n);
		}
		return subIsland;
	}
}
