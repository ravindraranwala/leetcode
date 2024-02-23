package com.coding.challenge.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAllGroupsOfFarmland {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	FindAllGroupsOfFarmland() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] land1 = { { 1, 0, 0 }, { 0, 1, 1 }, { 0, 1, 1 } };
		System.out.println(Arrays.deepToString(findFarmland(land1)));

		final int[][] land2 = { { 1, 1 }, { 1, 1 } };
		System.out.println(Arrays.deepToString(findFarmland(land2)));

		final int[][] land3 = { { 0 } };
		System.out.println(Arrays.deepToString(findFarmland(land3)));
	}

	static int[][] findFarmland(int[][] land) {
		final int m = land.length;
		final int n = land[0].length;
		final boolean[][] d = new boolean[m][n];
		final List<int[]> landCoordinates = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (land[i][j] == 1 && !d[i][j]) {
					final int[] bottomRightCoord = new int[2];
					visitGraph(land, i, j, d, bottomRightCoord);
					landCoordinates.add(new int[] { i, j, bottomRightCoord[0], bottomRightCoord[1] });
				}
			}
		}

		return landCoordinates.toArray(new int[0][0]);
	}

	private static void visitGraph(int[][] land, int i, int j, boolean[][] d, int[] bottomRightCoord) {
		d[i][j] = true;
		if (i > bottomRightCoord[0] || j > bottomRightCoord[1]) {
			bottomRightCoord[0] = i;
			bottomRightCoord[1] = j;
		}
		for (int[] m : MOVES) {
			final int r = i + m[0];
			final int c = j + m[1];
			if (r >= 0 && r < land.length && c >= 0 && c < land[0].length && land[r][c] == 1 && !d[r][c])
				visitGraph(land, r, c, d, bottomRightCoord);

		}
	}
}
