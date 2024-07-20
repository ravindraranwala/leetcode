package com.coding.challenge.matrix;

import java.util.ArrayList;
import java.util.List;

class LuckyNumbersInMatrix {
	LuckyNumbersInMatrix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] matrix1 = { { 3, 7, 8 }, { 9, 11, 13 }, { 15, 16, 17 } };
		System.out.println(luckyNumbers(matrix1));

		final int[][] matrix2 = { { 1, 10, 4, 2 }, { 9, 3, 8, 7 }, { 15, 16, 17, 12 } };
		System.out.println(luckyNumbers(matrix2));

		final int[][] matrix3 = { { 7, 8 }, { 1, 2 } };
		System.out.println(luckyNumbers(matrix3));
	}

	static List<Integer> luckyNumbers(int[][] matrix) {
		final int m = matrix.length;
		final int n = matrix[0].length;
		final int[] rowMin = new int[m];
		final int[] colMax = new int[n];

		for (int i = 0; i < m; i++) {
			rowMin[i] = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				final int currNum = matrix[i][j];
				rowMin[i] = Math.min(rowMin[i], currNum);
				colMax[j] = Math.max(colMax[j], currNum);
			}
		}

		final List<Integer> luckyNums = new ArrayList<>();
		for (int rowMinVal : rowMin) 
			for (int colMaxVal : colMax) 
				if (rowMinVal == colMaxVal)
					luckyNums.add(rowMinVal);
			
		return luckyNums;
	}
}
