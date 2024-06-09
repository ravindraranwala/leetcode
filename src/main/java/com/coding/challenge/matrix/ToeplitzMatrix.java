package com.coding.challenge.matrix;

class ToeplitzMatrix {
	ToeplitzMatrix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] matrix1 = { { 1, 2, 3, 4 }, { 5, 1, 2, 3 }, { 9, 5, 1, 2 } };
		assert isToeplitzMatrix(matrix1);

		final int[][] matrix2 = { { 1, 2 }, { 2, 2 } };
		assert !isToeplitzMatrix(matrix2);

		final int[][] matrix3 = { { 11, 74, 0, 93 }, { 40, 11, 74, 7 } };
		assert !isToeplitzMatrix(matrix3);
	}

	static boolean isToeplitzMatrix(int[][] matrix) {
		final int m = matrix.length;
		final int n = matrix[0].length;
		for (int r = 1; r < m; r++)
			for (int c = 1; c < n; c++)
				if (matrix[r - 1][c - 1] != matrix[r][c])
					return false;

		return true;
	}
}
