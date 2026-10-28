package com.coding.challenge.matrix;

import java.util.Arrays;

class CreateGridWithExactlyOnePath {
	private static final char OBSTACLE = '#';
	private static final char FREE = '.';

	CreateGridWithExactlyOnePath() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(createGrid(2, 3)));
		System.out.println(Arrays.toString(createGrid(3, 3)));
		System.out.println(Arrays.toString(createGrid(1, 4)));
	}

	static String[] createGrid(int m, int n) {
		final char[][] grid = new char[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = OBSTACLE;

		int i = 0;
		int j = 0;

		while (i < m && j < n) {
			grid[i][j] = FREE;

			if (j < n - 1)
				j = j + 1;
			else
				i = i + 1;

		}

		// constructing the output.
		final String[] ans = new String[m];
		for (int row = 0; row < m; row++)
			ans[row] = new String(grid[row]);

		return ans;
	}
}
