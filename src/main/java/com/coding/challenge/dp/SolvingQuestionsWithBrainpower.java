package com.coding.challenge.dp;

class SolvingQuestionsWithBrainpower {
	SolvingQuestionsWithBrainpower() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] questions1 = { { 3, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } };
		assert mostPoints(questions1) == 5;

		final int[][] questions2 = { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } };
		assert mostPoints(questions2) == 7;
	}

	static long mostPoints(int[][] questions) {
		final int n = questions.length;
		final long[] points = new long[n];
		// trivial case of the recursion.
		points[n - 1] = questions[n - 1][0];

		for (int i = n - 2; i >= 0; i--) {
			long val = questions[i][0];
			final int nextIdx = i + questions[i][1] + 1;
			if (nextIdx < n)
				val = val + points[nextIdx];
			points[i] = Math.max(points[i + 1], val);
		}
		return points[0];
	}
}
