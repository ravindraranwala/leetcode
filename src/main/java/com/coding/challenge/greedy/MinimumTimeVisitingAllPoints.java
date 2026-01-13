package com.coding.challenge.greedy;

class MinimumTimeVisitingAllPoints {
	MinimumTimeVisitingAllPoints() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] p1 = { { 1, 1 }, { 3, 4 }, { -1, 0 } };
		assert minTimeToVisitAllPoints(p1) == 7;

		final int[][] p2 = { { 3, 2 }, { -2, 2 } };
		assert minTimeToVisitAllPoints(p2) == 5;
	}

	static int minTimeToVisitAllPoints(int[][] points) {
		final int n = points.length;
		int t = 0;
		for (int i = 1; i < n; i++) {
			final int dx = Math.abs(points[i][0] - points[i - 1][0]);
			final int dy = Math.abs(points[i][1] - points[i - 1][1]);
			t = t + Math.min(dx, dy) + Math.abs(dx - dy);
		}
		return t;
	}
}
