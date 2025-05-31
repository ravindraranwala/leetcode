package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

class SnakesAndLadders {
	SnakesAndLadders() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] board1 = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
				{ -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
		assert snakesAndLadders(board1) == 4;

		final int[][] board2 = { { -1, -1 }, { -1, 3 } };
		assert snakesAndLadders(board2) == 1;
	}

	static int snakesAndLadders(int[][] board) {
		final int n = board.length;
		final int size = n * n;
		final boolean[] d = new boolean[n * n + 1];
		final Queue<Vertex> q = new ArrayDeque<>();
		d[1] = true;
		q.offer(new Vertex(1, 0));
		while (!q.isEmpty()) {
			final Vertex u = q.remove();
			// scan the adjacency list or simulate dice rolls.
			for (int i = 1; i <= 6; i++) {
				final int lbl = u.label + i;
				if (lbl <= size) {
					final int[] p = rowAndCol(lbl, n);
					final int next = board[p[0]][p[1]] == -1 ? lbl : board[p[0]][p[1]];
					if (next == size)
						return u.distance + 1;

					if (!d[next]) {
						d[next] = true;
						q.offer(new Vertex(next, u.distance + 1));
					}
				}
			}
		}
		return -1;
	}

	private static int[] rowAndCol(int label, int n) {
		final int r = (label - 1) / n;
		final int colOffset = (label - 1) - r * n;
		final int c = r % 2 == 0 ? colOffset : n - 1 - colOffset;
		return new int[] { n - 1 - r, c };
	}

	private static class Vertex {
		private final int label;
		private final int distance;

		Vertex(int label, int distance) {
			this.label = label;
			this.distance = distance;
		}
	}
}
