package com.coding.challenge.disjoint.sets;

import java.util.Arrays;

import com.coding.challenge.disjoint.sets.DisjointSets.Node;

class RedundantConnection {
	RedundantConnection() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		assert Arrays.equals(edges1[2], findRedundantConnection(edges1));

		final int[][] edges2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
		assert Arrays.equals(edges2[3], findRedundantConnection(edges2));
	}

	static int[] findRedundantConnection(int[][] edges) {
		final int n = edges.length;
		final Node[] a = new Node[n + 1];
		for (int v = 1; v <= n; v++)
			a[v] = DisjointSets.makeSet();

		for (int[] e : edges) {
			final Node u = a[e[0]];
			final Node v = a[e[1]];
			if (DisjointSets.findSet(u) == DisjointSets.findSet(v))
				return e;

			DisjointSets.union(u, v);
		}
		throw new AssertionError();
	}

}
