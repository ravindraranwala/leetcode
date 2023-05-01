package com.coding.challenge.general;

import java.util.HashMap;
import java.util.Map;

class MinConsecutiveCardsToPickUp {
	MinConsecutiveCardsToPickUp() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] cardsOne = { 3, 4, 2, 3, 4, 7 };
		assert minimumCardPickup(cardsOne) == 4;

		final int[] cardsTwo = { 1, 0, 5, 3 };
		assert minimumCardPickup(cardsTwo) == -1;
	}

	static int minimumCardPickup(int[] cards) {
		final int n = cards.length;
		final Map<Integer, Integer> t = new HashMap<>();
		int d = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			if (t.containsKey(cards[i])) {
				final int l = i - t.get(cards[i]) + 1;
				d = Math.min(d, l);
			}
			t.put(cards[i], i);
		}

		return d == Integer.MAX_VALUE ? -1 : d;
	}
}
