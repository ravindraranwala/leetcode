package com.coding.challenge.dp;

class MaximalSquare {

	MaximalSquare() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[][] m1 = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		int ans = maximalSquare(m1);
		System.out.println(ans);

		final char[][] m2 = { { '0', '1' }, { '1', '0' } };
		ans = maximalSquare(m2);
		System.out.println(ans);

		final char[][] m3 = { { '0' } };
		ans = maximalSquare(m3);
		System.out.println(ans);
	}

	static int maximalSquare(char[][] matrix) {
		final int m = matrix.length;
		final int n = matrix[0].length;
		final int[][] t = new int[m][n];
		int ans = 0;
		// base case of the recursion.
		for (int i = 0; i < m; i++) {
			t[i][0] = matrix[i][0] - '0';
			ans = Math.max(ans, t[i][0]);
		}

		for (int j = 1; j < n; j++) {
			t[0][j] = matrix[0][j] - '0';
			ans = Math.max(ans, t[0][j]);
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '0')
					t[i][j] = 0;
				else {
					t[i][j] = Math.min(t[i - 1][j], Math.min(t[i][j - 1], t[i - 1][j - 1])) + 1;
					ans = (int) Math.max(ans, t[i][j]);
				}
			}
		}
		return ans * ans;
	}
}
