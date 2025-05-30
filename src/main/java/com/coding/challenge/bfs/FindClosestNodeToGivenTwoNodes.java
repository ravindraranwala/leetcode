package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

class FindClosestNodeToGivenTwoNodes {
	FindClosestNodeToGivenTwoNodes() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] edges1 = { 2, 2, 3, -1 };
		assert closestMeetingNode(edges1, 0, 1) == 2;

		final int[] edges2 = { 1, 2, -1 };
		assert closestMeetingNode(edges2, 0, 2) == 2;
	}

	static int closestMeetingNode(int[] edges, int node1, int node2) {
		final int[] d1 = bfs(edges, node1);
		final int[] d2 = bfs(edges, node2);
		final int n = edges.length;
		int v = 0;
		// minimizing the maximum distance between the nodes.
		for (int u = 1; u < n; u++)
			if (Math.max(d1[u], d2[u]) < Math.max(d1[v], d2[v]))
				v = u;

		return Math.max(d1[v], d2[v]) == Integer.MAX_VALUE ? -1 : v;
	}

	private static int[] bfs(int[] edges, int s) {
		final int n = edges.length;
		final int[] d = new int[n];
		final boolean[] seen = new boolean[n];
		final Queue<Integer> q = new ArrayDeque<>();
		for (int u = 0; u < n; u++)
			d[u] = Integer.MAX_VALUE;

		seen[s] = true;
		d[s] = 0;
		q.offer(s);

		while (!q.isEmpty()) {
			final int u = q.remove();
			final int v = edges[u];
			if (v != -1 && !seen[v]) {
				seen[v] = true;
				d[v] = d[u] + 1;
				q.offer(v);
			}
		}
		return d;
	}
}
