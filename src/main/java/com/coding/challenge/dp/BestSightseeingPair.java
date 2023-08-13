package com.coding.challenge.dp;

class BestSightseeingPair {
	BestSightseeingPair() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] valuesOne = { 8, 1, 5, 2, 6 };
		assert maxScoreSightseeingPair(valuesOne) == 11;

		final int[] valuesTwo = { 1, 2 };
		assert maxScoreSightseeingPair(valuesTwo) == 2;
	}

	static int maxScoreSightseeingPair(int[] values) {
		final int n = values.length;
		int maxScore = 0;
		for (int i = n - 2, p = 0; i >= 0; i--) {
			final int s1 = p - values[i + 1] + values[i] - 1;
			final int s2 = values[i] + values[i + 1] - 1;
			p = Math.max(s1, s2);
			maxScore = Math.max(maxScore, p);
		}
		return maxScore;
	}
}
