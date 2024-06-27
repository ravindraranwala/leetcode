package com.coding.challenge.graph;

class FindCenterOfStarGraph {
	FindCenterOfStarGraph() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 1, 2 }, { 2, 3 }, { 4, 2 } };
		assert findCenter(edges1) == 2;

		final int[][] edges3 = { { 1, 2 }, { 5, 1 }, { 1, 3 }, { 1, 4 } };
		assert findCenter(edges3) == 1;
	}

	static int findCenter(int[][] edges) {
		final int u = edges[0][0];
		final int v = edges[0][1];

		if (u == edges[1][0] || u == edges[1][1])
			return u;
		return v;
	}
}
