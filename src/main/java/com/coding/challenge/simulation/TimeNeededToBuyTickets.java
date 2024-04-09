package com.coding.challenge.simulation;

class TimeNeededToBuyTickets {
	TimeNeededToBuyTickets() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] tickets1 = { 2, 3, 2 };
		assert timeRequiredToBuy(tickets1, 2) == 6;

		final int[] tickets2 = { 5, 1, 1, 1 };
		assert timeRequiredToBuy(tickets2, 0) == 8;
	}

	static int timeRequiredToBuy(int[] tickets, int k) {
		final int n = tickets.length;
		int t = 0;
		for (int i = 0; i < n; i++) {
			if (tickets[i] < tickets[k])
				t = t + tickets[i];
			else if (i <= k)
				t = t + tickets[k];
			else
				t = t + tickets[k] - 1;
		}

		return t;
	}
}
