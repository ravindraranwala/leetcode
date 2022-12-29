package com.coding.challenge.dfs;

class CountProvinces {
	CountProvinces() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] isConnectedOne = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		assert findCircleNum(isConnectedOne) == 2;

		final int[][] isConnectedTwo = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		assert findCircleNum(isConnectedTwo) == 3;
	}

	static int findCircleNum(int[][] isConnected) {
		final int n = isConnected.length;
		final boolean[] d = new boolean[n];
		int c = 0;
		for (int i = 0; i < n; i++) {
			if (d[i] == false) {
				provinceVisit(isConnected, d, i);
				c = c + 1;
			}
		}
		return c;
	}

	static void provinceVisit(int[][] isConnected, boolean[] d, int i) {
		d[i] = true;
		final int n = isConnected.length;
		for (int j = 0; j < n; j++)
			if (i != j && isConnected[i][j] == 1 && d[j] == false)
				provinceVisit(isConnected, d, j);
	}
}
