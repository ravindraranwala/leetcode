package com.coding.challenge.hash.table;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class RabbitsInForest {
	RabbitsInForest() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] ans1 = { 1, 1, 2 };
		assert numRabbits(ans1) == 5;

		final int[] ans2 = { 10, 10, 10 };
		assert numRabbits(ans2) == 11;
	}

	static int numRabbits(int[] answers) {
		final Map<Integer, Integer> t = new HashMap<>();
		for (int response : answers)
			t.merge(response, 1, Integer::sum);

		int ans = 0;
		for (Entry<Integer, Integer> e : t.entrySet()) {
			final int k = e.getKey();
			ans = ans + (e.getValue() + k) / (k + 1) * (k + 1);
		}
		return ans;
	}
}
