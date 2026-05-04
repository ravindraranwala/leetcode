package com.coding.challenge.matrix;

import java.util.Arrays;

class RotateImage {
	RotateImage() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix1);
		final int[][] exp1 = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		assert Arrays.deepEquals(exp1, matrix1);

		final int[][] matrix2 = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		rotate(matrix2);
		final int[][] exp2 = { { 15, 13, 2, 5 }, { 14, 3, 4, 1 }, { 12, 6, 8, 9 }, { 16, 7, 10, 11 } };
		assert Arrays.deepEquals(exp2, matrix2);
	}

	static void rotate(int[][] matrix) {
		final int n = matrix.length;
		final int l = n / 2;
		for (int i = 0; i < l; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				// perform the rotation.
				final int r1 = j;
				final int c1 = n - 1 - i;
				final int tmp1 = matrix[r1][c1];
				matrix[r1][c1] = matrix[i][j];

				final int r2 = c1;
				final int c2 = n - 1 - r1;
				final int tmp2 = matrix[r2][c2];
				matrix[r2][c2] = tmp1;

				final int r3 = c2;
				final int c3 = n - 1 - r2;
				final int tmp3 = matrix[r3][c3];
				matrix[r3][c3] = tmp2;

				matrix[i][j] = tmp3;
			}
		}
	}
}
