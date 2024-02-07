package com.coding.challenge.disjoint.sets;

import java.util.Arrays;

import com.coding.challenge.disjoint.sets.MSTKruskal.Edge;
import com.coding.challenge.disjoint.sets.MSTKruskal.Node;

class RedundantConnection {
	RedundantConnection() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
		final int[] edge1 = { 2, 3 };
		assert Arrays.equals(edge1, findRedundantConnection(edges1));

		final int[][] edges2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
		final int[] edge2 = { 1, 4 };
		assert Arrays.equals(edge2, findRedundantConnection(edges2));
	}

	static int[] findRedundantConnection(int[][] edges) {
		final int n = edges.length;
		final Edge[] connections = new Edge[n];
		for (int i = 0; i < n; i++)
			connections[i] = new Edge(edges[i][0], edges[i][1], 1);
		return mstKruskal(n, connections);
	}

	static int[] mstKruskal(int n, Edge[] edges) {
		final Node[] vertices = new Node[n + 1];

		for (int i = 1; i <= n; i++) {
			vertices[i] = new Node();
			MSTKruskal.makeSet(vertices[i]);
		}
		// No sorting of edges are required, they all have a unit edge weight.
		for (Edge edge : edges) {
			final Node u = vertices[edge.source];
			final Node v = vertices[edge.target];
			if (MSTKruskal.findSet(u) != MSTKruskal.findSet(v))
				MSTKruskal.union(u, v);
			else
				return new int[] { edge.source, edge.target };
		}
		// No redundant connections exist.
		return new int[0];
	}
}
