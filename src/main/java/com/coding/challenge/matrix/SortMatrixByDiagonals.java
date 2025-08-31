package com.coding.challenge.matrix;

import java.util.Arrays;

class SortMatrixByDiagonals {
	SortMatrixByDiagonals() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 1, 7, 3 }, { 9, 8, 2 }, { 4, 5, 6 } };
		final int[][] ans1 = { { 8, 2, 3 }, { 9, 6, 7 }, { 4, 5, 1 } };
		assert Arrays.deepEquals(ans1, sortMatrix(grid1));

		final int[][] grid2 = { { 0, 1 }, { 1, 2 } };
		final int[][] ans2 = {{2, 1}, {1, 0}};
		assert Arrays.deepEquals(ans2, sortMatrix(grid2));

		final int[][] grid3 = { { 1 } };
		final int[][] ans3 = { { 1 } };
		assert Arrays.deepEquals(ans3, sortMatrix(grid3));
	}

	static int[][] sortMatrix(int[][] grid) {
		final int n = grid.length;
		// handle bottom-left triangle.
		for (int i = 0; i < n; i++) {
			final int l = n - i;
			final int[] a = new int[l];
			for (int j = 0; j < l; j++)
				a[j] = grid[i + j][j];

			Arrays.sort(a);
			for (int j = 0; j < l; j++)
				grid[i + j][j] = a[l - 1 - j];
		}

		// handle the top-right triangle.
		for (int j = 1; j < n; j++) {
			final int l = n - j;
			final int[] a = new int[l];
			for (int i = 0; i < l; i++)
				a[i] = grid[i][i + j];

			Arrays.sort(a);
			for (int i = 0; i < l; i++)
				grid[i][i + j] = a[i];
		}
		return grid;
	}
}
