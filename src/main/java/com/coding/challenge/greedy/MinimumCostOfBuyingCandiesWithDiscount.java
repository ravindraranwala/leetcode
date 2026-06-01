package com.coding.challenge.greedy;

import java.util.Arrays;

class MinimumCostOfBuyingCandiesWithDiscount {
	MinimumCostOfBuyingCandiesWithDiscount() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] cost1 = { 1, 2, 3 };
		assert minimumCost(cost1) == 5;

		final int[] cost2 = { 6, 5, 7, 9, 2, 2 };
		assert minimumCost(cost2) == 23;

		final int[] cost3 = { 5, 5 };
		assert minimumCost(cost3) == 10;
	}

	static int minimumCost(int[] cost) {
		final int n = cost.length;
		Arrays.sort(cost);
		int totalCost = 0;

		int i = n - 1;
		while (i >= 2) {
			totalCost = totalCost + cost[i] + cost[i - 1];
			i = i - 3;
		}

		if (i == -1)
			return totalCost;
		if (i == 0)
			return totalCost + cost[0];

		return totalCost + cost[0] + cost[1];
	}
}
