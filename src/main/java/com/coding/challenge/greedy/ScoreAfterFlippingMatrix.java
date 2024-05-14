package com.coding.challenge.greedy;

class ScoreAfterFlippingMatrix {
	ScoreAfterFlippingMatrix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } };
		assert matrixScore(grid1) == 39;

		final int[][] grid2 = { { 0 } };
		assert matrixScore(grid2) == 1;
	}

	static int matrixScore(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;

		// toggle the values in each row if the most significant bit is 0.
		for (int i = 0; i < m; i++) {
			if (grid[i][0] == 0)
				for (int j = 0; j < n; j++)
					// flip the bit
					grid[i][j] = (grid[i][j] + 1) % 2;
		}

		int score = 0;
		// for each column, if # of zeros > # of ones, then toggle it's values.
		for (int j = n - 1, colVal = 1; j >= 0; j--) {
			int zeros = 0;
			for (int i = 0; i < m; i++)
				if (grid[i][j] == 0)
					zeros = zeros + 1;

			score = score + Math.max(zeros, m - zeros) * colVal;
			colVal = colVal * 2;
		}

		return score;
	}
}
