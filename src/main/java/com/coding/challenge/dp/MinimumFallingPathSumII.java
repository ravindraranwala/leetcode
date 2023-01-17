package com.coding.challenge.dp;

class MinimumFallingPathSumII {
	MinimumFallingPathSumII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		assert minFallingPathSum(gridOne) == 13;

		final int[][] gridTwo = { { 7 } };
		assert minFallingPathSum(gridTwo) == 7;

		final int[][] gridThree = { { -73, 61, 43, -48, -36 }, { 3, 30, 27, 57, 10 }, { 96, -76, 84, 59, -15 },
				{ 5, -49, 76, 31, -7 }, { 97, 91, 61, -46, 67 } };
		assert minFallingPathSum(gridThree) == -192;
	}

	static int minFallingPathSum(int[][] grid) {
		final int n = grid.length;
		int currSmallest = 0;

		for (int i = n - 1, currSecondSmallest = 0, currSmallestIdx = -1; i >= 0; i--) {
			final int prevSmallestIdx = currSmallestIdx;
			final int prevSmallest = currSmallest;
			final int prevSecondSmallest = currSecondSmallest;
			currSmallest = Integer.MAX_VALUE;
			currSecondSmallest = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				final int value = prevSmallestIdx == j ? prevSecondSmallest + grid[i][j] : prevSmallest + grid[i][j];

				if (value < currSmallest) {
					currSecondSmallest = currSmallest;
					currSmallest = value;
					currSmallestIdx = j;
				} else if (value < currSecondSmallest)
					currSecondSmallest = value;
			}
		}

		return currSmallest;
	}
}
