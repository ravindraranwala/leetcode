package com.coding.challenge.greedy;

import com.coding.challenge.quick.select.QuickSelect;

class MinimumOperationsToMakeUniValueGrid {
	MinimumOperationsToMakeUniValueGrid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 2, 4 }, { 6, 8 } };
		assert minOperations(grid1, 2) == 4;

		final int[][] grid2 = { { 1, 5 }, { 2, 3 } };
		assert minOperations(grid2, 1) == 5;

		final int[][] grid3 = { { 1, 2 }, { 3, 4 } };
		assert minOperations(grid3, 2) == -1;
	}

	static int minOperations(int[][] grid, int x) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int l = m * n;
		final int[] a = new int[l];
		// find the median value first.
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				a[i * n + j] = grid[i][j];
// Sorting is superfluous here.
//		Arrays.sort(a);
//		final int median = a[l / 2];
		final int median = QuickSelect.randomizedSelect(a, 0, l - 1, l / 2 + 1);

		int c = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (Math.abs(grid[i][j] - median) % x == 0)
					c = c + Math.abs(grid[i][j] - median) / x;
				else
					return -1;
			}
		}

		return c;
	}
}
