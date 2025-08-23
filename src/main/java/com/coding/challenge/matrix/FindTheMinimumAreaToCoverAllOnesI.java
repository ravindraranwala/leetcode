package com.coding.challenge.matrix;

class FindTheMinimumAreaToCoverAllOnesI {
	FindTheMinimumAreaToCoverAllOnesI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 0, 1, 0 }, { 1, 0, 1 } };
		assert minimumArea(gridOne) == 6;

		final int[][] gridTwo = { { 1, 0 }, { 0, 0 } };
		assert minimumArea(gridTwo) == 1;

		final int[][] gridThree = { { 0, 0, 0 }, { 0, 0, 0 } };
		assert minimumArea(gridThree) == 0;
	}

	static int minimumArea(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		int minRow = m;
		int maxRow = -1;
		int minCol = n;
		int maxCol = -1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					minRow = Math.min(minRow, i);
					maxRow = Math.max(maxRow, i);
					minCol = Math.min(minCol, j);
					maxCol = Math.max(maxCol, j);
				}
			}
		}

		if (minRow == m && maxRow == -1 && minCol == n && maxCol == -1)
			return 0;

		// both inclusive.
		return (maxRow - minRow + 1) * (maxCol - minCol + 1);
	}
}
