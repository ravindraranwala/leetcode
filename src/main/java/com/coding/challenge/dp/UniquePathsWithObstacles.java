package com.coding.challenge.dp;

class UniquePathsWithObstacles {
	UniquePathsWithObstacles() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		assert uniquePathsWithObstacles(gridOne) == 2;

		final int[][] gridTwo = { { 0, 1 }, { 0, 0 } };
		assert uniquePathsWithObstacles(gridTwo) == 1;
	}

	static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		final int m = obstacleGrid.length;
		final int n = obstacleGrid[0].length;
		// initializing to default value of 0.
		final int[][] p = new int[m][n];
		if (obstacleGrid[m - 1][n - 1] == 0)
			p[m - 1][n - 1] = 1;

		for (int i = m - 2; i >= 0; i--)
			if (obstacleGrid[i][n - 1] == 0)
				p[i][n - 1] = p[i + 1][n - 1];

		for (int j = n - 2; j >= 0; j--)
			if (obstacleGrid[m - 1][j] == 0)
				p[m - 1][j] = p[m - 1][j + 1];

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				if (obstacleGrid[i][j] == 0)
					p[i][j] = p[i][j + 1] + p[i + 1][j];
			}
		}

		return p[0][0];
	}
}
