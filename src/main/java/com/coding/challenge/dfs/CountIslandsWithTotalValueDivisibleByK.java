package com.coding.challenge.dfs;

class CountIslandsWithTotalValueDivisibleByK {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	CountIslandsWithTotalValueDivisibleByK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 0, 2, 1, 0, 0 }, { 0, 5, 0, 0, 5 }, { 0, 0, 1, 0, 0 }, { 0, 1, 4, 7, 0 },
				{ 0, 2, 0, 0, 8 } };
		assert countIslands(grid1, 5) == 2;

		final int[][] grid2 = { { 3, 0, 3, 0 }, { 0, 3, 0, 3 }, { 3, 0, 3, 0 } };
		assert countIslands(grid2, 3) == 6;
	}

	static int countIslands(int[][] grid, int k) {
		final int m = grid.length;
		final int n = grid[0].length;
		final boolean[][] d = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0)
					d[i][j] = true;
			}
		}

		int c = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!d[i][j]) {
					final long sum = dfs(i, j, d, grid, m, n);
					if (sum % k == 0)
						c = c + 1;
				}
			}
		}
		return c;
	}

	private static long dfs(int i, int j, boolean[][] d, int[][] grid, int m, int n) {
		d[i][j] = true;
		long s = grid[i][j];
		for (int[] mv : MOVES) {
			final int r = i + mv[0];
			final int c = j + mv[1];
			if (r >= 0 && r < m && c >= 0 && c < n && !d[r][c])
				s = s + dfs(r, c, d, grid, m, n);
		}
		return s;
	}
}
