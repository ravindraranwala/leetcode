package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

class FindIfPathExistsInGraph {
	FindIfPathExistsInGraph() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
		assert validPath(3, edges1, 0, 2);

		final int[][] edges2 = { { 0, 1 }, { 0, 2 }, { 3, 5 }, { 5, 4 }, { 4, 3 } };
		assert !validPath(6, edges2, 0, 5);
	}

	static boolean validPath(int n, int[][] edges, int source, int destination) {
		final List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] e : edges) {
			adjList.get(e[0]).add(e[1]);
			adjList.get(e[1]).add(e[0]);
		}

		return dfs(source, destination, adjList, new boolean[n], source);
	}

	private static boolean dfs(int source, int destination, List<List<Integer>> adjList, boolean[] d, int i) {
		d[i] = true;
		if (i == destination)
			return true;

		boolean found = false;
		for (int k : adjList.get(i))
			if (!d[k])
				found = found || dfs(source, destination, adjList, d, k);

		return found;
	}
}
