package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MinimumTimeToCollectAllApplesInTree {
	private int time = 0;

	MinimumTimeToCollectAllApplesInTree() {

	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
		assert new MinimumTimeToCollectAllApplesInTree().minTime(7, edges1,
				Arrays.asList(false, false, true, false, true, true, false)) == 8;

		assert new MinimumTimeToCollectAllApplesInTree().minTime(7, edges1,
				Arrays.asList(false, false, true, false, false, true, false)) == 6;

		assert new MinimumTimeToCollectAllApplesInTree().minTime(7, edges1,
				Arrays.asList(false, false, false, false, false, false, false)) == 0;

		final int[][] edges2 = { { 0, 2 }, { 0, 3 }, { 1, 2 } };
		assert new MinimumTimeToCollectAllApplesInTree().minTime(4, edges2,
				Arrays.asList(false, true, false, false)) == 4;

		assert new MinimumTimeToCollectAllApplesInTree().minTime(4, new int[0][0], Arrays.asList(true)) == 0;
	}

	int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		final Map<Integer, List<Integer>> adjList = new HashMap<>();
		for (int[] edge : edges) {
			adjList.computeIfAbsent(edge[0], unused -> new ArrayList<>()).add(edge[1]);
			adjList.computeIfAbsent(edge[1], unused -> new ArrayList<>()).add(edge[0]);
		}

		visitTree(hasApple, adjList, 0, new boolean[n]);
		return time;
	}

	private boolean visitTree(List<Boolean> hasApple, Map<Integer, List<Integer>> adjList, int k, boolean[] d) {
		d[k] = true;
		boolean ans = hasApple.get(k);
		for (int child : adjList.getOrDefault(k, Collections.emptyList())) {
			if (!d[child]) {
				final boolean found = visitTree(hasApple, adjList, child, d);
				if (found)
					time = time + 2;
				ans = ans || found;
			}
		}
		return ans;
	}
}
