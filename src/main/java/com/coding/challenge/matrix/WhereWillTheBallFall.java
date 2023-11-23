package com.coding.challenge.matrix;

import java.util.Arrays;

class WhereWillTheBallFall {
	WhereWillTheBallFall() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 1, 1, 1, -1, -1 }, { 1, 1, 1, -1, -1 }, { -1, -1, -1, 1, 1 }, { 1, 1, 1, 1, -1 },
				{ -1, -1, -1, -1, -1 } };
		final int[] ansOne = { 1, -1, -1, -1, -1 };
		assert Arrays.equals(ansOne, findBall(gridOne));

		final int[][] gridTwo = { { -1 } };
		final int[] ansTwo = { -1 };
		assert Arrays.equals(ansTwo, findBall(gridTwo));

		final int[][] gridThree = { { 1, 1, 1, 1, 1, 1 }, { -1, -1, -1, -1, -1, -1 }, { 1, 1, 1, 1, 1, 1 },
				{ -1, -1, -1, -1, -1, -1 } };
		final int[] ansThree = { 0, 1, 2, 3, 4, -1 };
		assert Arrays.equals(ansThree, findBall(gridThree));
	}

	static int[] findBall(int[][] grid) {
		final int n = grid[0].length;
		final int[] a = new int[n];
		for (int j = 0; j < n; j++)
			a[j] = visitGrid(grid, 0, j);
		return a;
	}

	private static int visitGrid(int[][] grid, int r, int c) {
		final int m = grid.length;
		final int n = grid[0].length;

		if (r == m)
			return c;
		if (c < n - 1 && grid[r][c] == 1 && grid[r][c + 1] == 1)
			return visitGrid(grid, r + 1, c + 1);
		if (c > 0 && grid[r][c] == -1 && grid[r][c - 1] == -1)
			return visitGrid(grid, r + 1, c - 1);
		return -1;
	}
}
