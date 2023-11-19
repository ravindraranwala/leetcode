package com.coding.challenge.matrix;

class CountServersThatCommunicate {
	CountServersThatCommunicate() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 1, 0 }, { 0, 1 } };
		assert countServers(gridOne) == 0;

		final int[][] gridTwo = { { 1, 0 }, { 1, 1 } };
		assert countServers(gridTwo) == 3;

		final int[][] gridThree = { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
		assert countServers(gridThree) == 4;
	}

	static int countServers(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[] rowCnt = new int[m];
		final int[] colCnt = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					rowCnt[i] = rowCnt[i] + 1;
					colCnt[j] = colCnt[j] + 1;
				}
			}
		}
		int c = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (grid[i][j] == 1 && (rowCnt[i] > 1 || colCnt[j] > 1))
					c = c + 1;
		return c;
	}
}
