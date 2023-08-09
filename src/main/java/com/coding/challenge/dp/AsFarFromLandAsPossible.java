package com.coding.challenge.dp;

class AsFarFromLandAsPossible {
	AsFarFromLandAsPossible() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		assert maxDistance(gridOne) == 2;

		final int[][] gridTwo = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		assert maxDistance(gridTwo) == 4;
	}

	static int maxDistance(int[][] grid) {
		final int n = grid.length;
		final int[][] md1 = new int[n][n];
		md1[0][0] = grid[0][0] == 1 ? 0 : 400;

		// starting from top left corner.
		for (int i = 1; i < n; i++)
			md1[i][0] = grid[i][0] == 1 ? 0 : md1[i - 1][0] + 1;
		
		for (int j = 1; j < n; j++)
			md1[0][j] = grid[0][j] == 1 ? 0 : md1[0][j - 1] + 1;

		for (int i = 1; i < n; i++)
			for (int j = 1; j < n; j++)
				md1[i][j] = grid[i][j] == 1 ? 0 : Math.min(md1[i - 1][j], md1[i][j - 1]) + 1;

		// starting from top right corner.
		final int[][] md2 = new int[n][n];
		md2[0][n - 1] = grid[0][n - 1] == 1 ? 0 : 400;
		for (int i = 1; i < n; i++)
			md2[i][n - 1] = grid[i][n - 1] == 1 ? 0 : md2[i - 1][n - 1] + 1;
		
		for (int j = n - 2; j >= 0; j--)
			md2[0][j] = grid[0][j] == 1 ? 0 : md2[0][j + 1] + 1;

		for (int i = 1; i < n; i++)
			for (int j = n - 2; j >= 0; j--)
				md2[i][j] = grid[i][j] == 1 ? 0 : Math.min(md2[i - 1][j], md2[i][j + 1]) + 1;

		// starting from bottom left corner.
		final int[][] md3 = new int[n][n];
		md3[n - 1][0] = grid[n - 1][0] == 1 ? 0 : 400;
		for (int i = n - 2; i >= 0; i--)
			md3[i][0] = grid[i][0] == 1 ? 0 : md3[i + 1][0] + 1;
		
		for (int j = 1; j < n; j++)
			md3[n - 1][j] = grid[n - 1][j] == 1 ? 0 : md3[n - 1][j - 1] + 1;
		
		for (int i = n - 2; i >= 0; i--)
			for (int j = 1; j < n; j++)
				md3[i][j] = grid[i][j] == 1 ? 0 : Math.min(md3[i][j - 1], md3[i + 1][j]) + 1;

		// starting from bottom right corner.
		final int[][] md4 = new int[n][n];
		md4[n - 1][n - 1] = grid[n - 1][n - 1] == 1 ? 0 : 400;
		for (int i = n - 2; i >= 0; i--)
			md4[i][n - 1] = grid[i][n - 1] == 1 ? 0 : md4[i + 1][n - 1] + 1;
		
		for (int j = n - 2; j >= 0; j--)
			md4[n - 1][j] = grid[n - 1][j] == 1 ? 0 : md4[n - 1][j + 1] + 1;
		
		for (int i = n - 2; i >= 0; i--)
			for (int j = n - 2; j >= 0; j--)
				md4[i][j] = grid[i][j] == 1 ? 0 : Math.min(md4[i][j + 1], md4[i + 1][j]) + 1;

		int d = -1;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				d = Math.max(d, Math.min(Math.min(md1[i][j], md2[i][j]), Math.min(md3[i][j], md4[i][j])));

		return d <= 200 && d > 0 ? d : -1;
	}
}
