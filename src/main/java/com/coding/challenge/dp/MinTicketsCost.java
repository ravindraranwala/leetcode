package com.coding.challenge.dp;

class MinTicketsCost {
	MinTicketsCost() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] daysOne = { 1, 4, 6, 7, 8, 20 };
		final int[] costsOne = { 2, 7, 15 };
		assert mincostTickets(daysOne, costsOne) == 11;

		final int[] daysTwo = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 };
		final int[] costsTwo = { 2, 7, 15 };
		assert mincostTickets(daysTwo, costsTwo) == 17;

		final int[] daysThree = { 1, 4, 6, 7, 8, 20 };
		final int[] costsThree = { 7, 2, 15 };
		assert mincostTickets(daysThree, costsThree) == 6;

		final int[] daysFour = { 1, 2, 3, 4, 6, 8, 9, 10, 13, 14, 16, 17, 19, 21, 24, 26, 27, 28, 29 };
		final int[] costsFour = { 3, 14, 50 };
		assert mincostTickets(daysFour, costsFour) == 50;
	}

	static int mincostTickets(int[] days, int[] costs) {
		final int n = days.length;
		final int[] t = new int[n + 1];
		t[0] = 0;
		t[1] = Math.min(costs[0], Math.min(costs[1], costs[2]));
		int i = 0;
		int j = 0;

		for (int k = 1; k < n; k++) {
			final int p1 = t[k] + costs[0];
			// sliding the 7-days window.
			while (days[k] - days[i] >= 7)
				i = i + 1;
			final int p2 = t[i] + costs[1];

			// sliding the 30-days window.
			while (days[k] - days[j] >= 30)
				j = j + 1;
			final int p3 = t[j] + costs[2];
			t[k + 1] = Math.min(p1, Math.min(p2, p3));
		}
		return t[n];
	}
}
