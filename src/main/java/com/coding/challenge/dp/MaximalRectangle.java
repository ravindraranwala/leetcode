package com.coding.challenge.dp;

class MaximalRectangle {
	MaximalRectangle() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[][] m1 = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		int ans = maximalRectangle(m1);
		assert ans == 6;

		final char[][] m2 = { { '0' } };
		ans = maximalRectangle(m2);
		assert ans == 0;

		final char[][] m3 = { { '1' } };
		ans = maximalRectangle(m3);
		assert ans == 1;

		final char[][] m4 = { { '0', '0', '1', '0' }, { '0', '0', '1', '0' }, { '0', '0', '1', '0' },

				{ '0', '0', '1', '1' }, { '0', '1', '1', '1' }, { '0', '1', '1', '1' }, { '1', '1', '1', '1' } };
		ans = maximalRectangle(m4);
		assert ans == 9;
	}

	static int maximalRectangle(char[][] matrix) {
		final int r = matrix.length;
		final int c = matrix[0].length;
		final int[][] t = new int[r][c + 1];

		for (int i = 0; i < r; i++)
			t[i][0] = 0;

		// getting the row sums.
		for (int i = 0; i < r; i++)
			for (int j = 1; j <= c; j++)
				t[i][j] = matrix[i][j - 1] == '0' ? 0 : t[i][j - 1] + 1;

		int ans = 0;
		// curr col
		for (int i = 1; i <= c; i++) {
			// previous cols
			for (int j = 0; j < i; j++) {
				int s = 0;
				// rows
				for (int k = 0; k < r; k++) {
					if (t[k][i] - t[k][j] == i - j) {
						s = s + i - j;
						ans = Math.max(ans, s);
					} else
						s = 0;
				}
			}
		}
		return ans;
	}
}
