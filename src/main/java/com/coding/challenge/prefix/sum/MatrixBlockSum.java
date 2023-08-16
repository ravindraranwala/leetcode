package com.coding.challenge.prefix.sum;

import java.util.Arrays;

class MatrixBlockSum {
	MatrixBlockSum() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] matOne = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		final int[][] expectedOne = { { 12, 21, 16 }, { 27, 45, 33 }, { 24, 39, 28 } };
		assert Arrays.deepEquals(expectedOne, matrixBlockSum(matOne, 1));

		final int[][] matTwo = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		final int[][] expectedTwo = { { 45, 45, 45 }, { 45, 45, 45 }, { 45, 45, 45 } };
		assert Arrays.deepEquals(expectedTwo, matrixBlockSum(matTwo, 2));

		final int[][] matThree = { { 76, 4, 73 }, { 21, 8, 56 }, { 4, 56, 61 }, { 70, 32, 38 }, { 31, 94, 67 } };
		final int[][] expectedThree = { { 109, 238, 141 }, { 169, 359, 258 }, { 191, 346, 251 }, { 287, 453, 348 },
				{ 227, 332, 231 } };
		assert Arrays.deepEquals(expectedThree, matrixBlockSum(matThree, 1));
	}

	static int[][] matrixBlockSum(int[][] mat, int k) {
		final int m = mat.length;
		final int n = mat[0].length;
		final int[][] preSum = new int[m + 1][n + 1];
		for (int c = 1; c <= n; c++) {
			for (int r = 1, s = 0; r <= m; r++) {
				s = s + mat[r - 1][c - 1];
				preSum[r][c] = preSum[r][c - 1] + s;
			}
		}

		final int[][] blockSum = new int[m][n];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				final int rs = Math.max(i - k, 1);
				final int re = Math.min(i + k, m);
				final int cs = Math.max(j - k, 1);
				final int ce = Math.min(j + k, n);
				blockSum[i - 1][j - 1] = preSum[re][ce] - preSum[rs - 1][ce] - preSum[re][cs - 1]
						+ preSum[rs - 1][cs - 1];
			}
		}
		return blockSum;
	}
}
