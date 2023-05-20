package com.coding.challenge.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MakingLargeIsland {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	MakingLargeIsland() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] gridOne = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
		assert largestIsland(gridOne) == 12;

		final int[][] gridTwo = { { 1, 0 }, { 0, 1 } };
		assert largestIsland(gridTwo) == 3;

		final int[][] gridThree = { { 1, 1 }, { 1, 0 } };
		assert largestIsland(gridThree) == 4;

		final int[][] gridFour = { { 1, 1 }, { 1, 1 } };
		assert largestIsland(gridFour) == 4;
	}

	static int largestIsland(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final int[][] cluster = new int[m + 2][n + 2];
		final Map<Integer, Integer> clusterArea = new HashMap<>();
		// sentinel value.
		clusterArea.put(0, 0);
		int size = 0;

		// DFS comes first.
		for (int i = 0, id = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && cluster[i + 1][j + 1] == 0) {
					id = id + 1;
					final int area = visitGrid(grid, cluster, i, j, id);
					size = Math.max(size, area);
					clusterArea.put(id, area);
				}
			}
		}

		// dynamic programming solution.
		for (int k = 1; k <= m; k++) {
			for (int l = 1; l <= n; l++) {
				if (grid[k - 1][l - 1] == 0) {
					final Set<Integer> clusterIds = new HashSet<>();
					int ans = 1;
					for (int[] move : MOVES) {
						final int r = k + move[0];
						final int c = l + move[1];
						final int id = cluster[r][c];
						if (clusterIds.add(id))
							ans = ans + clusterArea.get(id);
					}
					size = Math.max(size, ans);
				}
			}
		}
		return size;
	}

	static int visitGrid(int[][] grid, int[][] cluster, int i, int j, int id) {
		final int m = grid.length;
		final int n = grid[0].length;
		cluster[i + 1][j + 1] = id;
		int count = 1;
		for (int[] move : MOVES) {
			final int r = i + move[0];
			final int c = j + move[1];
			// check if the block is undiscovered first.
			if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1 && cluster[r + 1][c + 1] == 0)
				count = count + visitGrid(grid, cluster, r, c, id);
		}
		return count;
	}
}
