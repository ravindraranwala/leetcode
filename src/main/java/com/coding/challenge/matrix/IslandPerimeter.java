package com.coding.challenge.matrix;

class IslandPerimeter {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	IslandPerimeter() {
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		assert islandPerimeter(grid1) == 16;

		final int[][] grid2 = { { 1 } };
		assert islandPerimeter(grid2) == 4;

		final int[][] grid3 = { { 1, 0 } };
		assert islandPerimeter(grid3) == 4;
	}

	static int islandPerimeter(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		int p = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					for (int[] s : MOVES) {
						final int r = i + s[0];
						final int c = j + s[1];
						if (r >= 0 && r < m && c >= 0 && c < n) {
							if (grid[r][c] == 0)
								p = p + 1;
						} else
							p = p + 1;
					}
				}
			}
		}
		return p;
	}
}
