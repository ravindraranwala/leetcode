package com.coding.challenge.dp;

class SquareMatricesWithAllOnes {
	SquareMatricesWithAllOnes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] m1 = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		int cnt = countSquaresV2(m1);
		assert cnt == 15;

		final int[][] m2 = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		cnt = countSquaresV2(m2);
		assert cnt == 7;
	}

	static int countSquares(int[][] matrix) {
		final int m = matrix.length;
		final int n = matrix[0].length;
		final int[][] s = new int[m][n];
		int c = 0;
		for (int i = 0; i < m; i++) {
			s[i][0] = matrix[i][0];
			c = c + s[i][0];
		}
		for (int j = 1; j < n; j++) {
			s[0][j] = matrix[0][j];
			c = c + s[0][j];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0)
					s[i][j] = 0;
				else
					s[i][j] = Math.min(s[i - 1][j], Math.min(s[i - 1][j - 1], s[i][j - 1])) + 1;
				c = c + s[i][j];
			}
		}
		return c;
	}

	static int countSquaresV2(int[][] matrix) {
		final int m = matrix.length;
		final int n = matrix[0].length;
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				matrix[i][j] = matrix[i][j] == 0 ? 0
						: Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i][j - 1])) + 1;
		int c = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				c = c + matrix[i][j];
		return c;
	}
}
