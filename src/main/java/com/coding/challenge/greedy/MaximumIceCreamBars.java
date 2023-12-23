package com.coding.challenge.greedy;

import com.coding.challenge.counting.sort.CountingSort;

class MaximumIceCreamBars {
	MaximumIceCreamBars() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] costs1 = { 1, 3, 2, 4, 1 };
		assert maxIceCream(costs1, 7) == 4;

		final int[] costs2 = { 10, 6, 8, 7, 7, 8 };
		assert maxIceCream(costs2, 5) == 0;

		final int[] costs3 = { 1, 6, 3, 1, 2, 5 };
		assert maxIceCream(costs3, 20) == 6;
	}

	static int maxIceCream(int[] costs, int coins) {
		int k = 0;
		for (int cost : costs)
			k = Math.max(k, cost);
		final int[] b = CountingSort.countingSort(costs, k);
		int c = 0;
		for (int cost : b) {
			if (cost <= coins) {
				coins = coins - cost;
				c = c + 1;
			}
		}
		return c;
	}
}
