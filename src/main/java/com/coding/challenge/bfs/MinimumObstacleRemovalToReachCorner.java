package com.coding.challenge.bfs;

import java.util.PriorityQueue;

class MinimumObstacleRemovalToReachCorner {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	MinimumObstacleRemovalToReachCorner() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 0, 1, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		assert minimumObstacles(grid1) == 2;

		final int[][] grid2 = { { 0, 1, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 1, 0 } };
		assert minimumObstacles(grid2) == 0;
	}

	static int minimumObstacles(int[][] grid) {
		final int m = grid.length;
		final int n = grid[0].length;
		final boolean[][] d = new boolean[m][n];
		final PriorityQueue<Vertex> h = new PriorityQueue<>((v1, v2) -> Integer.compare(v1.obstacles, v2.obstacles));
		d[0][0] = true;
		h.add(new Vertex(0, 0, 0));

		while (!h.isEmpty()) {
			final Vertex u = h.remove();
			for (int[] move : MOVES) {
				final int r = u.r + move[0];
				final int c = u.c + move[1];
				if (r >= 0 && r < m && c >= 0 && c < n && !d[r][c]) {
					if (r == m - 1 && c == n - 1)
						return u.obstacles + grid[r][c];
					d[r][c] = true;
					h.add(new Vertex(r, c, u.obstacles + grid[r][c]));
				}
			}
		}
		// Can't get here.
		throw new AssertionError();
	}

	private static class Vertex {
		private final int r;
		private final int c;
		private final int obstacles;

		private Vertex(int r, int c, int obstacles) {
			this.r = r;
			this.c = c;
			this.obstacles = obstacles;
		}
	}
}
