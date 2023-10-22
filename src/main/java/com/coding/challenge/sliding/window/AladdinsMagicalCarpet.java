package com.coding.challenge.sliding.window;

class AladdinsMagicalCarpet {
	AladdinsMagicalCarpet() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] magic1 = { 3, 2, 5, 4 };
		final int[] dist1 = { 2, 3, 4, 2 };
		assert optimalPoint(magic1, dist1) == 0;

		final int[] magic2 = { 2, 4, 5, 2 };
		final int[] dist2 = { 4, 3, 1, 3 };
		assert optimalPoint(magic2, dist2) == 1;

		final int[] magic3 = { 8, 4, 1, 9 };
		final int[] dist3 = { 10, 9, 3, 5 };
		assert optimalPoint(magic3, dist3) == -1;
	}

	static int optimalPointBruteForce(int[] magic, int[] dist) {
		final int n = magic.length;
		for (int i = 0; i < n; i++) {
			int points = 0;
			for (int j = i; j < n && points >= 0; j++)
				points = points + magic[j] - dist[j];

			for (int k = 0; k < i && points >= 0; k++)
				points = points + magic[k] - dist[k];

			// answer found.
			if (points >= 0)
				return i;
		}
		return -1;
	}

	static int optimalPoint(int[] magic, int[] dist) {
		final int n = magic.length;
		for (int i = 0, p = 0, l = 0; l <= n; l++) {
			p = p + magic[(i + l) % n] - dist[(i + l) % n];
			while (p < 0 && i < n) {
				p = p - magic[i] + dist[i];
				i = i + 1;
				l = l - 1;
			}
			if (i == n)
				return -1;
			// answer found.
			if (l == n)
				return i;
		}
		// can't get here.
		throw new AssertionError();
	}
}
