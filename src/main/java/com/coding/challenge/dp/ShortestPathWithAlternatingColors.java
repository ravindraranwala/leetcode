package com.coding.challenge.dp;

import java.util.Arrays;

class ShortestPathWithAlternatingColors {
	ShortestPathWithAlternatingColors() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] redEdges1 = { { 0, 1 }, { 1, 2 } };
		final int[][] blueEdges1 = {};
		final int[] ans = { 0, 1, -1 };
		assert Arrays.equals(ans, shortestAlternatingPaths(3, redEdges1, blueEdges1));

		final int[][] redEdges2 = { { 0, 1 } };
		final int[][] blueEdges2 = { { 2, 1 } };
		assert Arrays.equals(ans, shortestAlternatingPaths(3, redEdges2, blueEdges2));
	}

	static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
		final int[] blueDist = new int[n];
		final int[] redDist = new int[n];
		// initialize.
		blueDist[0] = 0;
		redDist[0] = 0;
		for (int i = 1; i < n; i++) {
			blueDist[i] = -1;
			redDist[i] = -1;
		}

		for (int i = 1; i < n; i++) {
			for (int[] blueEdge : blueEdges) {
				final int u = blueEdge[0];
				final int v = blueEdge[1];
				// edge relaxation, fixing triangle inequality.
				if (blueDist[v] >= 0 && redDist[u] >= 0 && redDist[u] + 1 < blueDist[v])
					blueDist[v] = redDist[u] + 1;
				else if (blueDist[v] == -1 && redDist[u] >= 0)
					blueDist[v] = redDist[u] + 1;
			}

			for (int[] redEdge : redEdges) {
				final int u = redEdge[0];
				final int v = redEdge[1];
				// edge relaxation, fixing triangle inequality.
				if (redDist[v] >= 0 && blueDist[u] >= 0 && redDist[v] > blueDist[u] + 1)
					redDist[v] = blueDist[u] + 1;
				else if (redDist[v] == -1 && blueDist[u] >= 0)
					redDist[v] = blueDist[u] + 1;
			}
		}
		// solve original problem.
		final int[] d = new int[n];
		for (int v = 0; v < n; v++)
			if (blueDist[v] >= 0 && redDist[v] >= 0)
				d[v] = Math.min(blueDist[v], redDist[v]);
			else
				d[v] = Math.max(blueDist[v], redDist[v]);

		return d;
	}
}
