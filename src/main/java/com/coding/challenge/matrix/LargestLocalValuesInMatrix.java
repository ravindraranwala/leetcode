package com.coding.challenge.matrix;

import java.util.Arrays;

class LargestLocalValuesInMatrix {
	LargestLocalValuesInMatrix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 9, 9, 8, 1 }, { 5, 6, 2, 6 }, { 8, 2, 6, 4 }, { 6, 2, 2, 2 } };
		final int[][] a1 = { { 9, 9 }, { 8, 6 } };
		assert Arrays.deepEquals(a1, largestLocal(grid1));

		final int[][] grid2 = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 2, 1, 1 }, { 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1 } };
		final int[][] a2 = { { 2, 2, 2 }, { 2, 2, 2 }, { 2, 2, 2 } };
		assert Arrays.deepEquals(a2, largestLocal(grid2));
	}

	static int[][] largestLocal(int[][] grid) {
		final int n = grid.length;
		final int[][] m = new int[n - 2][n - 2];

		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < n - 2; j++) {
				int largest = 0;
				for (int p = 0; p < 3; p++)
					for (int q = 0; q < 3; q++)
						largest = Math.max(largest, grid[i + p][j + q]);
				m[i][j] = largest;
			}
		}
		return m;
	}
}
