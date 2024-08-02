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
		final int[] h = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = Integer.MAX_VALUE;
			int j = i;
			int w = books[j][0];
			int shelfHeight = books[j][1];
			while (j > 0 && w <= shelfWidth) {
				h[i] = Math.min(h[i], h[j - 1] + shelfHeight);
				j = j - 1;
				w = w + books[j][0];
				shelfHeight = Math.max(shelfHeight, books[j][1]);
			}
			if (w <= shelfWidth)
				h[i] = shelfHeight;
		}
		return h[n - 1];
	}
}
