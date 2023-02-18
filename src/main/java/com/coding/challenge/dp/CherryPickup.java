package com.coding.challenge.dp;

class CherryPickup {
	CherryPickup() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } };
		assert cherryPickup(gridOne) == 5;

		final int[][] gridTwo = { { 1, 1, -1 }, { 1, -1, 1 }, { -1, 1, 1 } };
		assert cherryPickup(gridTwo) == 0;

		final int[][] gridThree = { { 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1, 1 } };
		assert cherryPickup(gridThree) == 15;
	}

	static int cherryPickup(int[][] grid) {
		final int n = grid.length;
		final int[][] matrix = new int[n + 1][n + 1];
		for (int i = 2; i <= n; i++) {
			matrix[0][i] = -1;
			matrix[i][0] = -1;
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				matrix[i + 1][j + 1] = grid[i][j];

		final int levels = 2 * n - 1;
		final int[][][] c = new int[levels][n][n];
		// trivial case of the recursion.
		c[0][0][0] = matrix[1][1];

		for (int l = 1; l < levels; l++) {
			for (int i = Math.max(0, l - n + 1), j = Math.min(n - 1, l); j >= Math.max(0, l - n + 1); i++, j--) {
				// now consider each combination of blocks.
				for (int p = i, q = j; p >= Math.max(0, l - n + 1); p--, q++) {
					c[l][j][q] = -1;
					// checking for illegal paths
					if (matrix[i + 1][j + 1] != -1 && matrix[p + 1][q + 1] != -1) {
						if (matrix[i][j + 1] != -1) {
							if (matrix[p][q + 1] != -1)
								c[l][j][q] = Math.max(c[l][j][q], c[l - 1][j][q]);
							if (matrix[p + 1][q] != -1 && j < q)
								c[l][j][q] = Math.max(c[l][j][q], c[l - 1][j][q - 1]);
						}

						if (matrix[i + 1][j] != -1) {
							if (matrix[p][q + 1] != -1)
								c[l][j][q] = Math.max(c[l][j][q], c[l - 1][j - 1][q]);
							if (matrix[p + 1][q] != -1)
								c[l][j][q] = Math.max(c[l][j][q], c[l - 1][j - 1][q - 1]);
						}

						if (c[l][j][q] != -1) {
							if (j == q)
								c[l][j][q] = c[l][j][q] + matrix[i + 1][j + 1];
							else
								c[l][j][q] = c[l][j][q] + matrix[i + 1][j + 1] + matrix[p + 1][q + 1];
						}
					}
				}
			}
		}

		return Math.max(c[levels - 1][n - 1][n - 1], 0);
	}
}
