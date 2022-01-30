package com.coding.challenge.greedy;

class ShipPackages {
	ShipPackages() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] w1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		final int d1 = 5;
		int c = shipWithinDays(w1, d1);
		System.out.println(c);

		final int[] w2 = { 3, 2, 2, 4, 1, 4 };
		final int d2 = 3;
		c = shipWithinDays(w2, d2);
		System.out.println(c);

		final int[] w3 = { 1, 2, 3, 1, 1 };
		final int d3 = 4;
		c = shipWithinDays(w3, d3);
		System.out.println(c);

		final int[] w4 = { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
		final int d4 = 8;
		c = shipWithinDays(w4, d4);
		System.out.println(c);

		c = shipWithinDays(w3, 1);
		System.out.println(c);
	}

	static int shipWithinDays(int[] weights, int days) {
		final int n = weights.length;
		int mw = 0;
		int s = 0;
		for (int i = 0; i < n; i++) {
			s = s + weights[i];
			mw = Math.max(mw, weights[i]);
		}
		int h = (int) Math.ceil((double) n / days) * mw;
		int l = (int) Math.max(mw, Math.ceil((double) s / days));
		int c = 0;
		while (l <= h) {
			final int m = (l + h) / 2;
			if (possibleCap(weights, m, days)) {
				h = m - 1;
				c = m;
			} else
				l = m + 1;
		}
		return c;
	}

	static boolean possibleCap(int[] w, int c, int d) {
		final int n = w.length;
		int s = 0;
		for (int i = 0; i < n; i++) {
			if (s + w[i] > c) {
				d = d - 1;
				s = w[i];
			} else
				s = s + w[i];
		}
		d = d - 1;
		return d >= 0;
	}
}
