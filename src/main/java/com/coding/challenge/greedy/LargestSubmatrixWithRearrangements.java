package com.coding.challenge.greedy;

import java.util.Arrays;

class LargestSubmatrixWithRearrangements {
	LargestSubmatrixWithRearrangements() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] matrix1 = { { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } };
		assert largestSubmatrix(matrix1) == 4;

		final int[][] matrix2 = { { 1, 0, 1, 0, 1 } };
		assert largestSubmatrix(matrix2) == 3;
	}

	static int largestSubmatrix(int[][] matrix) {
		final int m = matrix.length;
		final int n = matrix[0].length;
		final int[] a = new int[n];
		int area = 0;

		for (int i = 0; i < m; i++) {
			final int[] ones = new int[n];
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0)
					a[j] = 0;
				else
					a[j] = a[j] + 1;

				ones[j] = a[j];
			}
			Arrays.sort(ones);
			for (int k = n - 1; k >= 0; k--)
				area = Math.max(area, ones[k] * (n - k));
		}
		return area;
	}
}
