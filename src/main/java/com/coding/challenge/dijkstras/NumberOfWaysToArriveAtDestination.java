package com.coding.challenge.dijkstras;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge.dijkstras.PriorityQueueLong.Vertex;

class NumberOfWaysToArriveAtDestination {
	NumberOfWaysToArriveAtDestination() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] roads1 = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 },
				{ 6, 5, 1 }, { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
		assert countPaths(7, roads1) == 4;

		final int[][] roads2 = { { 1, 0, 10 } };
		assert countPaths(2, roads2) == 1;
	}

	static int countPaths(int n, int[][] roads) {
		// First create the adjacency list.
		final List<List<Vertex>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] edge : roads) {
			adjList.get(edge[0]).add(new Vertex(edge[1], edge[2]));
			adjList.get(edge[1]).add(new Vertex(edge[0], edge[2]));
		}
		return dijkstrasArray(0, n, adjList);
	}

	private static int dijkstrasArray(int s, int n, List<List<Vertex>> adjList) {
		// init.
		final long[] d = new long[n + 1];
		final int[] p = new int[n];
		for (int i = 0; i <= n; i++)
			d[i] = Long.MAX_VALUE;
		d[s] = 0;
		p[s] = 1;
		final boolean[] solved = new boolean[n];

		for (int k = 0; k < n; k++) {
			int u = n;
			for (int i = 0; i < n; i++)
				if (!solved[i] && d[i] < d[u])
					u = i;
			solved[u] = true;
			for (Vertex v : adjList.get(u)) {
				// edge relaxation step.
				if (d[v.id] > d[u] + v.distance) {
					// implicit decrease key operation.
					d[v.id] = d[u] + v.distance;
					p[v.id] = p[u];
				} else if (d[v.id] == d[u] + v.distance)
					p[v.id] = (p[v.id] + p[u]) % 1000000007;
			}
		}
		return p[n - 1];
	}

	private static int dijkstras(int s, int n, List<List<Vertex>> adjList) {
		// init.
		final long[] d = new long[n];
		final int[] p = new int[n];
		for (int i = 0; i < n; i++)
			d[i] = Long.MAX_VALUE;
		d[s] = 0;
		p[s] = 1;
		final PriorityQueueLong h = new PriorityQueueLong();
		for (int i = 0; i < n; i++)
			h.insert(new Vertex(i, d[i]));

		while (!h.isEmpty()) {
			final Vertex u = h.extractMin();
			for (Vertex v : adjList.get(u.id)) {
				// edge relaxation step.
				if (d[v.id] > d[u.id] + v.distance) {
					d[v.id] = d[u.id] + v.distance;
					h.decreaseKey(v.id, d[v.id]);
					p[v.id] = p[u.id];
				} else if (d[v.id] == d[u.id] + v.distance)
					p[v.id] = (p[v.id] + p[u.id]) % 1000000007;
			}
		}
		return p[n - 1];
	}
}
