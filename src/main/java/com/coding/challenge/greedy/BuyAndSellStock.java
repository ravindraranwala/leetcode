package com.coding.challenge.greedy;

class BuyAndSellStock {

	BuyAndSellStock() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] p = { 7, 1, 5, 3, 6, 4 };
		int mp = maxProfit(p);
		System.out.println(mp);

		final int[] p1 = { 1, 2, 3, 4, 5 };
		mp = maxProfit(p1);
		System.out.println(mp);

		final int[] p2 = { 7, 6, 4, 3, 1 };
		mp = maxProfit(p2);
		System.out.println(mp);
	}

	static int maxProfit(int[] prices) {
		final int n = prices.length;
		int v = 0;
		for (int i = 0; i < n - 1; i++) {
			if (prices[i] < prices[i + 1])
				v = v + prices[i + 1] - prices[i];
		}
		return v;
	}
}
