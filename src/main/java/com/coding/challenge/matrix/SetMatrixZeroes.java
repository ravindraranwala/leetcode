package com.coding.challenge.matrix;

import java.util.Arrays;

class SetMatrixZeroes {
	SetMatrixZeroes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] matrix1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		setZeroes(matrix1);
		final int[][] m1 = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		assert Arrays.deepEquals(matrix1, m1);

		final int[][] matrix2 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes(matrix2);
		final int[][] m2 = { { 0, 0, 0, 0 }, { 0, 4, 5, 0 }, { 0, 3, 1, 0 } };
		assert Arrays.deepEquals(matrix2, m2);
	}

	static void setZeroes(int[][] matrix) {
		final int m = matrix.length;
		final int n = matrix[0].length;
		int firstRowZeros = 0;
		for (int j = 0; j < n; j++)
			if (matrix[0][j] == 0)
				firstRowZeros = firstRowZeros + 1;

		int firstColZeros = 0;
		for (int i = 0; i < m; i++)
			if (matrix[i][0] == 0)
				firstColZeros = firstColZeros + 1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0)
				for (int j = 1; j < n; j++)
					matrix[i][j] = 0;
		}

		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0)
				for (int i = 1; i < m; i++)
					matrix[i][j] = 0;
		}

		if (firstRowZeros > 0)
			for (int j = 0; j < n; j++)
				matrix[0][j] = 0;

		if (firstColZeros > 0)
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;
	}
}
