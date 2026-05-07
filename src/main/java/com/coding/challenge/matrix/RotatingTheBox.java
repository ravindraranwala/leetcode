package com.coding.challenge.matrix;

import java.util.Arrays;

class RotatingTheBox {
	private static final char SPACE = '.';
	private static final char STONE = '#';
	private static final char OBSTACLE = '*';

	RotatingTheBox() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final char[][] boxGrid1 = { { '#', '.', '#' } };
		final char[][] ans1 = { { '.' }, { '#' }, { '#' } };
		assert Arrays.deepEquals(ans1, rotateTheBox(boxGrid1));

		final char[][] boxGrid2 = { { '#', '.', '*', '.' }, { '#', '#', '*', '.' } };
		final char[][] ans2 = { { '#', '.' }, { '#', '#' }, { '*', '*' }, { '.', '.' } };
		assert Arrays.deepEquals(ans2, rotateTheBox(boxGrid2));

		final char[][] boxGrid3 = { { '#', '#', '*', '.', '*', '.' }, { '#', '#', '#', '*', '.', '.' },
				{ '#', '#', '#', '.', '#', '.' } };
		final char[][] ans3 = { { '.', '#', '#' }, { '.', '#', '#' }, { '#', '#', '*' }, { '#', '*', '.' },
				{ '#', '.', '*' }, { '#', '.', '.' } };
		assert Arrays.deepEquals(ans3, rotateTheBox(boxGrid3));
	}

	static char[][] rotateTheBox(char[][] boxGrid) {
		final int m = boxGrid.length;
		final int n = boxGrid[0].length;
		final char[][] t = new char[n][m];

		for (int i = 0; i < m; i++) {
			for (int j = n - 1, p = n - 1; j >= 0; j--) {
				if (boxGrid[i][j] == SPACE)
					t[j][m - 1 - i] = SPACE;
				else if (boxGrid[i][j] == OBSTACLE) {
					t[j][m - 1 - i] = OBSTACLE;
					p = j - 1;
				} else {
					// order matters here.
					t[j][m - 1 - i] = SPACE;
					t[p][m - 1 - i] = STONE;
					p = p - 1;
				}
			}
		}
		return t;
	}
}
