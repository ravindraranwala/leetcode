package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SumOfDistancesInTree {
	SumOfDistancesInTree() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } };
		final int[] dist1 = { 8, 12, 6, 10, 10, 10 };
		assert Arrays.equals(dist1, sumOfDistancesInTree(6, edges1));

		assert Arrays.equals(new int[1], sumOfDistancesInTree(1, new int[0][0]));

		final int[][] edges2 = { { 1, 0 } };
		final int[] dist2 = { 1, 1 };
		assert Arrays.equals(dist2, sumOfDistancesInTree(2, edges2));
	}

	static int[] sumOfDistancesInTree(int n, int[][] edges) {
		final List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] e : edges) {
			adjList.get(e[0]).add(e[1]);
			adjList.get(e[1]).add(e[0]);
		}

		final int[] childCnt = new int[n];
		final int[] sumDist = new int[n];
		dfs(0, new boolean[n], adjList, 0, childCnt, sumDist);
		final boolean[] d = new boolean[n];
		d[0] = true;
		for (int u : adjList.get(0))
			nodeSumDistance(u, d, adjList, sumDist, childCnt, 0, n);

		return sumDist;
	}

	private static void nodeSumDistance(int u, boolean[] d, List<List<Integer>> adjList, int[] s, int[] children,
			int p, int n) {
		d[u] = true;
		s[u] = s[p] - children[u] + n - 2 - children[u];
		for (int v : adjList.get(u))
			if (!d[v])
				nodeSumDistance(v, d, adjList, s, children, u, n);
	}

	private static int dfs(int u, boolean[] d, List<List<Integer>> adjList, int currDist, int[] childCnt, int[] s) {
		d[u] = true;
		s[0] = s[0] + currDist;
		for (int v : adjList.get(u))
			if (!d[v])
				childCnt[u] = childCnt[u] + dfs(v, d, adjList, currDist + 1, childCnt, s);
		return childCnt[u] + 1;
	}
}
