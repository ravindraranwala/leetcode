package com.coding.challenge.dp;

class MinimumCostForTickets {
	MinimumCostForTickets() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] days1 = { 1, 4, 6, 7, 8, 20 };
		final int[] costs1 = { 2, 7, 15 };
		assert mincostTickets(days1, costs1) == 11;

		final int[] days2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 };
		final int[] costs2 = { 2, 7, 15 };
		assert mincostTickets(days2, costs2) == 17;
	}

	static int mincostTickets(int[] days, int[] costs) {
		final int n = days.length;
		final int[] p = new int[n + 1];

		for (int i = n - 1, j = n - 1, k = n - 1; i >= 0; i--) {
			while (days[k] - days[i] >= 30)
				k = k - 1;
			while (days[j] - days[i] >= 7)
				j = j - 1;
			p[i] = Math.min(p[i + 1] + costs[0], Math.min(p[j + 1] + costs[1], p[k + 1] + costs[2]));
		}

		return p[0];
	}
}
