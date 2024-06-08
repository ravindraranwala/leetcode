package com.coding.challenge.dp;

class FillingBookcaseShelves {
	FillingBookcaseShelves() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] books1 = { { 1, 1 }, { 2, 3 }, { 2, 3 }, { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 2 } };
		assert minHeightShelves(books1, 4) == 6;

		final int[][] books2 = { { 1, 3 }, { 2, 4 }, { 3, 2 } };
		assert minHeightShelves(books2, 6) == 4;
	}

	static int minHeightShelves(int[][] books, int shelfWidth) {
		final int n = books.length;
		final int[] h = new int[n + 1];

		for (int i = n - 1; i >= 0; i--) {
			h[i] = Integer.MAX_VALUE;
			for (int j = i, lastShelfHeight = 0, lastShelfWidth = 0; j < n; j++) {
				lastShelfHeight = Math.max(lastShelfHeight, books[j][1]);
				lastShelfWidth = lastShelfWidth + books[j][0];
				if (lastShelfWidth <= shelfWidth)
					h[i] = Math.min(h[i], lastShelfHeight + h[j + 1]);
				else
					break;
			}
		}
		return h[0];
	}
}
