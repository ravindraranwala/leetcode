package com.coding.challenge.matrix;

import java.util.Arrays;

class RotateImage {
	RotateImage() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(m1);
		final int[][] e1 = { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		assert Arrays.deepEquals(e1, m1);

		final int[][] m2 = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		rotate(m2);
		final int[][] e2 = { { 15, 13, 2, 5 }, { 14, 3, 4, 1 }, { 12, 6, 8, 9 }, { 16, 7, 10, 11 } };
		assert Arrays.deepEquals(e2, m2);
	}

	static void rotate(int[][] matrix) {
		final int n = matrix.length;
		for (int d = n, r = 0, c = 0; d > 1; d = d - 2, r++, c++) {
			final int i = r + d - 1;
			final int j = c + d - 1;
			// top row elements except the right most one.
			for (int k = c; k < j; k++) {
				// cyclic move (4 moves) until the circle wraps around.
				final int offset = k - c;
				final int second = matrix[r + offset][j];
				matrix[r + offset][j] = matrix[r][k];

				final int third = matrix[i][j - offset];
				matrix[i][j - offset] = second;

				matrix[r][k] = matrix[i - offset][c];
				matrix[i - offset][c] = third;
			}
		}
	}
}
