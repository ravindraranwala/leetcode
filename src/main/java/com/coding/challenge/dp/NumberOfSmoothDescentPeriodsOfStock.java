package com.coding.challenge.dp;

class NumberOfSmoothDescentPeriodsOfStock {
	NumberOfSmoothDescentPeriodsOfStock() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] prices1 = { 3, 2, 1, 4 };
		assert getDescentPeriods(prices1) == 7;

		final int[] prices2 = { 8, 6, 7, 7 };
		assert getDescentPeriods(prices2) == 4;

		final int[] prices3 = { 1 };
		assert getDescentPeriods(prices3) == 1;
	}

	static long getDescentPeriods(int[] prices) {
		final int n = prices.length;
		long p = 1;
		for (int i = 1, l = 1; i < n; i++) {
			if (prices[i - 1] - prices[i] == 1)
				l = l + 1;
			else
				l = 1;

			p = p + l;
		}
		return p;
	}
}
