package com.coding.challenge.kruskal;

import java.util.Arrays;
import java.util.Comparator;

public class MSTKruskal {

	public static void main(String[] args) {
		// Min Cost to Connect All Nodes (Minimum Spanning Tree I)
		int n = 6;
		int[][] edges = new int[][] { { 1, 4 }, { 4, 5 }, { 2, 3 } };
		int[][] newEdges = { { 1, 2, 5 }, { 1, 3, 10 }, { 1, 6, 2 }, { 5, 6, 5 } };
		int cost = minCostToConnectAllNodes(n, edges, newEdges);

		System.out.println(String.format("Min Cost to Connect All Nodes: %d", cost));
	}

	private static int minCostToConnectAllNodes(int n, int[][] edges, int[][] newEdges) {
		final int newEdgesLen = newEdges.length;
		int edgesLen = edges.length;
		int[][] weightedEdges = new int[edgesLen + newEdgesLen][3];
		System.arraycopy(newEdges, 0, weightedEdges, 0, newEdgesLen);
		for (int i = 0; i < edgesLen; i++)
			weightedEdges[i + newEdgesLen] = new int[] { edges[i][0], edges[i][1], 0 };

		return mstKruskal(n, weightedEdges);
	}

	private static int mstKruskal(int n, int[][] edges) {
		Node[] vertices = new Node[n + 1];

		for (int i = 1; i <= n; i++) {
			vertices[i] = new Node();
			makeSet(vertices[i]);
		}

		// Sort the edges of G.E into nondecreasing order by weight w.
		Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

		int cost = 0;
		for (int[] edge : edges) {
			Node u = vertices[edge[0]];
			Node v = vertices[edge[1]];
			if (findSet(u) != findSet(v)) {
				cost += edge[2]; // A safe, light edge is found. This becomes a part of our MST.
				union(u, v);
			}
		}
		return cost;
	}

	// Disjoint set operations are implemented here.
	private static void makeSet(Node x) {
		x.p = x;
		x.rank = 0;
	}

	private static void union(Node x, Node y) {
		link(findSet(x), findSet(y));
	}

	private static void link(Node x, Node y) {
		// union by rank heuristic.
		if (x.rank > y.rank)
			y.p = x;
		else {
			x.p = y;
			if (x.rank == y.rank)
				y.rank += 1;
		}
	}

	private static Node findSet(Node x) {
		if (x != x.p)
			x.p = findSet(x.p);// Path compression.

		return x.p;
	}

	static class Node {
		private int rank;
		private Node p;
	}
}
