package com.coding.challenge.dfs;

class IslandMaxArea {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	IslandMaxArea() {
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		int maxArea = maxAreaOfIsland(gridOne);
		assert maxArea == 6;

		final int[][] gridTwo = { { 0, 0, 0, 0, 0, 0, 0, 0 } };
		maxArea = maxAreaOfIsland(gridTwo);
		assert maxArea == 0;
	}

	static int maxAreaOfIsland(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final boolean[][] d = new boolean[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				d[i][j] = false;

		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && !d[i][j]) {
					final int area = visitIsland(grid, d, i, j);
					maxArea = Math.max(maxArea, area);
				}
			}
		}

		return maxArea;
	}

	static int visitIsland(int[][] g, boolean[][] d, int i, int j) {
		d[i][j] = true;
		// base case of our recursion, when we encounter with a water block
		if (g[i][j] == 0)
			return 0;
		int area = 1;
		for (int[] m : MOVES) {
			final int r = i + m[0];
			final int c = j + m[1];
			if (r >= 0 && r < g.length && c >= 0 && c < g[0].length && !d[r][c])
				area = area + visitIsland(g, d, r, c);
		}
		return area;
	}
}
