package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class ZeroOneMatrix {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	ZeroOneMatrix() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] mat1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		final int[][] ans1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		assert Arrays.deepEquals(ans1, updateMatrix(mat1));

		final int[][] mat2 = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
		final int[][] ans2 = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 2, 1 } };
		assert Arrays.deepEquals(ans2, updateMatrix(mat2));
	}

	static int[][] updateMatrix(int[][] mat) {
		final int m = mat.length;
		final int n = mat[0].length;
		final int[][] grid = new int[m][n];
		final boolean[][] d = new boolean[m][n];
		final Queue<Vertex> q = new ArrayDeque<>();

		// init.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == 0) {
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
