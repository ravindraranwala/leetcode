package com.coding.challenge.matrix;

class ValidSudoku {
	private static final char ZERO = '0';

	ValidSudoku() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[][] board1 = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		assert isValidSudoku(board1);

		final char[][] board2 = { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		assert !isValidSudoku(board2);
	}

	static boolean isValidSudoku(char[][] board) {
		final boolean[][] rowData = new boolean[9][10];
		final boolean[][] colData = new boolean[9][10];
		final boolean[][] boxData = new boolean[9][10];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// if value is not empty, then consume it.
				if (board[i][j] != '.') {
					final int val = board[i][j] - ZERO;
					if (rowData[i][val])
						return false;
					if (colData[j][val])
						return false;
					final int b = (i / 3) * 3 + j / 3;
					if (boxData[b][val])
						return false;

					rowData[i][val] = true;
					colData[j][val] = true;
					boxData[b][val] = true;
				}
			}
		}
		return true;
	}
}
