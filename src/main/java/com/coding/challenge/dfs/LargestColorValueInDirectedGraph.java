package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

class LargestColorValueInDirectedGraph {
	private static final char FIRST_LETTER = 'a';
	private boolean cycle = false;

	LargestColorValueInDirectedGraph() {

	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 4 } };
		assert new LargestColorValueInDirectedGraph().largestPathValue("abaca", edges1) == 3;

		final int[][] edges2 = { { 0, 0 } };
		assert new LargestColorValueInDirectedGraph().largestPathValue("a", edges2) == -1;

		final int[][] edges3 = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 2, 3 }, { 3, 4 }, { 4, 2 } };
		assert new LargestColorValueInDirectedGraph().largestPathValue("acbad", edges3) == -1;

		final int[][] edges4 = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 2, 3 }, { 3, 4 } };
		assert new LargestColorValueInDirectedGraph().largestPathValue("acbad", edges4) == 2;

		assert new LargestColorValueInDirectedGraph().largestPathValue("g", new int[0][0]) == 1;
	}

	int largestPathValue(String colors, int[][] edges) {
		final int n = colors.length();
		final Color[] d = new Color[n];
		final List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
			d[i] = Color.WHITE;
		}

		for (int[] e : edges)
			adjList.get(e[0]).add(e[1]);

		final int[][] f = new int[n][26];
		for (int u = 0; u < n; u++) {
			if (d[u] == Color.WHITE)
				dfs(u, d, f, adjList, colors);
			
			if (cycle)
				return -1;
		}

		// Constructing the optimal solution.
		int ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < 26; j++)
				ans = Math.max(ans, f[i][j]);

		return ans;
	}

	private void dfs(int u, Color[] d, int[][] f, List<List<Integer>> adjList, String colors) {
		d[u] = Color.GRAY;
		for (int v : adjList.get(u)) {
			if (d[v] == Color.GRAY) {
				cycle = true;
				return;
			}
			if (d[v] == Color.WHITE)
				dfs(v, d, f, adjList, colors);

			// compute the color frequency for node u.
			// compute the point wise maximum.
			for (int j = 0; j < 26; j++)
				f[u][j] = Math.max(f[u][j], f[v][j]);
		}
		// take node u's color into account.
		f[u][colors.charAt(u) - FIRST_LETTER] = f[u][colors.charAt(u) - FIRST_LETTER] + 1;
		// blacken the current node's color u as it's adjacency list is scanned.
		d[u] = Color.BLACK;
	}

	private static enum Color {
		WHITE, GRAY, BLACK
	}
}
