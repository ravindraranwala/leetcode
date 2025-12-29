package com.coding.challenge.two.pointer;

class CountNegativeNumbersInSortedMatrix {
	CountNegativeNumbersInSortedMatrix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
		assert countNegatives(grid1) == 8;

		final int[][] grid2 = { { 3, 2 }, { 1, 0 } };
		assert countNegatives(grid2) == 0;
	}

	static int countNegatives(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		int c = 0;
		for (int i = 0, j = n - 1; i < m; i++) {
			while (j >= 0 && grid[i][j] < 0)
				j = j - 1;
			
			c = c + n - 1 - j;
		}
		return c;
	}
}
