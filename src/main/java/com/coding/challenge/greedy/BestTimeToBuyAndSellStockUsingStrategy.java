package com.coding.challenge.greedy;

class BestTimeToBuyAndSellStockUsingStrategy {
	BestTimeToBuyAndSellStockUsingStrategy() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] prices1 = { 4, 2, 8 };
		final int[] strategy1 = { -1, 0, 1 };
		assert maxProfit(prices1, strategy1, 2) == 10;

		final int[] prices2 = { 5, 4, 3 };
		final int[] strategy2 = { 1, 1, 0 };
		assert maxProfit(prices2, strategy2, 2) == 9;
	}

	static long maxProfit(int[] prices, int[] strategy, int k) {
		final int n = prices.length;
		long initProfit = 0;
		for (int p = 0; p < n; p++)
			initProfit = initProfit + (prices[p] * strategy[p]);

		long sumOfPrdOne = 0;
		for (int q = 0, mid = k / 2; q < mid; q++)
			sumOfPrdOne = sumOfPrdOne + (prices[q] * strategy[q]);

		long sumOfPrdTwo = 0;
		long sumOfPricesTwo = 0;
		for (int r = k / 2; r < k; r++) {
			sumOfPrdTwo = sumOfPrdTwo + (prices[r] * strategy[r]);
			sumOfPricesTwo = sumOfPricesTwo + prices[r];
		}

		long maxWindowDelta = sumOfPricesTwo - sumOfPrdTwo - sumOfPrdOne;

		for (int i = k; i < n; i++) {
			sumOfPrdTwo = sumOfPrdTwo + prices[i] * strategy[i];
			sumOfPricesTwo = sumOfPricesTwo + prices[i];

			final int midIdx = i - k / 2;
			final int midVal = prices[midIdx] * strategy[midIdx];
			sumOfPrdTwo = sumOfPrdTwo - midVal;
			sumOfPricesTwo = sumOfPricesTwo - prices[midIdx];

			sumOfPrdOne = sumOfPrdOne + midVal;
			sumOfPrdOne = sumOfPrdOne - (prices[i - k] * strategy[i - k]);
			maxWindowDelta = Math.max(maxWindowDelta, sumOfPricesTwo - sumOfPrdTwo - sumOfPrdOne);
		}
		return initProfit + Math.max(maxWindowDelta, 0);
	}
}
