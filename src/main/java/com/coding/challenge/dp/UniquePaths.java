package com.coding.challenge.dp;

class UniquePaths {
	UniquePaths() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert uniquePaths(3, 7) == 28;

		assert uniquePaths(3, 2) == 3;
	}

	static int uniquePaths(int m, int n) {
		final int[][] p = new int[m][n];
		for (int i = 0; i < m; i++)
			p[i][n - 1] = 1;

		for (int j = 0; j < n - 1; j++)
			p[m - 1][j] = 1;

		for (int i = m - 2; i >= 0; i--) 
			for (int j = n - 2; j >= 0; j--)
				p[i][j] = p[i][j + 1] + p[i + 1][j];
		

		return p[0][0];
	}
}
