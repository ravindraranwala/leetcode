package com.coding.challenge.dijkstras;

import java.util.ArrayList;
import java.util.List;

import com.coding.challenge.dijkstras.PriorityQueue.Vertex;

class CityWithSmallestNumOfNeighborsAtThresholdDistance {
	CityWithSmallestNumOfNeighborsAtThresholdDistance() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
		System.out.println(findTheCityOptimized(4, edges1, 4));

		final int[][] edges2 = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
		System.out.println(findTheCityOptimized(5, edges2, 2));

		final int[][] edges3 = { { 0, 3, 7 }, { 2, 4, 1 }, { 0, 1, 5 }, { 2, 3, 10 }, { 1, 3, 6 }, { 1, 2, 1 } };
		System.out.println(findTheCityOptimized(6, edges3, 417));
	}

	static int findTheCityOptimized(int n, int[][] edges, int distanceThreshold) {
		// First create the adjacency list.
		final List<List<Vertex>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] edge : edges) {
			adjList.get(edge[0]).add(new Vertex(edge[1], edge[2]));
			adjList.get(edge[1]).add(new Vertex(edge[0], edge[2]));
		}

		int city = -1;
		int neighbours = Integer.MAX_VALUE;

		for (int s = 0; s < n; s++) {
			final int[] d = dijkstrasArray(s, n, adjList);

			int c = 0;
			for (int dist : d)
				if (dist <= distanceThreshold)
					c = c + 1;

			if (c <= neighbours) {
				city = s;
				neighbours = c;
			}

		}

		return city;
	}

	static int findTheCity(int n, int[][] edges, int distanceThreshold) {
		// First create the adjacency list.
		final List<List<Vertex>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int[] edge : edges) {
			adjList.get(edge[0]).add(new Vertex(edge[1], edge[2]));
			adjList.get(edge[1]).add(new Vertex(edge[0], edge[2]));
		}

		int city = -1;
		int neighbours = Integer.MAX_VALUE;

		for (int s = 0; s < n; s++) {
			final int[] d = dijkstras(s, n, adjList);

			int c = 0;
			for (int dist : d)
				if (dist <= distanceThreshold)
					c = c + 1;

			if (c <= neighbours) {
				city = s;
				neighbours = c;
			}

		}

		return city;
	}

	private static int[] dijkstrasArray(int s, int n, List<List<Vertex>> adjList) {
		// init.
		final int[] d = new int[n + 1];
		for (int i = 0; i <= n; i++)
			d[i] = Integer.MAX_VALUE;
		d[s] = 0;
		final boolean[] solved = new boolean[n];
		int rem = n;

		while (rem > 0) {
			int u = n;
			for (int i = 0; i < n; i++)
				if (!solved[i] && d[i] <= d[u])
					u = i;
			rem = rem - 1;
			solved[u] = true;
			if (d[u] != Integer.MAX_VALUE) {
				for (Vertex v : adjList.get(u)) {
					// edge relaxation step.
					if (d[v.id] > d[u] + v.distance)
						// implicit decrease key operation.
						d[v.id] = d[u] + v.distance;
				}
			}
		}
		return d;
	}

	private static int[] dijkstras(int s, int n, List<List<Vertex>> adjList) {
		// init.
		final int[] d = new int[n];
		for (int i = 0; i < n; i++)
			d[i] = Integer.MAX_VALUE;
		d[s] = 0;
		final PriorityQueue h = new PriorityQueue();
		for (int i = 0; i < n; i++)
			h.insert(new Vertex(i, d[i]));

		while (!h.isEmpty()) {
			final Vertex u = h.extractMin();
			for (Vertex v : adjList.get(u.id)) {
				// edge relaxation step.
				if (d[u.id] != Integer.MAX_VALUE && d[v.id] > d[u.id] + v.distance) {
					d[v.id] = d[u.id] + v.distance;
					h.decreaseKey(v.id, d[v.id]);
				}
			}
		}
		return d;
	}
}
