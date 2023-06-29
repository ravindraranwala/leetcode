package com.coding.challenge.binary.search;

import com.coding.challenge.BinarySearch;

class Search2DMatrix {
	Search2DMatrix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] matrixOne = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		assert searchMatrix(matrixOne, 3);

		final int[][] matrixTwo = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		assert !searchMatrix(matrixTwo, 13);
	}

	static boolean searchMatrix(int[][] matrix, int target) {
		final int m = matrix.length;
		int l = 0;
		int r = m;
		while (l < r) {
			final int mid = (l + r) / 2;
			if (matrix[mid][0] < target + 1)
				l = mid + 1;
			else
				r = mid;
		}
		final int p = Math.max(l - 1, 0);
		return BinarySearch.search(matrix[p], target) != -1;
	}

}
