package com.coding.challenge.bfs;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class MaximumNumberOfPointsFromGridQueries {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	MaximumNumberOfPointsFromGridQueries() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 1, 2, 3 }, { 2, 5, 7 }, { 3, 5, 1 } };
		final int[] queries1 = { 5, 6, 2 };
		System.out.println(Arrays.toString(maxPoints(grid1, queries1)));

		final int[][] grid2 = { { 5, 2, 1 }, { 1, 1, 2 } };
		final int[] queries2 = { 3 };
		System.out.println(Arrays.toString(maxPoints(grid2, queries2)));
	}

	static int[] maxPoints(int[][] grid, int[] queries) {
		final int k = queries.length;
		final int[][] a = new int[k][2];
		for (int i = 0; i < k; i++)
			a[i] = new int[] { i, queries[i] };
		final int m = grid.length;
		final int n = grid[0].length;
		final boolean[][] d = new boolean[m][n];
		final Queue<Vertex> h = new PriorityQueue<>(
				(v1, v2) -> Integer.compare(grid[v1.row][v1.col], grid[v2.row][v2.col]));
		d[0][0] = true;
		Arrays.sort(a, (p, q) -> Integer.compare(p[1], q[1]));
		h.add(new Vertex(0, 0));
		final int[] ans = new int[k];
		for (int i = 0, points = 0; i < k; i++) {
			while (!h.isEmpty() && grid[h.peek().row][h.peek().col] < a[i][1]) {
				final Vertex u = h.remove();
				points = points + 1;
				for (int[] move : MOVES) {
					final int r = u.row + move[0];
					final int c = u.col + move[1];
					if (r >= 0 && r < m && c >= 0 && c < n && !d[r][c]) {
						d[r][c] = true;
						h.add(new Vertex(r, c));
					}
				}
			}

			ans[a[i][0]] = points;
		}
		return ans;
	}

	static class Vertex {
		private final int row;
		private final int col;

		Vertex(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
