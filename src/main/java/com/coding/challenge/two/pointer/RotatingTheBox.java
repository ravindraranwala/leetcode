package com.coding.challenge.two.pointer;

import java.util.Arrays;

class RotatingTheBox {
	private static final char STONE = '#';
	private static final char EMPTY = '.';

	RotatingTheBox() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[][] b1 = { { '#', '.', '#' } };
		final int[][] a1 = { { '.' }, { '#' }, { '#' } };
		assert Arrays.equals(a1, rotateTheBox(b1));

		final char[][] b2 = { { '#', '.', '*', '.' }, { '#', '#', '*', '.' } };
		final int[][] a2 = { { '#', '.' }, { '#', '#' }, { '*', '*' }, { '.', '.' } };
		assert Arrays.equals(a2, rotateTheBox(b2));

		final char[][] b3 = { { '#', '#', '*', '.', '*', '.' }, { '#', '#', '#', '*', '.', '.' },
				{ '#', '#', '#', '.', '#', '.' } };
		final int[][] a3 = { { '.', '#', '#' }, { '.', '#', '#' }, { '#', '#', '*' }, { '#', '*', '.' },
				{ '#', '.', '*' }, { '#', '.', '.' } };
		assert Arrays.equals(a3, rotateTheBox(b3));
	}

	static char[][] rotateTheBox(char[][] box) {
		final int m = box.length;
		final int n = box[0].length;
		final char[][] t = new char[n][m];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				t[j][m - i - 1] = box[i][j];

		for (int c = 0; c < m; c++) {
			for (int r = n - 1, availRow = n - 1; r >= 0; r--) {
				if (t[r][c] == STONE) {
					while (availRow > r && t[availRow][c] != EMPTY)
						availRow = availRow - 1;
					t[r][c] = EMPTY;
					t[availRow][c] = STONE;
					availRow = availRow - 1;
				} else if (t[r][c] == '*')
					availRow = r - 1;
			}
		}
		return t;
	}
	
	public char[][] rotateTheBoxOnePass(char[][] box) {
        final int m = box.length;
		final int n = box[0].length;
		final char[][] t = new char[n][m];

		for (int i = 0; i < m; i++) {
			for (int j = n - 1, availRow = n - 1; j >= 0; j--) {
				final int c = m - i - 1;
				t[j][c] = box[i][j];
				if (box[i][j] == STONE) {
					while (availRow > j && t[availRow][c] != EMPTY)
						availRow = availRow - 1;
					t[j][c] = EMPTY;
					t[availRow][c] = STONE;
					availRow = availRow - 1;
				} else if (t[j][c] == '*')
					availRow = j - 1;
			}
		}
		return t;
    }
}
