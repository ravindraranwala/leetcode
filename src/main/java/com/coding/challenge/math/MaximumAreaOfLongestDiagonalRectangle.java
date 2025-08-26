package com.coding.challenge.math;

class MaximumAreaOfLongestDiagonalRectangle {
	MaximumAreaOfLongestDiagonalRectangle() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] dimensions1 = { { 9, 3 }, { 8, 6 } };
		assert areaOfMaxDiagonal(dimensions1) == 48;

		final int[][] dimensions2 = { { 3, 4 }, { 4, 3 } };
		assert areaOfMaxDiagonal(dimensions2) == 12;
	}

	static int areaOfMaxDiagonal(int[][] dimensions) {
		final int n = dimensions.length;
		int k = 0;
		for (int i = 1; i < n; i++) {
			if ((dimensions[i][0] * dimensions[i][0]
					+ dimensions[i][1] * dimensions[i][1]) > (dimensions[k][0] * dimensions[k][0]
							+ dimensions[k][1] * dimensions[k][1])) {
				k = i;
			} else if ((dimensions[i][0] * dimensions[i][0]
					+ dimensions[i][1] * dimensions[i][1]) == (dimensions[k][0] * dimensions[k][0]
							+ dimensions[k][1] * dimensions[k][1])
					&& dimensions[i][0] * dimensions[i][1] > dimensions[k][0] * dimensions[k][1]) {
				k = i;

			}
		}
		return dimensions[k][0] * dimensions[k][1];
	}
}
