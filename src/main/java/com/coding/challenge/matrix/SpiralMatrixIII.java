package com.coding.challenge.matrix;

import java.util.Arrays;

class SpiralMatrixIII {
	SpiralMatrixIII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] a1 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } };
		assert Arrays.deepEquals(a1, spiralMatrixIII(1, 4, 0, 0));
		final int[][] a2 = { { 1, 4 }, { 1, 5 }, { 2, 5 }, { 2, 4 }, { 2, 3 }, { 1, 3 }, { 0, 3 }, { 0, 4 }, { 0, 5 },
				{ 3, 5 }, { 3, 4 }, { 3, 3 }, { 3, 2 }, { 2, 2 }, { 1, 2 }, { 0, 2 }, { 4, 5 }, { 4, 4 }, { 4, 3 },
				{ 4, 2 }, { 4, 1 }, { 3, 1 }, { 2, 1 }, { 1, 1 }, { 0, 1 }, { 4, 0 }, { 3, 0 }, { 2, 0 }, { 1, 0 },
				{ 0, 0 } };
		assert Arrays.deepEquals(a2, spiralMatrixIII(5, 6, 1, 4));
	}

	static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
		final int l = rows * cols;
		final int[][] coordinates = new int[l][2];
		coordinates[0][0] = rStart;
		coordinates[0][1] = cStart;
		final int n = Math.max(Math.max(cStart + 1, cols - cStart), Math.max(rStart + 1, rows - rStart)) * 2;

		for (int s = 2, r = rStart, c = cStart + 1, curr = 1; s <= n; s = s + 2) {
			for (int i = 0; i < s; i++) {
				if (validBlock(r, c, rows, cols)) {
					coordinates[curr][0] = r;
					coordinates[curr][1] = c;
					curr = curr + 1;
				}
				r = r + 1;
			}

			r = r - 1;
			c = c - 1;
			for (int i = 0; i < s; i++) {
				if (validBlock(r, c, rows, cols)) {
					coordinates[curr][0] = r;
					coordinates[curr][1] = c;
					curr = curr + 1;
				}
				c = c - 1;
			}

			c = c + 1;
			r = r - 1;
			for (int i = 0; i < s; i++) {
				if (validBlock(r, c, rows, cols)) {
					coordinates[curr][0] = r;
					coordinates[curr][1] = c;
					curr = curr + 1;
				}
				r = r - 1;
			}

			r = r + 1;
			c = c + 1;
			for (int i = 0; i < s; i++) {
				if (validBlock(r, c, rows, cols)) {
					coordinates[curr][0] = r;
					coordinates[curr][1] = c;
					curr = curr + 1;
				}
				c = c + 1;
			}
		}

		return coordinates;
	}

	private static boolean validBlock(int i, int j, int rows, int cols) {
		return i >= 0 && i < rows && j >= 0 && j < cols;
	}
}
