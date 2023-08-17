package com.coding.challenge.matrix;

class MaximumHourglassSum {
	MaximumHourglassSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 6, 2, 1, 3 }, { 4, 2, 1, 5 }, { 9, 2, 8, 7 }, { 4, 1, 2, 9 } };
		assert maxSum(gridOne) == 30;

		final int[][] gridTwo = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		assert maxSum(gridTwo) == 35;
	}

	static int maxSum(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;

		int s = 0;
		for (int i = 2; i < m; i++) {
			for (int j = 2; j < n; j++) {
				final int hg = grid[i - 2][j - 2] + grid[i - 2][j - 1] + grid[i - 2][j] + grid[i - 1][j - 1]
						+ grid[i][j - 2] + grid[i][j - 1] + grid[i][j];
				s = Math.max(s, hg);
			}
		}
		return s;
	}
}
