package com.coding.challenge.prefix.sum;

class SubmatricesSumToTarget {
	SubmatricesSumToTarget() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] m1 = { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } };
		assert numSubmatrixSumTarget(m1, 0) == 4;

		final int[][] m2 = { { 1, -1 }, { -1, 1 } };
		assert numSubmatrixSumTarget(m2, 0) == 5;

		final int[][] m3 = { { 904 } };
		assert numSubmatrixSumTarget(m3, 0) == 0;

		final int[][] m4 = { { 1, -1 }, { -1, 1 }, { 1, -1 }, { -1, 1 } };
		assert numSubmatrixSumTarget(m4, 0) == 18;
	}

	static int numSubmatrixSumTarget(int[][] matrix, int target) {
		final int m = matrix.length;
		final int n = matrix[0].length;
		final int[][] t = new int[m + 1][n + 1];
		// find the prefix-sum for each row.
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				t[i + 1][j + 1] = t[i + 1][j] + matrix[i][j];

		int c = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				t[i][j] = t[i - 1][j] + t[i][j];
				for (int k = 0; k < i; k++) {
					for (int l = 0; l < j; l++) {
						final int s = t[i][j] - t[k][j] - (t[i][l] - t[k][l]);
						if (s == target)
							c = c + 1;
					}
				}
			}
		}
		return c;
	}
}
