package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
		final int u1 = bfs(0, n, adjList1).id;
		final int diameter1 = bfs(u1, n, adjList1).d;

		final int m = edges2.length + 1;
		final List<List<Integer>> adjList2 = adjacencyList(m, edges2);
		final int u2 = bfs(0, m, adjList2).id;
		final int diametrer2 = bfs(u2, m, adjList2).d;

		return Math.max((diameter1 + 1) / 2 + (diametrer2 + 1) / 2 + 1, Math.max(diameter1, diametrer2));
	}

	private static Vertex bfs(int s, int n, List<List<Integer>> adjList) {
		final boolean[] d = new boolean[n];
		final Deque<Vertex> q = new ArrayDeque<>();
		q.offer(new Vertex(s, 0));
		d[s] = true;
		int vtx = s;
		int dist = 0;

		while (!q.isEmpty()) {
			final Vertex u = q.poll();
			for (int v : adjList.get(u.id)) {
				if (!d[v]) {
					d[v] = true;
					q.offer(new Vertex(v, u.d + 1));
					vtx = v;
					dist = u.d + 1;
				}
			}
		}

		return new Vertex(vtx, dist);
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

	private static class Vertex {
		private final int id;
		private final int d;

		private Vertex(int id, int d) {
			super();
			this.id = id;
			this.d = d;
		}
	}
}
