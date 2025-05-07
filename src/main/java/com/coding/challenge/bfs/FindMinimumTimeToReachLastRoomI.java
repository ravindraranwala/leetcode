package com.coding.challenge.bfs;

import java.util.PriorityQueue;
import java.util.Queue;

class FindMinimumTimeToReachLastRoomI {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	FindMinimumTimeToReachLastRoomI() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] moveTimeOne = { { 0, 4 }, { 4, 4 } };
		assert minTimeToReach(moveTimeOne) == 6;

		final int[][] moveTimeTwo = { { 0, 0, 0 }, { 0, 0, 0 } };
		assert minTimeToReach(moveTimeTwo) == 3;

		final int[][] moveTimeThree = { { 0, 1 }, { 1, 2 } };
		assert minTimeToReach(moveTimeThree) == 3;

		final int[][] moveTimeFour = { { 56, 93 }, { 3, 38 } };
		assert minTimeToReach(moveTimeFour) == 39;
	}

	static int minTimeToReach(int[][] moveTime) {
		final int m = moveTime.length;
		final int n = moveTime[0].length;
		final boolean[][] d = new boolean[m][n];
		final Queue<Vertex> h = new PriorityQueue<>((v1, v2) -> Integer.compare(v1.time, v2.time));
		d[0][0] = true;
		h.add(new Vertex(0, 0, 0));
		while (!h.isEmpty()) {
			final Vertex u = h.remove();
			for (int[] move : MOVES) {
				final int r = u.r + move[0];
				final int c = u.c + move[1];
				if (r >= 0 && r < m && c >= 0 && c < n && !d[r][c]) {
					final int t = Math.max(u.time, moveTime[r][c]) + 1;
					if (r == m - 1 && c == n - 1)
						return t;

					d[r][c] = true;
					h.add(new Vertex(r, c, t));
				}
			}
		}
		throw new AssertionError();
	}

	private static class Vertex {
		private final int r;
		private final int c;
		private final int time;

		private Vertex(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
}
