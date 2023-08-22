package com.coding.challenge.dp;

class BestTimeToBuyAndSellStockWithCooldown {
	BestTimeToBuyAndSellStockWithCooldown() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] pricesOne = { 1, 2, 3, 0, 2 };
		assert maxProfit(pricesOne) == 3;

		final int[] pricesTwo = { 1 };
		assert maxProfit(pricesTwo) == 0;

		final int[] pricesThree = { 1, 2 };
		assert maxProfit(pricesThree) == 1;

		final int[] pricesFour = { 6, 1, 6, 4, 3, 0, 2 };
		assert maxProfit(pricesFour) == 7;
	}

	static int maxProfit(int[] prices) {
		final int n = prices.length;
		final int[] p = new int[n + 2];
		int ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				final int d = prices[j] - prices[i];
				ans = Math.max(ans, Math.max(d, d + p[j + 2]));
			}
			p[i] = ans;
		}
		return ans;
	}
}
