package com.coding.challenge.bfs;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class FindTheSafestPathInGrid {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	private static final int INFTY = 10000000;

	FindTheSafestPathInGrid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<List<Integer>> grid1 = List.of(List.of(1, 0, 0), List.of(0, 0, 0), List.of(0, 0, 1));
		assert maximumSafenessFactor(grid1) == 0;

		final List<List<Integer>> grid2 = List.of(List.of(0, 0, 1), List.of(0, 0, 0), List.of(0, 0, 0));
		assert maximumSafenessFactor(grid2) == 2;

		final List<List<Integer>> grid3 = List.of(List.of(0, 0, 0, 1), List.of(0, 0, 0, 0), List.of(0, 0, 0, 0),
				List.of(1, 0, 0, 0));
		assert maximumSafenessFactor(grid3) == 2;
	}

	static int maximumSafenessFactor(List<List<Integer>> grid) {
		final int n = grid.size();
		// top-left
		final int[][] t1 = new int[n][n];
		t1[0][0] = grid.get(0).get(0) == 1 ? 0 : INFTY;
		for (int j = 1; j < n; j++)
			t1[0][j] = grid.get(0).get(j) == 1 ? 0 : t1[0][j - 1] + 1;

		for (int i = 1; i < n; i++)
			t1[i][0] = grid.get(i).get(0) == 1 ? 0 : t1[i - 1][0] + 1;

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (grid.get(i).get(j) == 1)
					t1[i][j] = 0;
				else
					t1[i][j] = Math.min(t1[i][j - 1], t1[i - 1][j]) + 1;
			}
		}

		// top-right
		final int[][] t2 = new int[n][n];
		t2[0][n - 1] = grid.get(0).get(n - 1) == 1 ? 0 : INFTY;
		for (int i = 1; i < n; i++)
			t2[i][n - 1] = grid.get(i).get(n - 1) == 1 ? 0 : t2[i - 1][n - 1] + 1;

		for (int j = n - 2; j >= 0; j--)
			t2[0][j] = grid.get(0).get(j) == 1 ? 0 : t2[0][j + 1] + 1;

		for (int i = 1; i < n; i++) {
			for (int j = n - 2; j >= 0; j--) {
				if (grid.get(i).get(j) == 1)
					t2[i][j] = 0;
				else
					t2[i][j] = Math.min(t2[i][j + 1], t2[i - 1][j]) + 1;
			}
		}

		// bottom-left.
		final int[][] t3 = new int[n][n];
		t3[n - 1][0] = grid.get(n - 1).get(0) == 1 ? 0 : INFTY;
		for (int i = n - 2; i >= 0; i--)
			t3[i][0] = grid.get(i).get(0) == 1 ? 0 : t3[i + 1][0] + 1;

		for (int j = 1; j < n; j++)
			t3[n - 1][j] = grid.get(n - 1).get(j) == 1 ? 0 : t3[n - 1][j - 1] + 1;

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 1; j < n; j++) {
				if (grid.get(i).get(j) == 1)
					t3[i][j] = 0;
				else
					t3[i][j] = Math.min(t3[i][j - 1], t3[i + 1][j]) + 1;
			}
		}

		// bottom-right
		final int[][] t4 = new int[n][n];
		t4[n - 1][n - 1] = grid.get(n - 1).get(n - 1) == 1 ? 0 : INFTY;
		for (int i = n - 2; i >= 0; i--)
			t4[i][n - 1] = grid.get(i).get(n - 1) == 1 ? 0 : t4[i + 1][n - 1] + 1;

		for (int j = n - 2; j >= 0; j--)
			t4[n - 1][j] = grid.get(n - 1).get(j) == 1 ? 0 : t4[n - 1][j + 1] + 1;

		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				if (grid.get(i).get(j) == 1)
					t4[i][j] = 0;
				else
					t4[i][j] = Math.min(t4[i + 1][j], t4[i][j + 1]) + 1;
			}
		}

		final int[][] t = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				t[i][j] = Math.min(Math.min(t1[i][j], t2[i][j]), Math.min(t3[i][j], t4[i][j]));

		// Now do the BFS.
		return bfs(t, n, n);
	}

	private static int bfs(int[][] t, int m, int n) {
		final boolean[][] d = new boolean[m][n];
		final Queue<Vertex> q = new PriorityQueue<>((a, b) -> Integer.compare(b.s, a.s));
		q.offer(new Vertex(0, 0, t[0][0]));
		d[0][0] = true;
		while (!q.isEmpty()) {
			final Vertex u = q.poll();
			if (u.i == m - 1 && u.j == n - 1)
				return u.s;

			for (int[] move : MOVES) {
				final int r = u.i + move[0];
				final int c = u.j + move[1];
				if (r >= 0 && r < m && c >= 0 && c < n && !d[r][c]) {
					d[r][c] = true;
					q.add(new Vertex(r, c, Math.min(u.s, t[r][c])));
				}
			}
		}
		// Can't get here.
		throw new AssertionError();
	}

	static class Vertex {
		final int i;
		final int j;
		final int s;

		Vertex(int i, int j, int s) {
			this.i = i;
			this.j = j;
			this.s = s;
		}
	}
}
