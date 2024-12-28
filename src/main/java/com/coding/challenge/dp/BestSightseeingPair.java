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
		int score = 0;
		for (int j = 1, i = 0; j < n; j++) {
			score = Math.max(score, values[i] + values[j] + i - j);
			if (values[j] + j - i > values[i])
				i = j;
		}
		return score;
	}
}
