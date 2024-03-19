package com.coding.challenge.dfs;

import java.util.Arrays;

class Minesweeper {
	private static final int[][] MOVES = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
			{ 1, 1 } };

	Minesweeper() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[][] board1 = { { 'E', 'E', 'E', 'E', 'E' }, { 'E', 'E', 'M', 'E', 'E' }, { 'E', 'E', 'E', 'E', 'E' },
				{ 'E', 'E', 'E', 'E', 'E' } };
		final int[] click1 = { 3, 0 };
		final char[][] expBoard1 = { { 'B', '1', 'E', '1', 'B' }, { 'B', '1', 'M', '1', 'B' },
				{ 'B', '1', '1', '1', 'B' }, { 'B', 'B', 'B', 'B', 'B' } };
		assert Arrays.deepEquals(expBoard1, updateBoard(board1, click1));

		final char[][] board2 = { { 'B', '1', 'E', '1', 'B' }, { 'B', '1', 'M', '1', 'B' }, { 'B', '1', '1', '1', 'B' },
				{ 'B', 'B', 'B', 'B', 'B' } };
		final int[] click2 = { 1, 2 };
		final char[][] expBoard2 = { { 'B', '1', 'E', '1', 'B' }, { 'B', '1', 'X', '1', 'B' },
				{ 'B', '1', '1', '1', 'B' }, { 'B', 'B', 'B', 'B', 'B' } };
		assert Arrays.deepEquals(expBoard2, updateBoard(board2, click2));
	}

	static char[][] updateBoard(char[][] board, int[] click) {
		// trivial case of the recursion.
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		}
		if (board[click[0]][click[1]] == 'E')
			reveal(board, click[0], click[1], board.length, board[0].length);
		return board;
	}

	private static void reveal(char[][] board, int r, int c, int m, int n) {
		// find adjacent mines.
		int adjMines = 0;
		for (int[] move : MOVES) {
			final int i = r + move[0];
			final int j = c + move[1];
			if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'M')
				adjMines = adjMines + 1;
		}

		if (adjMines == 0) {
			board[r][c] = 'B';
			// recursive calls.
			for (int[] move : MOVES) {
				final int i = r + move[0];
				final int j = c + move[1];
				if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'E')
					reveal(board, i, j, m, n); // DFS
			}
		} else
			board[r][c] = Character.forDigit(adjMines, 10);
	}
}
