package com.coding.challenge.dp;

class MinCostClimbingStairs {
	MinCostClimbingStairs() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] cost1 = { 10, 15, 20 };
		assert minCostClimbingStairs(cost1) == 15;
	}

	static int minCostClimbingStairs(int[] cost) {
		final int n = cost.length;
		int currCost = 0;
		for (int i = 2, prevCost = 0, beforeprevCost = 0; i <= n; i++) {
			currCost = Math.min(prevCost + cost[i - 1], beforeprevCost + cost[i - 2]);
			beforeprevCost = prevCost;
			prevCost = currCost;
		}
		return currCost;
	}
}
