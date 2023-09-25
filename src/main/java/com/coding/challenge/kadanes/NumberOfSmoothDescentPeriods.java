package com.coding.challenge.kadanes;

class NumberOfSmoothDescentPeriods {
	NumberOfSmoothDescentPeriods() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] pricesOne = { 3, 2, 1, 4 };
		assert getDescentPeriods(pricesOne) == 7;

		final int[] pricesTwo = { 8, 6, 7, 7 };
		assert getDescentPeriods(pricesTwo) == 4;

		final int[] pricesThree = { 1 };
		assert getDescentPeriods(pricesThree) == 1;
	}

	static long getDescentPeriods(int[] prices) {
		final int n = prices.length;
		long c = 1;

		for (int i = 0, j = 1; j < n; j++) {
			if (prices[j] + 1 != prices[j - 1])
				i = j;

			c = c + j - i + 1;
		}
		return c;
	}
}
