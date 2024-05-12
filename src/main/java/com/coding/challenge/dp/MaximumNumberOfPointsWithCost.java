package com.coding.challenge.dp;

class MaximumNumberOfPointsWithCost {
	MaximumNumberOfPointsWithCost() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] points1 = { { 1, 2, 3 }, { 1, 5, 1 }, { 3, 1, 1 } };
		assert maxPoints(points1) == 9;

		final int[][] points2 = { { 1, 5 }, { 2, 3 }, { 4, 2 } };
		assert maxPoints(points2) == 11;
	}

	static long maxPoints(int[][] points) {
		final int m = points.length;
		final int n = points[0].length;
		final long[][] t = new long[m][n];

		// trivial case of the recursion.
		for (int j = 0; j < n; j++)
			t[0][j] = points[0][j];

		// topological order.
		for (int i = 1; i < m; i++) {
			long currMaxPts = 0;
			for (int j = 0; j < n; j++) {
				currMaxPts = Math.max(currMaxPts - 1, t[i - 1][j]);
				t[i][j] = currMaxPts + points[i][j];
			}
			currMaxPts = 0;
			for (int k = n - 1; k >= 0; k--) {
				currMaxPts = Math.max(currMaxPts - 1, t[i - 1][k]);
				t[i][k] = Math.max(t[i][k], currMaxPts + points[i][k]);
			}
		}

		// constructing the optimal solution.
		long maxPoints = 0;
		for (int j = 0; j < n; j++)
			maxPoints = Math.max(maxPoints, t[m - 1][j]);
		return maxPoints;
	}
}
