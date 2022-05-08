package com.coding.challenge.dfs;

class ClosedIslands {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	ClosedIslands() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 1, 0 },
				{ 1, 0, 1, 0, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 0 } };
		int islands = closedIsland(grid1);
		assert islands == 2;

		final int[][] grid2 = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };
		islands = closedIsland(grid2);
		assert islands == 1;

		final int[][] grid3 = new int[][] { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
		islands = closedIsland(grid3);
		assert islands == 2;

		final int[][] grid4 = new int[][] { { 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 }, { 0, 1, 1, 0, 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 },
				{ 0, 1, 0, 1, 0, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 1, 0 } };
		islands = closedIsland(grid4);
		assert islands == 5;

		final int[][] grid5 = { { 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 }, { 0, 1, 1, 0, 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 },
				{ 0, 1, 0, 1, 0, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 1, 0 } };
		islands = closedIsland(grid5);
		assert islands == 5;

		final int[][] grid6 = { { 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 0, 0, 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 0 }, { 1, 1, 1, 1, 1, 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 1, 1, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0, 0, 1, 1, 0 }, { 1, 1, 0, 0, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 1, 1, 1, 0 }, { 1, 1, 0, 1, 0, 1, 0, 0, 1, 0 } };
		islands = closedIsland(grid6);
		assert islands == 4;
		System.out.println(String.format("Number of closed islands: %d", islands));
	}

	static int closedIsland(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final boolean[][] d = new boolean[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				d[i][j] = false;
		int k = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 && !d[i][j]) {
					if (closedIslandVisit(grid, d, i, j))
						k = k + 1;
				}
			}
		}
		return k;
	}

	private static boolean closedIslandVisit(int[][] grid, boolean[][] d, int i, int j) {
		d[i][j] = true;
		boolean result = i != 0 && i != d.length - 1 && j != 0 && j != grid[0].length - 1;
		for (int[] m : MOVES) {
			final int r = i + m[0];
			final int c = j + m[1];
			if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 0 && !d[r][c])
				result = result & closedIslandVisit(grid, d, r, c);
		}
		return result;
	}
}
