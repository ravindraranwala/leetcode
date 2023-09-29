package com.coding.challenge.dfs;

import java.util.Arrays;

class SurroundedRegions {
	private static int[][] MOVES = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	SurroundedRegions() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[][] gridOne = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		solve(gridOne);
		final char[][] expectedOne = { { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		assert Arrays.deepEquals(gridOne, expectedOne);

		final char[][] gridTwo = { { 'X' } };
		solve(gridTwo);
		final char[][] expectedTwo = { { 'X' } };
		assert Arrays.deepEquals(gridTwo, expectedTwo);

		final char[][] gridThree = { { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' } };
		solve(gridThree);
		final char[][] expectedThree = { { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' } };
		assert Arrays.deepEquals(gridThree, expectedThree);

		final char[][] gridFour = { { 'O', 'X', 'X', 'O', 'X' }, { 'X', 'O', 'O', 'X', 'O' },
				{ 'X', 'O', 'X', 'O', 'X' }, { 'O', 'X', 'O', 'O', 'O' }, { 'X', 'X', 'O', 'X', 'O' } };
		solve(gridFour);
		final char[][] expectedFour = { { 'O', 'X', 'X', 'O', 'X' }, { 'X', 'X', 'X', 'X', 'O' },
				{ 'X', 'X', 'X', 'O', 'X' }, { 'O', 'X', 'O', 'O', 'O' }, { 'X', 'X', 'O', 'X', 'O' } };
		assert Arrays.deepEquals(gridFour, expectedFour);
	}

	static void solve(char[][] board) {
		final int m = board.length;
		final int n = board[0].length;
		final boolean[][] d = new boolean[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				if (board[i][j] == 'O' && !d[i][j] && isSurrounded(board, d, i, j))
					captureRegion(board, i, j);
	}

	private static boolean isSurrounded(char[][] board, boolean[][] d, int i, int j) {
		// discover it first.
		d[i][j] = true;
		boolean s = true;
		for (int[] move : MOVES) {
			final int r = i + move[0];
			final int c = j + move[1];
			if (r == -1 || c == -1 || r == board.length || c == board[0].length)
				s = false;
			else if (!d[r][c] && board[r][c] == 'O')
				s = s & isSurrounded(board, d, r, c);
		}
		return s;
	}

	private static void captureRegion(char[][] board, int i, int j) {
		// discover it first.
		board[i][j] = 'X';
		for (int[] move : MOVES) {
			final int r = i + move[0];
			final int c = j + move[1];
			if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 'O')
				captureRegion(board, r, c);
		}
	}
}
