package com.coding.challenge.matrix;

class CountServersThatCommunicate {
	CountServersThatCommunicate() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 1, 0 }, { 0, 1 } };
		assert countServers(grid1) == 0;

		final int[][] grid2 = { { 1, 0 }, { 1, 1 } };
		assert countServers(grid2) == 3;

		final int[][] grid3 = { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } };
		assert countServers(grid3) == 4;
	}

	static int countServers(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[] svrCntByRow = new int[m];
		final int[] svrCntByCol = new int[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					svrCntByRow[i] = svrCntByRow[i] + 1;
					svrCntByCol[j] = svrCntByCol[j] + 1;
				}
			}
		}

		int c = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					if (svrCntByRow[i] > 1 || svrCntByCol[j] > 1)
						c = c + 1;
				}
			}
		}
		return c;
	}
}
