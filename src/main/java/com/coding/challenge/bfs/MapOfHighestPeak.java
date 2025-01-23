package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class MapOfHighestPeak {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	MapOfHighestPeak() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] w1 = { { 0, 1 }, { 0, 0 } };
		System.out.println(Arrays.deepToString(highestPeak(w1)));

		final int[][] w2 = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };
		System.out.println(Arrays.deepToString(highestPeak(w2)));
	}

	static int[][] highestPeak(int[][] isWater) {
		final int m = isWater.length;
		final int n = isWater[0].length;
		final int[][] grid = new int[m][n];
		final boolean[][] d = new boolean[m][n];
		final Queue<Vertex> q = new ArrayDeque<>();

		// init.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isWater[i][j] == 1) {
					d[i][j] = true;
					q.offer(new Vertex(i, j));
				}
			}
		}

		// bfs
		while (!q.isEmpty()) {
			final Vertex u = q.poll();
			for (int[] move : MOVES) {
				final int r = u.r + move[0];
				final int c = u.c + move[1];
				if (r >= 0 && r < m && c >= 0 && c < n && !d[r][c]) {
					d[r][c] = true;
					grid[r][c] = grid[u.r][u.c] + 1;
					q.add(new Vertex(r, c));
				}
			}
		}
		return grid;
	}

	private static class Vertex {
		private final int r;
		private final int c;

		private Vertex(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
