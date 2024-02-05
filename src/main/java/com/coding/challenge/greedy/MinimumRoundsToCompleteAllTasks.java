package com.coding.challenge.greedy;

import java.util.HashMap;
import java.util.Map;

class MinimumRoundsToCompleteAllTasks {
	MinimumRoundsToCompleteAllTasks() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] tasks1 = { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4 };
		assert minimumRounds(tasks1) == 4;

		final int[] tasks2 = { 2, 3, 3 };
		assert minimumRounds(tasks2) == -1;
	}

	static int minimumRounds(int[] tasks) {
		final Map<Integer, Integer> f = new HashMap<>();
		for (int t : tasks)
			f.merge(t, 1, Integer::sum);

		int rounds = 0;
		for (int v : f.values()) {
			if (v == 1)
				return -1;
			rounds = rounds + (v + 2) / 3;
		}
		return rounds;
	}
}
