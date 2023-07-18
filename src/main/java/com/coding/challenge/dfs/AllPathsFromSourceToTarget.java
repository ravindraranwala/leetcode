package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AllPathsFromSourceToTarget {
	AllPathsFromSourceToTarget() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] graphOne = { { 1, 2 }, { 3 }, { 3 }, {} };
		System.out.println(allPathsSourceTarget(graphOne));

		final int[][] graphTwo = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
		System.out.println(allPathsSourceTarget(graphTwo));
	}

	static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		final int n = graph.length;
		final List<List<Integer>> paths = visitDag(graph, n - 1, 0);
		for (List<Integer> p : paths)
			Collections.reverse(p);
		return paths;
	}

	static List<List<Integer>> visitDag(int[][] graph, int t, int i) {
		if (i == t) {
			final List<Integer> l = new ArrayList<>();
			l.add(i);
			return Collections.singletonList(l);
		}

		final List<List<Integer>> paths = new ArrayList<>();
		for (int j : graph[i]) {
			final List<List<Integer>> pathsStartWithJ = visitDag(graph, t, j);
			for (List<Integer> p : pathsStartWithJ) {
				if (!p.isEmpty() && p.get(0) == t) {
					p.add(i);
					paths.add(p);
				}
			}
		}
		return paths;
	}
}
