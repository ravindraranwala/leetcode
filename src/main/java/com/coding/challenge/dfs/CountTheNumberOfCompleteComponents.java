package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

class CountTheNumberOfCompleteComponents {
	CountTheNumberOfCompleteComponents() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } };
		assert countCompleteComponents(6, edges1) == 3;

		final int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 }, { 3, 5 } };
		assert countCompleteComponents(6, edges2) == 1;
	}

	static int countCompleteComponents(int n, int[][] edges) {
		final boolean[] d = new boolean[n];
		final int[] nodeToEdgesCnt = new int[n + 1];
		for (int nodes = 2; nodes <= n; nodes++)
			nodeToEdgesCnt[nodes] = nodeToEdgesCnt[nodes - 1] + nodes - 1;

		final List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] e : edges) {
			adjList.get(e[0]).add(e[1]);
			adjList.get(e[1]).add(e[0]);
		}

		int c = 0;
		for (int k = 0; k < n; k++) {
			if (!d[k]) {
				final int[] a = new int[2];
				dfs(adjList, d, k, a);
				// Each undirected edge is counted twice, hence dividing by 2 to get the edge
				// count.
				if (a[1] / 2 == nodeToEdgesCnt[a[0]])
					c = c + 1;
			}
		}
		return c;
	}

	private static void dfs(List<List<Integer>> adjList, boolean[] d, int u, int[] a) {
		d[u] = true;
		a[0] = a[0] + 1;
		a[1] = a[1] + adjList.get(u).size();
		for (int v : adjList.get(u))
			if (!d[v])
				dfs(adjList, d, v, a);
	}
}
