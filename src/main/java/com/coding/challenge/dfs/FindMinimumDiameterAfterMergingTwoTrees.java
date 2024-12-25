package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

class FindMinimumDiameterAfterMergingTwoTrees {
	FindMinimumDiameterAfterMergingTwoTrees() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 } };
		final int[][] edges2 = { { 0, 1 } };
		assert minimumDiameterAfterMerge(edges1, edges2) == 3;

		final int[][] edges3 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 }, { 2, 7 } };
		final int[][] edges4 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 }, { 2, 7 } };
		assert minimumDiameterAfterMerge(edges3, edges4) == 5;

		final int[][] edges5 = { { 0, 1 }, { 2, 0 }, { 3, 2 }, { 3, 6 }, { 8, 7 }, { 4, 8 }, { 5, 4 }, { 3, 5 },
				{ 3, 9 } };
		final int[][] edges6 = { { 0, 1 }, { 0, 2 }, { 0, 3 } };
		assert minimumDiameterAfterMerge(edges5, edges6) == 7;
	}

	static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
		final int n = edges1.length + 1;
		final List<List<Integer>> adjList1 = adjacencyList(n, edges1);
		final int[] diameter1 = new int[1];
		dfs(0, n, adjList1, new boolean[n], diameter1);

		final int m = edges2.length + 1;
		final List<List<Integer>> adjList2 = adjacencyList(m, edges2);
		final int[] diameter2 = new int[1];
		dfs(0, m, adjList2, new boolean[m], diameter2);

		return Math.max((diameter1[0] + 1) / 2 + (diameter2[0] + 1) / 2 + 1, Math.max(diameter1[0], diameter2[0]));
	}

	private static int dfs(int u, int n, List<List<Integer>> adjList, final boolean[] d, int[] a) {
		// Our input is a connected tree.
		d[u] = true;
		int p1 = 0;
		int p2 = 0;
		for (int v : adjList.get(u)) {
			if (!d[v]) {
				final int p = dfs(v, n, adjList, d, a);
				if (p > p1) {
					p2 = p1;
					p1 = p;
				} else if (p > p2)
					p2 = p;
			}
		}
		a[0] = Math.max(a[0], p1 + p2);
		return p1 + 1;
	}

	private static List<List<Integer>> adjacencyList(int n, int[][] edges) {
		final List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] e : edges) {
			adjList.get(e[0]).add(e[1]);
			adjList.get(e[1]).add(e[0]);
		}
		return adjList;
	}
}
