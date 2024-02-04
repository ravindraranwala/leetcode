package com.coding.challenge.kruskal;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge.kruskal.MSTKruskal.Edge;

class MinCostToConnectAllPoints {
	MinCostToConnectAllPoints() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] points1 = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
		assert minCostConnectPoints(points1) == 20;

		final int[][] points2 = { { 3, 12 }, { -2, 5 }, { -4, 1 } };
		assert minCostConnectPoints(points2) == 18;

		final int[][] points3 = { { 0, 0 }, { 1, 1 }, { 1, 0 }, { -1, 1 } };
		assert minCostConnectPoints(points3) == 4;

		final int[][] points4 = { { 0, 0 } };
		assert minCostConnectPoints(points4) == 0;

		final int[][] points5 = { { 2, -3 }, { -17, -8 }, { 13, 8 }, { -17, -15 } };
		assert minCostConnectPoints(points5) == 53;
	}

	static int minCostConnectPoints(int[][] points) {
		final int n = points.length;
		final List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				final int d = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
				edges.add(new Edge(i + 1, j + 1, d));
			}
		}

		return MSTKruskal.mstKruskal(n, edges.toArray(new Edge[0]));
	}
}
