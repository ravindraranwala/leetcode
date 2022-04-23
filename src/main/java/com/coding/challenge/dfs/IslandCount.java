package com.coding.challenge.dfs;

class IslandCount {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	IslandCount() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
		int cnt = numIslands(grid);
		assert cnt == 1;
		final char[][] grid2 = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
		cnt = numIslands(grid2);
		assert cnt == 3;
	}

	static int numIslands(char[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final boolean[][] d = new boolean[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				d[i][j] = false;

		int k = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && !d[i][j]) {
					k = k + 1;
					numIslandsVisit(grid, d, i, j);
				}
			}
		}
		return k;
	}

	private static void numIslandsVisit(char[][] grid, boolean[][] d, int i, int j) {
		d[i][j] = true;
		for (int[] m : MOVES) {
			final int r = i + m[0];
			final int c = j + m[1];
			if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1' && !d[r][c])
				numIslandsVisit(grid, d, r, c);
		}
	}
}
