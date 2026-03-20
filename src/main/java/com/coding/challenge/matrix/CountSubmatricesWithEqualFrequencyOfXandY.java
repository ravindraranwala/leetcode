package com.coding.challenge.matrix;

class CountSubmatricesWithEqualFrequencyOfXandY {
	private static final char X = 'X';
	private static final char Y = 'Y';

	CountSubmatricesWithEqualFrequencyOfXandY() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[][] grid1 = { { 'X', 'Y', '.' }, { 'Y', '.', '.' } };
		assert numberOfSubmatrices(grid1) == 3;

		final char[][] grid2 = { { 'X', 'X' }, { 'X', 'Y' } };
		assert numberOfSubmatrices(grid2) == 0;

		final char[][] grid3 = { { '.', '.' }, { '.', '.' } };
		assert numberOfSubmatrices(grid3) == 0;
	}

	static int numberOfSubmatrices(char[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[] xCnt = new int[n];
		final int[] yCnt = new int[n];
		int c = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0, xRow = 0, yRow = 0; j < n; j++) {
				if (grid[i][j] == X)
					xRow = xRow + 1;
				else if (grid[i][j] == Y)
					yRow = yRow + 1;

				xCnt[j] = xCnt[j] + xRow;
				yCnt[j] = yCnt[j] + yRow;
				if (xCnt[j] > 0 && xCnt[j] == yCnt[j])
					c = c + 1;
			}
		}
		return c;
	}
}
