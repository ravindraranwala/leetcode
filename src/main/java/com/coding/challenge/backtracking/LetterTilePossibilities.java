package com.coding.challenge.backtracking;

class LetterTilePossibilities {
	private static final char FIRST_LETTER = 'A';

	LetterTilePossibilities() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numTilePossibilities("AAB") == 8;
		assert numTilePossibilities("AAABBC") == 188;
		assert numTilePossibilities("V") == 1;
		assert numTilePossibilities("ABCDE") == 325;
	}

	static int numTilePossibilities(String tiles) {
		final int n = tiles.length();
		return backtrack(tiles, new boolean[n], n);
	}

	private static int backtrack(String tiles, boolean[] used, int n) {
		final boolean[] d = new boolean[26];
		int c = 0;
		for (int i = 0; i < n; i++) {
			final char ch = tiles.charAt(i);
			if (!used[i] && !d[ch - FIRST_LETTER]) {
				d[ch - FIRST_LETTER] = true;
				// choose
				used[i] = true;
				// explore
				c = c + backtrack(tiles, used, n) + 1;
				// unchoose.
				used[i] = false;
			}
		}
		return c;
	}
}
