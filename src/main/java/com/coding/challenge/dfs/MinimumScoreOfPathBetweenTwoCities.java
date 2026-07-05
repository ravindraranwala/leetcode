package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.List;

class MinimumScoreOfPathBetweenTwoCities {
	MinimumScoreOfPathBetweenTwoCities() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] roads1 = { { 1, 2, 9 }, { 2, 3, 6 }, { 2, 4, 5 }, { 1, 4, 7 } };
		assert minScore(4, roads1) == 5;

		final int[][] roads2 = { { 1, 2, 2 }, { 1, 3, 4 }, { 3, 4, 7 } };
		assert minScore(4, roads2) == 2;

		final int[][] roads3 = { { 1, 2, 5 }, { 2, 3, 7 }, { 3, 1, 1 } };
		assert minScore(3, roads3) == 1;
	}

	static int minScore(int n, int[][] roads) {
		final List<List<Vertex>> adjList = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			adjList.add(new ArrayList<>());

		for (int[] edge : roads) {
			adjList.get(edge[0]).add(new Vertex(edge[1], edge[2]));
			adjList.get(edge[1]).add(new Vertex(edge[0], edge[2]));
		}
		return dfs(adjList, new boolean[n + 1], 1);
	}

	private static int dfs(List<List<Vertex>> adjList, boolean[] d, int u) {
		d[u] = true;
		int minWeight = Integer.MAX_VALUE;

		for (Vertex v : adjList.get(u)) {
			minWeight = Math.min(minWeight, v.w);
			if (!d[v.id])
				minWeight = Math.min(minWeight, dfs(adjList, d, v.id));
		}
		return minWeight;
	}

	static class Vertex {
		final int id;
		final int w;

		Vertex(int id, int w) {
			this.id = id;
			this.w = w;
		}
	}
}
