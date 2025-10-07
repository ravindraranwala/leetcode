package com.coding.challenge.bfs;

import java.util.PriorityQueue;
import java.util.Queue;

class SwimInRisingWater {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	SwimInRisingWater() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] grid1 = { { 0, 2 }, { 1, 3 } };
		assert swimInWater(grid1) == 3;

		final int[][] grid2 = { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 },
				{ 11, 17, 18, 19, 20 }, { 10, 9, 8, 7, 6 } };
		assert swimInWater(grid2) == 16;

		final int[][] grid3 = { { 0 } };
		assert swimInWater(grid3) == 0;
	}

	static int swimInWater(int[][] grid) {
		final int n = grid.length;
		final boolean[][] d = new boolean[n][n];
		final Queue<Square> h = new PriorityQueue<>((a, b) -> Integer.compare(a.t, b.t));
		h.add(new Square(0, 0, grid[0][0]));
		d[0][0] = true;

		while (!h.isEmpty()) {
			final Square u = h.remove();
			for (int[] move : MOVES) {
				final int r = u.row + move[0];
				final int c = u.col + move[1];
				if (r >= 0 && r < n && c >= 0 && c < n && !d[r][c]) {
					d[r][c] = true;
					final int minTime = Math.max(u.t, grid[r][c]);
					if (r == n - 1 && c == n - 1)
						return minTime;

					h.add(new Square(r, c, minTime));
				}
			}
		}
		return grid[0][0];
	}

	static class Square {
		private final int row;
		private final int col;
		private final int t;

		Square(int r, int c, int t) {

			this.row = r;
			this.col = c;
			this.t = t;
		}
	}
}
