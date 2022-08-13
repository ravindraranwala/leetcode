package com.coding.challenge.dp;

class SubmatricesWithAllOnes {
	SubmatricesWithAllOnes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] m1 = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		int cnt = numSubmat(m1);
		assert cnt == 13;

		final int[][] m2 = { { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 1, 1, 0 } };
		cnt = numSubmat(m2);
		assert cnt == 24;

		final int[][] m3 = { { 1, 1, 1, 1, 1, 1 } };
		cnt = numSubmat(m3);
		assert cnt == 21;

		final int[][] m4 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		cnt = numSubmat(m4);
		assert cnt == 12;

		final int[][] m5 = { { 1, 1, 1, 1, 0 }, { 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1 }, { 0, 1, 0, 0, 0 } };
		cnt = numSubmat(m5);
		assert cnt == 17;
	}

	static int numSubmat(int[][] mat) {
		final int m = mat.length;
		final int n = mat[0].length;
		final int[][] t = new int[m][n + 1];
		// adding 0 column to the beginning.
		for (int i = 0; i < m; i++)
			t[i][0] = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0)
					t[i][j + 1] = 0;
				else
					t[i][j + 1] = t[i][j] + 1;
			}
		}

		int ans = 0;
		// current col
		for (int i = 1; i < n + 1; i++) {
			// other cols before it
			for (int j = 0; j < i; j++) {
				int c = 0;
				// rows
				for (int k = 0; k < m; k++) {
					if (t[k][i] - t[k][j] == i - j) {
						c = c + 1;
						ans = ans + c;
					} else
						c = 0;
				}
			}
		}

		return ans;
	}
}
