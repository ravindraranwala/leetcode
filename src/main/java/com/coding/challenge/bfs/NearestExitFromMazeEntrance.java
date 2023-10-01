package com.coding.challenge.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

class NearestExitFromMazeEntrance {
	private static final char EMPTY = '.';
	private static final char WALL = '+';
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	NearestExitFromMazeEntrance() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[][] mazeOne = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+', '+', '.' } };
		final int[] entranceOne = { 1, 2 };
		assert nearestExit(mazeOne, entranceOne) == 1;

		final char[][] mazeTwo = { { '+', '+', '+' }, { '.', '.', '.' }, { '+', '+', '+' } };
		final int[] entranceTwo = { 1, 0 };
		assert nearestExit(mazeTwo, entranceTwo) == 2;

		final char[][] mazeThree = { { '.', '+' } };
		final int[] entranceThree = { 0, 0 };
		assert nearestExit(mazeThree, entranceThree) == -1;
	}

	static int nearestExit(char[][] maze, int[] entrance) {
		maze[entrance[0]][entrance[1]] = WALL;
		final Queue<int[]> q = new ArrayDeque<>();
		// row, column and distance attributes respectively.
		q.offer(new int[] { entrance[0], entrance[1], 0 });
		final int m = maze.length;
		final int n = maze[0].length;
		while (!q.isEmpty()) {
			final int[] u = q.poll();
			for (int[] move : MOVES) {
				final int r = u[0] + move[0];
				final int c = u[1] + move[1];
				if (r >= 0 && c >= 0 && r < m && c < n && maze[r][c] == EMPTY) {
					// check for the exit point at the border.
					if (r == 0 || c == 0 || r == m - 1 || c == n - 1)
						return u[2] + 1;

					maze[r][c] = WALL;
					q.offer(new int[] { r, c, u[2] + 1 });
				}
			}
		}
		return -1;
	}
}
