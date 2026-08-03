package com.coding.challenge.dp;

class StoneGameIII {
	private static final String ALICE = "Alice";
	private static final String BOB = "Bob";
	private static final String TIE = "Tie";

	StoneGameIII() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] stoneValue1 = { 1, 2, 3, 7 };
		assert BOB.equals(stoneGameIII(stoneValue1));

		final int[] stoneValue2 = { 1, 2, 3, -9 };
		assert ALICE.equals(stoneGameIII(stoneValue2));

		final int[] stoneValue3 = { 1, 2, 3, 6 };
		assert TIE.equals(stoneGameIII(stoneValue3));

		final int[] stoneValue4 = { -2 };
		assert BOB.equals(stoneGameIII(stoneValue4));
	}

	static String stoneGameIII(int[] stoneValue) {
		final int n = stoneValue.length;
		final int[] score = new int[3];
		score[0] = stoneValue[n - 1];
		int sum = stoneValue[n - 1];
		if (n > 1) {
			score[1] = score[0];
			score[0] = Math.max(stoneValue[n - 2], stoneValue[n - 2] + stoneValue[n - 1]);
			sum = sum + stoneValue[n - 2];
		}

		for (int i = n - 3; i >= 0; i--) {
			final int currScore = Math.max(stoneValue[i] + sum - score[0],
					Math.max(stoneValue[i] + sum - score[1], stoneValue[i] + sum - score[2]));
			// shift everything by one add the new solution to it.
			score[2] = score[1];
			score[1] = score[0];
			score[0] = currScore;
			sum = sum + stoneValue[i];
		}

		if (score[0] == sum - score[0])
			return TIE;
		if (score[0] > sum - score[0])
			return ALICE;

		return BOB;
	}
}
