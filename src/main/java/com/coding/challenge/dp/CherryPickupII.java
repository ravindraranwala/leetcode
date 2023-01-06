package com.coding.challenge.dp;

class CherryPickupII {
	CherryPickupII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } };
		assert cherryPickup(gridOne) == 24;

		final int[][] gridTwo = { { 1, 0, 0, 0, 0, 0, 1 }, { 2, 0, 0, 0, 0, 3, 0 }, { 2, 0, 9, 0, 0, 0, 0 },
				{ 0, 3, 0, 5, 4, 0, 0 }, { 1, 0, 2, 3, 0, 0, 6 } };
		assert cherryPickup(gridTwo) == 28;

		final int[][] gridThree = { { 8, 8, 10, 9, 1, 7 }, { 8, 8, 1, 8, 4, 7 }, { 8, 6, 10, 3, 7, 7 },
				{ 3, 0, 9, 3, 2, 7 }, { 6, 8, 9, 4, 2, 5 }, { 1, 1, 5, 8, 8, 1 }, { 5, 6, 5, 2, 9, 9 },
				{ 4, 4, 6, 2, 5, 4 }, { 4, 4, 5, 3, 1, 6 }, { 9, 2, 2, 1, 9, 3 } };
		assert cherryPickup(gridThree) == 146;

		final int[][] gridFour = { { 14, 0, 2, 8, 6, 10, 12, 1, 5, 11, 18, 17, 16, 15, 8, 3 },
				{ 3, 8, 16, 14, 10, 0, 4, 7, 14, 19, 20, 11, 6, 14, 20, 0 },
				{ 7, 18, 6, 19, 1, 6, 0, 12, 12, 10, 17, 4, 9, 3, 19, 18 },
				{ 16, 3, 12, 1, 7, 5, 8, 19, 20, 13, 1, 3, 14, 13, 4, 2 },
				{ 16, 13, 4, 20, 1, 11, 1, 9, 20, 1, 5, 8, 12, 20, 13, 18 },
				{ 17, 10, 6, 9, 1, 3, 16, 0, 12, 17, 6, 14, 5, 1, 13, 0 },
				{ 0, 17, 17, 16, 4, 2, 5, 10, 19, 5, 8, 8, 13, 6, 4, 17 },
				{ 2, 1, 17, 18, 6, 9, 19, 12, 12, 1, 10, 11, 10, 18, 7, 8 },
				{ 6, 0, 16, 19, 10, 5, 17, 20, 6, 7, 20, 18, 17, 1, 15, 16 },
				{ 9, 10, 14, 18, 11, 2, 7, 1, 16, 5, 4, 2, 10, 6, 14, 3 },
				{ 20, 9, 8, 2, 20, 2, 13, 20, 12, 14, 19, 7, 9, 2, 19, 19 },
				{ 12, 2, 14, 3, 7, 14, 12, 1, 9, 8, 20, 5, 8, 10, 16, 8 },
				{ 6, 16, 5, 18, 16, 7, 6, 20, 12, 4, 17, 7, 2, 16, 4, 4 },
				{ 2, 7, 8, 2, 7, 5, 7, 7, 2, 19, 7, 17, 11, 0, 14, 11 },
				{ 9, 0, 14, 18, 2, 2, 3, 19, 5, 19, 3, 10, 3, 7, 16, 9 },
				{ 19, 18, 16, 14, 15, 18, 20, 20, 7, 0, 16, 0, 3, 16, 10, 4 },
				{ 6, 2, 7, 10, 1, 8, 13, 10, 4, 20, 11, 19, 19, 3, 16, 4 },
				{ 15, 14, 12, 14, 16, 8, 15, 3, 10, 2, 4, 4, 4, 8, 20, 0 },
				{ 18, 18, 16, 2, 13, 4, 14, 13, 17, 19, 0, 4, 2, 12, 8, 5 } };
		assert cherryPickup(gridFour) == 581;
	}

	// Let's write a bottom-up dynamic programming algorithm to solve this.
	static int cherryPickup(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[][][] c = new int[m + 1][n + 2][n + 2];
		final int span = Math.min(n, m);
		final int[][] gridCopy = new int[m][n + 2];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				gridCopy[i][j + 1] = grid[i][j];

		for (int l = m - 1; l >= 0; l--) {
			final int d = Math.min(l + 1, span);
			for (int i = 1; i <= d; i++) {
				for (int j = n; j > n - d; j--) {
					for (int mv1 = -1; mv1 <= 1; mv1++) {
						final int p1 = i + mv1;
						for (int mv2 = -1; mv2 <= 1; mv2++) {
							final int p2 = j + mv2;
							c[l][i][j] = Math.max(c[l][i][j], c[l + 1][p1][p2]);
						}
					}
					if (i == j)
						c[l][i][j] = c[l][i][j] + gridCopy[l][i];
					else
						c[l][i][j] = c[l][i][j] + gridCopy[l][i] + gridCopy[l][j];
				}
			}
		}
		return c[0][1][n];
	}
}
