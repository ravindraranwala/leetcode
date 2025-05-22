package com.coding.challenge.matrix;

import java.util.Arrays;

class SetMatrixZeroes {
	SetMatrixZeroes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] matrix1 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		setZeroes(matrix1);
		final int[][] expected1 = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
		assert Arrays.deepEquals(expected1, matrix1);

		final int[][] matrix2 = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes(matrix2);
		final int[][] expected2 = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
		assert Arrays.deepEquals(expected2, matrix2);
	}

	static void setZeroes(int[][] matrix) {
		final int m = matrix.length;
		final int n = matrix[0].length;
		boolean setFirstRow = false;
		for (int j = 0; j < n; j++)
			if (matrix[0][j] == 0)
				setFirstRow = true;

		/*
		 * go through each cell, if there's a zero, then update the corresponding entry
		 * in the first row by setting it to zero.
		 */
		for (int i = 1; i < m; i++)
			for (int j = 0; j < n; j++)
				if (matrix[i][j] == 0)
					matrix[0][j] = 0;

		// starting from row 1, set the row to zero if required.
		for (int i = 1; i < m; i++) {
			boolean setRow = false;
			for (int j = 0; j < n; j++)
				if (matrix[i][j] == 0)
					setRow = true;

			if (setRow)
				for (int j = 0; j < n; j++)
					matrix[i][j] = 0;
		}
		// now process the columns and set it to zero if required.
		// just bring the zero columns down starting from the first row.
		for (int i = 1; i < m; i++)
			for (int j = 0; j < n; j++)
				if (matrix[0][j] == 0)
					matrix[i][j] = 0;

		// now process the first row.
		if (setFirstRow)
			for (int j = 0; j < n; j++)
				matrix[0][j] = 0;
	}
}
