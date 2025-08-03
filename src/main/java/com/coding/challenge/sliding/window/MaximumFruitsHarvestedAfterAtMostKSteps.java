package com.coding.challenge.sliding.window;

class MaximumFruitsHarvestedAfterAtMostKSteps {
	MaximumFruitsHarvestedAfterAtMostKSteps() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] fruits1 = { { 2, 8 }, { 6, 3 }, { 8, 6 } };
		assert maxTotalFruits(fruits1, 5, 4) == 9;

		final int[][] fruits2 = { { 0, 9 }, { 4, 1 }, { 5, 7 }, { 6, 2 }, { 7, 4 }, { 10, 9 } };
		assert maxTotalFruits(fruits2, 5, 4) == 14;

		final int[][] fruits3 = { { 0, 3 }, { 6, 4 }, { 8, 5 } };
		assert maxTotalFruits(fruits3, 3, 2) == 0;

		final int[][] fruits4 = { { 3, 7 }, { 6, 4 }, { 8, 5 }, { 15, 5 }, { 20, 2 } };
		assert maxTotalFruits(fruits4, 5, 4) == 11;
	}

	static int maxTotalFruits(int[][] fruits, int startPos, int k) {
		final int n = fruits.length;
		int l = 0;
		while (l < n && startPos - fruits[l][0] > k)
			l = l + 1;

		int maxFruits = 0;
		for (int r = l, s = 0; r < n && fruits[r][0] - startPos <= k; r++) {
			if (fruits[r][0] > startPos) {
				// left round trip
				while ((startPos - fruits[l][0]) * 2 + fruits[r][0] - startPos > k) {
					s = s - fruits[l][1];
					l = l + 1;
				}
			}
			s = s + fruits[r][1];
			maxFruits = Math.max(maxFruits, s);
		}

		int right = n - 1;
		while (right >= 0 && fruits[right][0] - startPos > k)
			right = right - 1;

		for (int left = right, s = 0; left >= 0 && startPos - fruits[left][0] <= k; left--) {
			if (fruits[left][0] < startPos) {
				// right round trip.
				while ((fruits[right][0] - startPos) * 2 + startPos - fruits[left][0] > k) {
					s = s - fruits[right][1];
					right = right - 1;
				}
			}
			s = s + fruits[left][1];
			maxFruits = Math.max(maxFruits, s);
		}

		return maxFruits;
	}
}
