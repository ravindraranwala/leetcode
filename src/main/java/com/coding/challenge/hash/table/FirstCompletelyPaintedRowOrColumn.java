package com.coding.challenge.hash.table;

class FirstCompletelyPaintedRowOrColumn {
	FirstCompletelyPaintedRowOrColumn() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] arr1 = { 1, 3, 4, 2 };
		final int[][] mat1 = { { 1, 4 }, { 2, 3 } };
		assert firstCompleteIndex(arr1, mat1) == 2;

		final int[] arr2 = { 2, 8, 7, 4, 1, 3, 5, 6, 9 };
		final int[][] mat2 = { { 3, 2, 5 }, { 1, 4, 6 }, { 8, 7, 9 } };
		assert firstCompleteIndex(arr2, mat2) == 3;

		final int[] arr3 = { 1, 4, 5, 2, 6, 3 };
		final int[][] mat3 = { { 4, 3, 5 }, { 1, 2, 6 } };
		assert firstCompleteIndex(arr3, mat3) == 1;
	}

	static int firstCompleteIndex(int[] arr, int[][] mat) {
		final int m = mat.length;
		final int n = mat[0].length;
		final int l = arr.length;
		final int[] row = new int[l + 1];
		final int[] col = new int[l + 1];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				final int val = mat[i][j];
				row[val] = i;
				col[val] = j;
			}
		}

		final int[] rowFillCnt = new int[m];
		final int[] colFillCnt = new int[n];
		for (int i = 0; i < l; i++) {
			final int val = arr[i];
			rowFillCnt[row[val]] = rowFillCnt[row[val]] + 1;
			if (rowFillCnt[row[val]] == n)
				return i;
			colFillCnt[col[val]] = colFillCnt[col[val]] + 1;
			if (colFillCnt[col[val]] == m)
				return i;
		}
		// can't get here.
		throw new AssertionError();
	}
}
