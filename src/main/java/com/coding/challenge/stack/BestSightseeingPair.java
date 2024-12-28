package com.coding.challenge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class BestSightseeingPair {
	BestSightseeingPair() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] values1 = { 8, 1, 5, 2, 6 };
		assert maxScoreSightseeingPair(values1) == 11;

		final int[] values2 = { 1, 2 };
		assert maxScoreSightseeingPair(values2) == 2;
	}

	static int maxScoreSightseeingPair(int[] values) {
		final int n = values.length;
		int score = 0;
		final Deque<Integer> s = new ArrayDeque<>();

		for (int j = 0; j < n; j++) {
			while (!s.isEmpty() && values[s.peek()] <= values[j]) {
				final int i = s.pop();
				score = Math.max(score, values[i] + values[j] + i - j);
			}

			if (!s.isEmpty())
				score = Math.max(score, values[j] + values[s.peek()] + s.peek() - j);

			s.push(j);
		}
		return score;
	}
}
