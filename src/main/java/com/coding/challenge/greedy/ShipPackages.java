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
	}

	static int shipWithinDays(int[] weights, int days) {
		final int n = weights.length;
		int l = 0;
		int h = 0;
		for (int i = 0; i < n; i++)
			h = h + weights[i];
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
		int t = 0;
		int ls = -1;
		for (int i = 0; i < n; i++) {
			if (w[i] > c)
				return false;
			if (s + w[i] > c) {
				t = t + 1;
				s = w[i];
				ls = i - 1;
			} else if (s + w[i] == c) {
				t = t + 1;
				s = 0;
				ls = i;
			} else
				s = s + w[i];
		}
		if (ls != n - 1)
			t = t + 1;
		return t <= d;
	}
}
