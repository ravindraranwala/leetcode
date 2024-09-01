package com.coding.challenge.matrix;

import java.util.Arrays;

class Convert1DArrayInto2DArray {
	Convert1DArrayInto2DArray() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] original1 = { 1, 2, 3, 4 };
		final int[][] matrix1 = { { 1, 2 }, { 3, 4 } };
		assert Arrays.deepEquals(construct2DArray(original1, 2, 2), matrix1);

		final int[] original2 = { 1, 2, 3 };
		final int[][] matrix2 = { { 1, 2, 3 } };
		assert Arrays.deepEquals(construct2DArray(original2, 1, 3), matrix2);

		final int[] original3 = { 1, 2 };
		assert Arrays.deepEquals(new int[0][0], construct2DArray(original3, 1, 1));
	}

	static int[][] construct2DArray(int[] original, int m, int n) {
		final int l = original.length;
		if (l != m * n)
			return new int[0][0];

		final int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0, k = i * n; j < n; j++)
				matrix[i][j] = original[k + j];

		return matrix;
	}
}
