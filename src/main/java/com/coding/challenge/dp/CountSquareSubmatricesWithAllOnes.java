package com.coding.challenge.dp;

class CountSquareSubmatricesWithAllOnes {
	CountSquareSubmatricesWithAllOnes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] matrix1 = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		assert countSquares(matrix1) == 15;

		final int[][] matrix2 = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		assert countSquares(matrix2) == 7;
	}

	static int countSquares(int[][] matrix) {
		// init.
		final int m = matrix.length;
		final int n = matrix[0].length;

		final int[][] colData = new int[m][n];

		int ans = 0;
		final int[][] t = new int[m][n];
		// base case of the recursion.
		for (int i = 0; i < m; i++) {
			t[i][0] = matrix[i][0];
			ans = ans + t[i][0];
		}

		for (int j = 1; j < n; j++) {
			t[0][j] = matrix[0][j];
			ans = ans + t[0][j];
			colData[0][j] = matrix[0][j];
		}

		// row major order.
		for (int i = 1; i < m; i++) {
			for (int j = 1, ci = matrix[i][0]; j < n; j++) {
				if (matrix[i][j] == 0) {
					ci = 0;
					colData[i][j] = 0;
				} else {
					ci = ci + 1;
					colData[i][j] = colData[i - 1][j] + 1;
				}

				t[i][j] = Math.min(t[i - 1][j - 1] + 1, Math.min(ci, colData[i][j]));
				ans = ans + t[i][j];
			}
		}

		return ans;
	}
}
