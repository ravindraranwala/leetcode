package com.coding.challenge.dp;

class MinimumFallingPathSum {
	MinimumFallingPathSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] matrixOne = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		assert minFallingPathSum(matrixOne) == 13;

		final int[][] matrixTwo = { { -19, 57 }, { -40, -5 } };
		assert minFallingPathSum(matrixTwo) == -59;
	}

	static int minFallingPathSum(int[][] matrix) {
		final int n = matrix.length;
		final int[][] f = new int[n + 1][n + 2];

		for (int i = 0; i < n; i++) {
			f[i][0] = Integer.MAX_VALUE;
			f[i][n + 1] = Integer.MAX_VALUE;
		}

		// recursive step.
		for (int i = n - 1; i >= 0; i--)
			for (int j = 1; j <= n; j++)
				f[i][j] = Math.min(Math.min(f[i + 1][j - 1], f[i + 1][j]), f[i + 1][j + 1]) + matrix[i][j - 1];

		// constructing an optimal solution.
		int minSum = Integer.MAX_VALUE;
		for (int j = 1; j <= n; j++)
			minSum = Math.min(minSum, f[0][j]);

		return minSum;
	}
}
