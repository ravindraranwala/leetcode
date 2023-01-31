package com.coding.challenge.dp;

class LongestIncreasingPathInMatrix {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	LongestIncreasingPathInMatrix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] matrixOne = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		assert longestIncreasingPath(matrixOne) == 4;

		final int[][] matrixTwo = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
		assert longestIncreasingPath(matrixTwo) == 4;

		final int[][] matrixThree = { { 1 } };
		assert longestIncreasingPath(matrixThree) == 1;

		final int[][] matrixFour = { { 7, 8, 9 }, { 9, 7, 6 }, { 7, 2, 3 } };
		assert longestIncreasingPath(matrixFour) == 6;
	}

	static int longestIncreasingPath(int[][] matrix) {
		final int m = matrix.length;
		final int n = matrix[0].length;
		final int[][] p = new int[m][n];
		int l = 1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// undiscovered vertex.
				if (p[i][j] == 0) {
					visitIncreasingPaths(matrix, p, i, j);
					l = Math.max(l, p[i][j]);
				}
			}
		}
		return l;
	}

	private static void visitIncreasingPaths(int[][] matrix, int[][] p, int i, int j) {
		p[i][j] = 1;
		// adjacency list.
		for (int[] m : MOVES) {
			final int r = i + m[0];
			final int c = j + m[1];
			if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[i][j] < matrix[r][c]) {
				if (p[r][c] == 0)
					visitIncreasingPaths(matrix, p, r, c);
				p[i][j] = Math.max(p[i][j], p[r][c] + 1);

			}
		}
	}
}
