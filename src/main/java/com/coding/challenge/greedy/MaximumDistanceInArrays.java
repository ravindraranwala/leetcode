package com.coding.challenge.greedy;

import java.util.Arrays;
import java.util.List;

class MaximumDistanceInArrays {
	MaximumDistanceInArrays() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<List<Integer>> arrays1 = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5),
				Arrays.asList(1, 2, 3));
		assert maxDistance(arrays1) == 4;

		final List<List<Integer>> arrays2 = Arrays.asList(Arrays.asList(1), Arrays.asList(1));
		assert maxDistance(arrays2) == 0;
	}

	static int maxDistance(List<List<Integer>> arrays) {
		final int m = arrays.size();
		int deltaMax = 0;
		// Min and Max are associative operators.
		for (int i = 1, prefixMin = arrays.get(0).get(0),
				prefixMax = arrays.get(0).get(arrays.get(0).size() - 1); i < m; i++) {
			final List<Integer> curr = arrays.get(i);
			final int n = curr.size();
			final int currMin = curr.get(0);
			final int currMax = curr.get(n - 1);
			deltaMax = Math.max(Math.abs(currMax - prefixMin), deltaMax);
			deltaMax = Math.max(Math.abs(prefixMax - currMin), deltaMax);
			prefixMax = Math.max(prefixMax, currMax);
			prefixMin = Math.min(prefixMin, currMin);
		}

		return deltaMax;
	}
}
