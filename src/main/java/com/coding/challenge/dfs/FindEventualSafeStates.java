package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindEventualSafeStates {
	FindEventualSafeStates() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] graph1 = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
		assert Arrays.asList(2, 4, 5, 6).equals(eventualSafeNodes(graph1));

		final int[][] graph2 = { { 1, 2, 3, 4 }, { 1, 2 }, { 3, 4 }, { 0, 4 }, {} };
		assert Arrays.asList(4).equals(eventualSafeNodes(graph2));

		final int[][] graph3 = { { 1, 2 }, { 2 }, {} };
		assert Arrays.asList(0, 1, 2).equals(eventualSafeNodes(graph3));
	}

	static List<Integer> eventualSafeNodes(int[][] graph) {
		final int n = graph.length;
		final Color[] color = new Color[n];
		final boolean[] safe = new boolean[n];
		// init.
		for (int u = 0; u < n; u++) {
			color[u] = Color.WHITE;
			safe[u] = true;
		}

		for (int u = 0; u < n; u++)
			if (color[u] == Color.WHITE)
				dfsVisit(graph, u, color, safe);

		final List<Integer> l = new ArrayList<>();
		for (int u = 0; u < n; u++)
			if (safe[u])
				l.add(u);

		return l;
	}

	private static void dfsVisit(int[][] graph, int u, Color[] color, boolean[] safe) {
		color[u] = Color.GRAY;
		for (int v : graph[u]) {
			if (color[v] == Color.WHITE) {
				dfsVisit(graph, v, color, safe);
				if (!safe[v])
					safe[u] = false;
			} else if (color[v] == Color.GRAY)
				safe[u] = false;
			else if (!safe[v])
				safe[u] = false;
		}
		color[u] = Color.BLACK;
	}

	private static enum Color {
		WHITE, GRAY, BLACK;
	}
}
