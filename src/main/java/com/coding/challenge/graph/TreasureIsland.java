package com.coding.challenge.graph;

import java.util.ArrayDeque;
import java.util.Queue;

class TreasureIsland {
	TreasureIsland() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[][] map1 = new char[][] { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' }, { 'O', 'O', 'O', 'O' },
				{ 'X', 'D', 'D', 'O' } };
		final char[][] map2 = new char[][] { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' }, { 'O', 'O', 'O', 'O' },
				{ 'O', 'D', 'D', 'O' }, { 'O', 'D', 'X', 'O' } };
		findTreasure(map2);
	}

	static void findTreasure(char[][] g) {
		final int rl = g.length;
		final int cl = g[0].length;
		final int[][] d = new int[rl][cl];
		for (int i = 0; i < rl; i++)
			for (int j = 0; j < cl; j++)
				d[i][j] = Integer.MAX_VALUE;
		final Queue<int[]> q = new ArrayDeque<>();
		final int[][] m = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
		int r = -1;
		int c = -1;

		q.add(new int[] { 0, 0 });
		d[0][0] = 0;
		while (!q.isEmpty()) {
			final int[] u = q.remove();
			for (int[] p : m) {
				final int i = u[0] + p[0];
				final int j = u[1] + p[1];
				// undiscovered valid position
				if (i >= 0 && i < rl && j >= 0 && j < cl && d[i][j] == Integer.MAX_VALUE && g[i][j] != 'D') {
					// record the treasure location.
					if (g[i][j] == 'X') {
						r = i;
						c = j;
					}
					d[i][j] = d[u[0]][u[1]] + 1;
					q.add(new int[] { i, j });
				}

			}
		}
		if (r == -1 && c == -1)
			throw new IllegalArgumentException("Treasure doesn't exist or is not reachable.");
		System.out.println(String.format("The minimum route takes %d steps.", d[r][c]));
		printPath(d, r, c, m);
	}

	static void printPath(int[][] d, int i, int j, int[][] m) {
		if (i == 0 && j == 0)
			System.out.println(String.format("(%d, %d)", i, j));
		else {
			int r = -1;
			int c = -1;
			int s = Integer.MAX_VALUE;
			for (int[] p : m) {
				final int k = i + p[0];
				final int l = j + p[1];
				if (k >= 0 && k < d.length && l >= 0 && l < d[0].length && d[k][l] < s) {
					r = k;
					c = l;
					s = d[k][l];
				}
			}

			if (r == -1 && c == -1)
				System.out.println("path doesn't exist");
			else {
				printPath(d, r, c, m);
				System.out.println(String.format("(%d, %d)", i, j));
			}

		}
	}
}
