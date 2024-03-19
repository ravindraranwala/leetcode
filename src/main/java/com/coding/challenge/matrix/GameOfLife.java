package com.coding.challenge.matrix;

import java.util.Arrays;

class GameOfLife {
	// before and after with respect to the row-major order.
	private static final int[][] BEFORE_NEIGHBORS = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 } };
	private static final int[][] AFTER_NEIGHBORS = { { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	GameOfLife() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] board1 = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		gameOfLife(board1);
		System.out.println(Arrays.deepToString(board1));

		final int[][] board2 = { { 1, 1 }, { 1, 0 } };
		gameOfLife(board2);
		System.out.println(Arrays.deepToString(board2));
	}

	static void gameOfLife(int[][] board) {
		final int m = board.length;
		final int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int[] move : BEFORE_NEIGHBORS) {
					final int p = i + move[0];
					final int q = j + move[1];
					if (p >= 0 && p < m && q >= 0 && q < n && board[p][q] >= 10)
						cnt = cnt + 1;
				}

				for (int[] move : AFTER_NEIGHBORS) {
					final int p = i + move[0];
					final int q = j + move[1];
					if (p >= 0 && p < m && q >= 0 && q < n && board[p][q] == 1)
						cnt = cnt + 1;
				}
				// encode the information.
				// first digit: current cell state, 0 or 1.
				// second digit: number of live neighbors.
				board[i][j] = board[i][j] * 10 + cnt;
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// decode the information.
				final int cellState = board[i][j] / 10;
				final int liveNeighbors = board[i][j] % 10;
				// apply rules here.
				// compute the next state of the cell.
				if (cellState == 1)
					if (liveNeighbors == 2 || liveNeighbors == 3)
						board[i][j] = 1;
					else
						board[i][j] = 0;
				else if (liveNeighbors == 3)
					board[i][j] = 1;
				else
					board[i][j] = 0;
			}
		}
	}
}
