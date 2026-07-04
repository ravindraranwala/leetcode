package com.coding.challenge.bfs;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class FindSafeWalkThroughGrid {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	FindSafeWalkThroughGrid() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		List<List<Integer>> grid1 = List.of(List.of(0, 1, 0, 0, 0), List.of(0, 1, 0, 1, 0), List.of(0, 0, 0, 1, 0));
		assert findSafeWalk(grid1, 1);

		List<List<Integer>> grid2 = List.of(List.of(0, 1, 1, 0, 0, 0), List.of(1, 0, 1, 0, 0, 0),
				List.of(0, 1, 1, 1, 0, 1), List.of(0, 0, 1, 0, 1, 0));
		assert !findSafeWalk(grid2, 3);

		List<List<Integer>> grid3 = List.of(List.of(1, 1, 1), List.of(1, 0, 1), List.of(1, 1, 1));
		assert findSafeWalk(grid3, 5);
	}

	static boolean findSafeWalk(List<List<Integer>> grid, int health) {
		final int m = grid.size();
		final int n = grid.get(0).size();
		final boolean[][] d = new boolean[m][n];
		final Queue<Vertex> q = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
		q.offer(new Vertex(0, 0, grid.get(0).get(0)));
		d[0][0] = true;
		while (!q.isEmpty()) {
			final Vertex u = q.poll();
			if (u.i == m - 1 && u.j == n - 1)
				return health - u.w > 0;

			for (int[] move : MOVES) {
				final int r = u.i + move[0];
				final int c = u.j + move[1];
				if (r >= 0 && r < m && c >= 0 && c < n && !d[r][c]) {
					d[r][c] = true;
					q.add(new Vertex(r, c, u.w + grid.get(r).get(c)));
				}
			}
		}
		// Can't get here.
		throw new AssertionError();
	}

	static class Vertex {
		final int i;
		final int j;
		final int w;

		Vertex(int i, int j, int s) {
			this.i = i;
			this.j = j;
			this.w = s;
		}
	}
}
