package com.coding.challenge.graph;

class FindChampionII {
	FindChampionII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] edges1 = { { 0, 1 }, { 1, 2 } };
		assert findChampion(3, edges1) == 0;

		final int[][] edges2 = { { 0, 2 }, { 1, 3 }, { 1, 2 } };
		assert findChampion(4, edges2) == -1;

		final int[][] edges3 = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
		assert findChampion(3, edges3) == 0;
	}

	static int findChampion(int n, int[][] edges) {
		final boolean[] w = new boolean[n];
		for (int[] e : edges)
			w[e[1]] = true;

		int champ = -1;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (!w[i]) {
				champ = i;
				cnt = cnt + 1;
			}
		}

		return cnt == 1 ? champ : -1;
	}
}
