package com.coding.challenge.matrix;

import java.util.Arrays;

class MinimumAbsoluteDifferenceInSlidingSubmatrix {
	MinimumAbsoluteDifferenceInSlidingSubmatrix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 1, 8 }, { 3, -2 } };
		final int[][] ans1 = { { 2 } };
		assert Arrays.deepEquals(ans1, minAbsDiff(grid1, 2));

		final int[][] grid2 = { { 3, -1 } };
		final int[][] ans2 = { { 0, 0 } };
		assert Arrays.deepEquals(ans2, minAbsDiff(grid2, 1));

		final int[][] grid3 = { { 1, -2, 3 }, { 2, 3, 5 } };
		final int[][] ans3 = { { 1, 2 } };
		assert Arrays.deepEquals(ans3, minAbsDiff(grid3, 2));
	}

	static int[][] minAbsDiff(int[][] grid, int k) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[][] ans = new int[m - k + 1][n - k + 1];

		for (int i = 0; i < m - k + 1; i++) {
			for (int j = 0; j < n - k + 1; j++) {
				final int[] a = new int[k * k];
				for (int p = i, idx = 0; p < i + k; p++) {
					for (int q = j; q < j + k; q++) {
						a[idx] = grid[p][q];
						idx = idx + 1;
					}
				}
				Arrays.sort(a);
				int sln = Integer.MAX_VALUE;
				for (int x = 1; x < k * k; x++)
					if (a[x] > a[x - 1])
						sln = Math.min(sln, a[x] - a[x - 1]);

				if (sln == Integer.MAX_VALUE)
					ans[i][j] = 0;
				else
					ans[i][j] = sln;
			}
		}
		return ans;
	}
}
