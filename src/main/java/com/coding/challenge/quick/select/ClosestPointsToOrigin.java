package com.coding.challenge.quick.select;

import java.util.Arrays;

class ClosestPointsToOrigin {
	ClosestPointsToOrigin() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] pointsOne = { { 1, 3 }, { -2, 2 } };
		final int[][] expectedOne = { { -2, 2 } };
		assert Arrays.deepEquals(expectedOne, kClosest(pointsOne, 1));

		final int[][] pointsTwo = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		final int[][] expectedTwo = { { 3, 3 }, { -2, 4 } };
		assert Arrays.deepEquals(expectedTwo, kClosest(pointsTwo, 2));
	}

	static int[][] kClosest(int[][] points, int k) {
		final int n = points.length;
		// There can be two points with the same Euclidean distance from the origin.
		final int[] distance = new int[n];
		final int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			final int e = points[i][0] * points[i][0] + points[i][1] * points[i][1];
			distance[i] = e;
			d[i] = e;
		}

		final int kthSmallestDist = QuickSelect.randomizedSelect(d, 0, n - 1, k);
		final int[][] closestpoints = new int[k][2];
		for (int i = 0, j = 0; i < n; i++) {
			if (distance[i] <= kthSmallestDist) {
				closestpoints[j] = points[i];
				j = j + 1;
			}
		}

		return closestpoints;
	}
}
