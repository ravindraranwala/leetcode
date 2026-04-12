package com.coding.challenge.two.pointer;

class MatrixSimilarityAfterCyclicShifts {
	MatrixSimilarityAfterCyclicShifts() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] mat1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		assert !areSimilar(mat1, 4);

		final int[][] mat2 = { { 1, 2, 1, 2 }, { 5, 5, 5, 5 }, { 6, 3, 6, 3 } };
		assert areSimilar(mat2, 2);

		final int[][] mat3 = { { 2, 2 }, { 2, 2 } };
		assert areSimilar(mat3, 3);

		final int[][] mat4 = { { 2, 2 }, { 25, 23 } };
		assert !areSimilar(mat4, 35);
	}

	static boolean areSimilar(int[][] mat, int k) {
		final int m = mat.length;
		final int n = mat[0].length;
		final int d = k % n;
		// even rows.
		for (int i = 0; i < m; i = i + 2) {
			for (int j = 0; j < n; j++) {
				final int p = (j + d) % n;
				if (mat[i][j] != mat[i][p])
					return false;
			}
		}

		// odd rows.
		for (int i = 1; i < m; i = i + 2) {
			for (int j = 0; j < n; j++) {
				final int q = j >= d ? j - d : n - (d - j);	// j < d
				if (mat[i][j] != mat[i][q])
					return false;
			}
		}

		return true;
	}
}
