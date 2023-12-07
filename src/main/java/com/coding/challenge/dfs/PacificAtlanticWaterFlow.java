package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PacificAtlanticWaterFlow {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	PacificAtlanticWaterFlow() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] h1 = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		final List<List<Integer>> p1 = Arrays.asList(Arrays.asList(0, 4), Arrays.asList(1, 3), Arrays.asList(1, 4),
				Arrays.asList(2, 2), Arrays.asList(3, 0), Arrays.asList(3, 1), Arrays.asList(4, 0));
		assert p1.equals(pacificAtlantic(h1));
		System.out.println();

		final int[][] h2 = { { 1 } };
		assert Arrays.asList(Arrays.asList(0, 0)).equals(pacificAtlantic(h2));

		final int[][] h3 = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
		final List<List<Integer>> p3 = Arrays.asList(Arrays.asList(0, 2), Arrays.asList(1, 0), Arrays.asList(1, 1),
				Arrays.asList(1, 2), Arrays.asList(2, 0), Arrays.asList(2, 1), Arrays.asList(2, 2));
		assert p3.equals(pacificAtlantic(h3));
	}

	static List<List<Integer>> pacificAtlantic(int[][] heights) {
		final int m = heights.length;
		final int n = heights[0].length;
		final boolean[][] pd = new boolean[m][n];
		// discover cells reachable from Pacific
		for (int j = 0; j < n; j++)
			if (!pd[0][j])
				oceanReachable(heights, pd, 0, j);

		for (int i = 0; i < m; i++)
			if (!pd[i][0])
				oceanReachable(heights, pd, i, 0);

		// discover cells reachable from Atlantic
		final boolean[][] ad = new boolean[m][n];
		for (int j = 0; j < n; j++)
			if (!ad[0][j])
				oceanReachable(heights, ad, m - 1, j);

		for (int i = 0; i < m; i++)
			if (!ad[i][n - 1])
				oceanReachable(heights, ad, i, n - 1);

		// constructing intersection points.
		final List<List<Integer>> p = new ArrayList<>();
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (pd[i][j] && ad[i][j])
					p.add(Arrays.asList(i, j));

		return p;
	}

	private static void oceanReachable(int[][] heights, boolean[][] d, int i, int j) {
		d[i][j] = true;
		for (int[] m : MOVES) {
			final int r = i + m[0];
			final int c = j + m[1];
			if (r >= 0 && r < heights.length && c >= 0 && c < heights[0].length && !d[r][c]
					&& heights[r][c] >= heights[i][j])
				oceanReachable(heights, d, r, c);
		}
	}
}
