package com.coding.challenge.matrix;

import java.util.Arrays;

class FlipSquareSubmatrixVertically {
	FlipSquareSubmatrixVertically() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		final int[][] a1 = { { 1, 2, 3, 4 }, { 13, 14, 15, 8 }, { 9, 10, 11, 12 }, { 5, 6, 7, 16 } };
		assert Arrays.deepEquals(a1, reverseSubmatrix(gridOne, 1, 0, 3));

		final int[][] gridTwo = { { 3, 4, 2, 3 }, { 2, 3, 4, 2 } };
		final int[][] a2 = { { 3, 4, 4, 2 }, { 2, 3, 2, 3 } };
		assert Arrays.deepEquals(a2, reverseSubmatrix(gridTwo, 0, 2, 2));
	}

	static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
		for (int i = 0; i < k / 2; i++) {
			for (int j = 0; j < k; j++) {
				// swap.
				final int tmp = grid[x + i][y + j];
				grid[x + i][y + j] = grid[x + k - 1 - i][y + j];
				grid[x + k - 1 - i][y + j] = tmp;
			}
		}
		return grid;
	}
}
