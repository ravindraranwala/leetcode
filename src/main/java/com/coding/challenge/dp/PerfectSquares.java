package com.coding.challenge.dp;

class PerfectSquares {
	PerfectSquares() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		assert numSquares(12) == 3;
		assert numSquares(13) == 2;
	}

	static int numSquares(int n) {
		final int[] a = new int[n + 1];
		for (int p = 1; p <= n; p++) {
			a[p] = 10001;
			for (int q = 1; q * q <= p; q++)
				a[p] = Math.min(a[p], a[p - q * q] + 1);
		}
		return a[n];
	}
}
