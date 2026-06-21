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
		final int[] sortedCosts = CountingSort.countingSort(costs, 100000);
		int cnt = 0;
		final int n = costs.length;
		for (int i = 0, remCoins = coins; i < n; i++) {
			if (remCoins >= sortedCosts[i]) {
				remCoins = remCoins - sortedCosts[i];
				cnt = cnt + 1;
			}
		}
		return cnt;
	}
}
