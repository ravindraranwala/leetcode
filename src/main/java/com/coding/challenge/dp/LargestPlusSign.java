package com.coding.challenge.dp;

class LargestPlusSign {
	LargestPlusSign() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] minesOne = { { 4, 2 } };
		assert orderOfLargestPlusSign(5, minesOne) == 2;

		final int[][] minesTwo = { { 0, 0 } };
		assert orderOfLargestPlusSign(1, minesTwo) == 0;

		final int[][] minesThree = { { 0, 0 }, { 0, 1 }, { 1, 0 } };
		assert orderOfLargestPlusSign(2, minesThree) == 1;

		final int[][] minesFour = { { 1, 0 }, { 1, 4 }, { 2, 4 }, { 3, 2 }, { 4, 0 }, { 4, 3 } };
		assert orderOfLargestPlusSign(5, minesFour) == 2;

		final int[][] minesFive = { { 0, 0 }, { 0, 1 }, { 0, 4 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 }, { 2, 1 },
				{ 2, 2 }, { 2, 3 }, { 2, 4 }, { 3, 0 }, { 4, 0 }, { 4, 1 }, { 4, 3 }, { 4, 4 } };
		assert orderOfLargestPlusSign(5, minesFive) == 1;

		final int[][] minesSix = { { 0, 0 }, { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 2 } };
		assert orderOfLargestPlusSign(3, minesSix) == 1;
	}

	static int orderOfLargestPlusSign(int n, int[][] mines) {
		final boolean[][] zeros = new boolean[n][n];
		for (int[] m : mines)
			zeros[m[0]][m[1]] = true;

		final int[][] matrix = new int[n][n];
		final int[] top = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				top[j] = zeros[i][j] ? 0 : top[j] + 1;
				matrix[i][j] = top[j];
			}
		}

		final int[] left = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				left[j] = zeros[j][i] ? 0 : left[j] + 1;
				matrix[j][i] = Math.min(matrix[j][i], left[j]);
			}
		}

		final int[] bottom = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				bottom[j] = zeros[i][j] ? 0 : bottom[j] + 1;
				matrix[i][j] = Math.min(matrix[i][j], bottom[j]);
			}
		}

		final int[] right = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				right[j] = zeros[j][i] ? 0 : right[j] + 1;
				matrix[j][i] = Math.min(matrix[j][i], right[j]);
			}
		}

		int order = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				order = Math.max(order, matrix[i][j]);
		return order;
	}
}
