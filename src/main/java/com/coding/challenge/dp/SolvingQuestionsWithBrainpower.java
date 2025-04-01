package com.coding.challenge.dp;

class SolvingQuestionsWithBrainpower {
	SolvingQuestionsWithBrainpower() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] questions = { { 3, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } };
		assert mostPoints(questions) == 5;

		final int[][] questions2 = { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } };
		assert mostPoints(questions2) == 7;
	}

	static long mostPoints(int[][] questions) {
		final int n = questions.length;
		final long[] p = new long[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			if (i + questions[i][1] < n)
				p[i] = Math.max(questions[i][0] + p[i + questions[i][1] + 1], p[i + 1]);
			else
				p[i] = Math.max(questions[i][0], p[i + 1]);
		}
		return p[0];
	}
}
