package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

class MaximumNumberOfK_DivisibleComponents {
	private int edgesRemoved = 0;

	MaximumNumberOfK_DivisibleComponents() {

	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 0, 2 }, { 1, 2 }, { 1, 3 }, { 2, 4 } };
		final int[] values1 = { 1, 8, 1, 4, 4 };
		assert new MaximumNumberOfK_DivisibleComponents().maxKDivisibleComponents(5, edges1, values1, 6) == 2;

		final int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 2, 5 }, { 2, 6 } };
		final int[] values2 = { 3, 0, 6, 1, 5, 2, 1 };
		assert new MaximumNumberOfK_DivisibleComponents().maxKDivisibleComponents(7, edges2, values2, 3) == 3;
	}

	int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
		final List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] e : edges) {
			adjList.get(e[0]).add(e[1]);
			adjList.get(e[1]).add(e[0]);
		}
		dfs(0, adjList, values, -1, k);
		return edgesRemoved + 1;
	}

	private int dfs(int u, List<List<Integer>> adjList, int[] values, int p, int k) {
		int rem = values[u] % k;
		for (int v : adjList.get(u)) {
			if (v != p) {
				final int childRem = dfs(v, adjList, values, u, k);
				if (childRem == 0)
					edgesRemoved = edgesRemoved + 1;
				rem = (rem + childRem) % k;
			}
		}
		return rem;
	}
}
