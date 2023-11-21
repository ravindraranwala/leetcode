package com.coding.challenge.math;

import java.util.Arrays;

class MinimumOperationsToMakeUniValueGrid {
	MinimumOperationsToMakeUniValueGrid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 2, 4 }, { 6, 8 } };
		assert minOperations(gridOne, 2) == 4;

		final int[][] gridTwo = { { 1, 5 }, { 2, 3 } };
		assert minOperations(gridTwo, 1) == 5;

		final int[][] gridThree = { { 1, 2 }, { 3, 4 } };
		assert minOperations(gridThree, 2) == -1;
	}

	static int minOperations(int[][] grid, int x) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[] a = new int[m * n];
		for (int i = 0, k = 0; i < m; i++)
			for (int j = 0; j < n; j++, k++)
				a[k] = grid[i][j];
		Arrays.sort(a);
		final int median = a[m * n / 2];
		int c = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if ((Math.abs(grid[i][j] - median)) % x == 0)
					c = c + Math.abs(grid[i][j] - median) / x;
				else
					return -1;
			}
		}
		return c;
	}
}
