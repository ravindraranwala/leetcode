package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

class RemoveMethodsFromProject {
	RemoveMethodsFromProject() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] invocations1 = { { 1, 2 }, { 0, 1 }, { 3, 2 } };
		assert List.of(0, 1, 2, 3).equals(remainingMethods(4, 1, invocations1));

		final int[][] invocations2 = { { 1, 2 }, { 0, 2 }, { 0, 1 }, { 3, 4 } };
		assert List.of(3, 4).equals(remainingMethods(5, 0, invocations2));

		final int[][] invocations3 = { { 1, 2 }, { 0, 1 }, { 2, 0 } };
		assert remainingMethods(3, 2, invocations3).isEmpty();
	}

	static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
		final List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] edge : invocations)
			adjList.get(edge[0]).add(edge[1]);

		final boolean[] d = new boolean[n];
		dfs(adjList, d, k);
		boolean isRemovable = true;
		for (int[] edge : invocations)
			if (!d[edge[0]] && d[edge[1]])
				isRemovable = false;

		if (isRemovable) {
			final List<Integer> withRemoval = new ArrayList<>();
			for (int v = 0; v < n; v++)
				if (!d[v])
					withRemoval.add(v);

			return withRemoval;
		}

		final List<Integer> withoutRemoval = new ArrayList<>();
		for (int v = 0; v < n; v++)
			withoutRemoval.add(v);
		return withoutRemoval;
	}

	private static void dfs(List<List<Integer>> adjList, boolean[] d, int u) {
		d[u] = true;
		for (int v : adjList.get(u)) {
			if (!d[v])
				dfs(adjList, d, v);
		}
	}
}
