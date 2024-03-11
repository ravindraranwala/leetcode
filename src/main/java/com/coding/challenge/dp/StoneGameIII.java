package com.coding.challenge.dp;

class StoneGameIII {
	StoneGameIII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] stoneValues1 = { 1, 2, 3, 7 };
		assert "Bob".equals(stoneGameIII(stoneValues1));

		final int[] stoneValues2 = { 1, 2, 3, -9 };
		assert "Alice".equals(stoneGameIII(stoneValues2));

		final int[] stoneValues3 = { 1, 2, 3, 6 };
		assert "Tie".equals(stoneGameIII(stoneValues3));

		final int[] stoneValues4 = { 7, 2, -6, 8, -3, 5, -4, 9, 1, 10 };
		"Alice".equals(stoneGameIII(stoneValues4));

		final int[] stoneValues5 = { -5 };
		assert "Bob".equals(stoneGameIII(stoneValues5));
	}

	static String stoneGameIII(int[] stoneValue) {
		final int n = stoneValue.length;
		final int[] postfixSum = new int[n + 1];
		final int[] score = new int[n + 1];
		// trivial cases of the recursion.
		postfixSum[n - 1] = stoneValue[n - 1];
		score[n - 1] = stoneValue[n - 1];
		if (n > 1) {
			postfixSum[n - 2] = stoneValue[n - 2] + stoneValue[n - 1];
			score[n - 2] = Math.max(stoneValue[n - 2], postfixSum[n - 2]);
		}

		// recurrence.
		for (int i = n - 3; i >= 0; i--) {
			postfixSum[i] = postfixSum[i + 1] + stoneValue[i];
			score[i] = Math.max(stoneValue[i] + postfixSum[i + 1] - score[i + 1],
					Math.max(stoneValue[i] + stoneValue[i + 1] + postfixSum[i + 2] - score[i + 2],
							stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] + postfixSum[i + 3] - score[i + 3]));
		}

		if (score[0] > postfixSum[0] - score[0])
			return "Alice";
		else if (score[0] < postfixSum[0] - score[0])
			return "Bob";
		else
			return "Tie";
	}
}
