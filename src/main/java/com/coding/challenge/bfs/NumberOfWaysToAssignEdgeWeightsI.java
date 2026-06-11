package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class NumberOfWaysToAssignEdgeWeightsI {
	private static final int REM = 1000000007;

	NumberOfWaysToAssignEdgeWeightsI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 1, 2 } };
		assert assignEdgeWeights(edges1) == 1;

		final int[][] edges2 = { { 1, 2 }, { 1, 3 }, { 3, 4 }, { 3, 5 } };
		assert assignEdgeWeights(edges2) == 2;

		final int[][] edges3 = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
		assert assignEdgeWeights(edges3) == 4;
	}

	static int assignEdgeWeights(int[][] edges) {
		final Map<Integer, Collection<Integer>> adjList = new HashMap<>();
		for (int[] e : edges) {
			adjList.computeIfAbsent(e[0], unused -> new ArrayList<>()).add(e[1]);
			adjList.computeIfAbsent(e[1], unused -> new ArrayList<>()).add(e[0]);
		}

		final Deque<Vertex> q = new ArrayDeque<>();
		final int n = edges.length + 1;
		final boolean[] d = new boolean[n + 1];
		int h = 0;
		d[1] = true;
		q.offer(new Vertex(1, 0));
		while (!q.isEmpty()) {
			final Vertex u = q.poll();
			for (int v : adjList.get(u.id)) {
				if (!d[v]) {
					h = u.d + 1;
					d[v] = true;
					q.offer(new Vertex(v, h));
				}
			}
		}

		int cnt = 1;
		for (int k = 2; k <= h; k++)
			cnt = (cnt + cnt) % REM;

		return cnt;
	}

	private static class Vertex {
		final int id;
		final int d;

		Vertex(int id, int d) {
			this.id = id;
			this.d = d;
		}
	}
}
