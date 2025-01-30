package com.coding.challenge.disjoint.sets;

class DisjointSets {
	DisjointSets() {
		throw new AssertionError();
	}

	// Disjoint set operations are implemented here.
	static Node makeSet() {
		final Node x = new Node();
		x.p = x;
		x.rank = 0;
		return x;
	}

	static void union(Node x, Node y) {
		link(findSet(x), findSet(y));
	}

	static void link(Node x, Node y) {
		// union by rank heuristic.
		if (x.rank > y.rank)
			y.p = x;
		else {
			x.p = y;
			if (x.rank == y.rank)
				y.rank += 1;
		}
	}

	static Node findSet(Node x) {
		if (x != x.p)
			x.p = findSet(x.p);// Path compression.

		return x.p;
	}

	static class Node {
		private int rank;
		private Node p;
	}
}
