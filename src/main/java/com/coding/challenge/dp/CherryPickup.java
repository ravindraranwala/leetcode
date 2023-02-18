package com.coding.challenge.dp;

import java.util.StringJoiner;

class CherryPickup {
	CherryPickup() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 0, 1, -1 }, { 1, 0, -1 }, { 1, 1, 1 } };
		System.out.println(cherryPickup(gridOne));
		assert cherryPickup(gridOne) == 5;

//		final int[][] gridTwo = { { 1, 1, -1 }, { 1, -1, 1 }, { -1, 1, 1 } };
//		assert cherryPickup(gridTwo) == 0;
//
//		final int[][] gridThree = { { 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 1 },
//				{ 1, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1, 1, 1 } };
//		assert cherryPickup(gridThree) == 15;
	}

	static int cherryPickup(int[][] grid) {
		final int n = grid.length;
		final int[][] matrix = new int[n + 1][n + 1];
		for (int i = 2; i <= n; i++) {
			matrix[0][i] = -1;
			matrix[i][0] = -1;
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				matrix[i + 1][j + 1] = grid[i][j];

		final int levels = 2 * n - 1;
		System.out.println(levels);
		final int[][][] c = new int[levels][n][n];

		for (int l = 0; l < levels; l++) {
			final StringJoiner lev = new StringJoiner(", ");
			for (int i = Math.max(0, l - n + 1), j = Math.min(n - 1, l); j >= Math.max(0, l - n + 1); i++, j--) {
				lev.add("(" + i + ", " + j + ")");

				System.out.print("current block: " + "(" + i + ", " + j + ") is compared with: ");
				final StringJoiner cmp = new StringJoiner(", ");
				// now consider each combination of blocks.
				for (int p = i, q = j; p >= Math.max(0, l - n + 1); p--, q++) 
					cmp.add("(" + p + ", " + q + ")");
				
				System.out.print(cmp.toString());
				System.out.println();
			}
			System.out.println(lev);
		}

		return c[levels - 1][n - 1][n - 1];
	}
}
