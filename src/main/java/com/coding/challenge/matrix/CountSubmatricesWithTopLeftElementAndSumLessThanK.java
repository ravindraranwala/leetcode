package com.coding.challenge.matrix;

class CountSubmatricesWithTopLeftElementAndSumLessThanK {
	CountSubmatricesWithTopLeftElementAndSumLessThanK() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 7, 6, 3 }, { 6, 6, 1 } };
		assert countSubmatrices(grid1, 18) == 4;

		final int[][] grid2 = { { 7, 2, 9 }, { 1, 5, 0 }, { 2, 6, 6 } };
		assert countSubmatrices(grid2, 20) == 6;
	}

	static int countSubmatrices(int[][] grid, int k) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[] a = new int[n];
		int c = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0, s = 0; j < n; j++) {
				s = s + grid[i][j];
				a[j] = a[j] + s;
				if (a[j] <= k)
					c = c + 1;
			}
		}

		return c;
	}
}
