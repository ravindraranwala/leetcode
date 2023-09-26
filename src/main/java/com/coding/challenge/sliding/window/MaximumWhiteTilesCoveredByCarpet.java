package com.coding.challenge.sliding.window;

import java.util.Arrays;

class MaximumWhiteTilesCoveredByCarpet {
	MaximumWhiteTilesCoveredByCarpet() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] tilesOne = { { 1, 5 }, { 10, 11 }, { 12, 18 }, { 20, 25 }, { 30, 32 } };
		assert maximumWhiteTiles(tilesOne, 10) == 9;

		final int[][] tilesTwo = { { 10, 11 }, { 1, 1 } };
		assert maximumWhiteTiles(tilesTwo, 2) == 2;

		final int[][] tilesThree = { { 3, 4 }, { 1, 2 } };
		assert maximumWhiteTiles(tilesThree, 1) == 1;

		final int[][] tilesFour = { { 10, 15 }, { 1, 1 } };
		assert maximumWhiteTiles(tilesFour, 2) == 2;
	}

	static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
		final int n = tiles.length;
		Arrays.sort(tiles, (a, b) -> Integer.compare(a[0], b[0]));
		int maxTiles = 0;

		for (int i = 0, j = 0, c = 0; j < n; j++) {
			if (tiles[j][1] - tiles[j][0] + 1 >= carpetLen)
				return carpetLen;

			while (tiles[i][0] + carpetLen - 1 < tiles[j][1]) {
				maxTiles = Math.max(maxTiles, c + tiles[i][0] + carpetLen - 1 - tiles[j][0] + 1);
				c = c - (tiles[i][1] - tiles[i][0] + 1);
				i = i + 1;
			}
			c = c + tiles[j][1] - tiles[j][0] + 1;
			maxTiles = Math.max(maxTiles, c);
		}
		return maxTiles;
	}
}
