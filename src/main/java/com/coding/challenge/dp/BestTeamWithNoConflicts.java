package com.coding.challenge.dp;

import java.util.Arrays;

class BestTeamWithNoConflicts {
	BestTeamWithNoConflicts() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] scoresOne = { 1, 3, 5, 10, 15 };
		final int[] agesOne = { 1, 2, 3, 4, 5 };
		assert bestTeamScore(scoresOne, agesOne) == 34;

		final int[] scoresTwo = { 4, 5, 6, 5 };
		final int[] agesTwo = { 2, 1, 2, 1 };
		assert bestTeamScore(scoresTwo, agesTwo) == 16;

		final int[] scoresThree = { 1, 2, 3, 5 };
		final int[] agesThree = { 8, 9, 10, 1 };
		assert bestTeamScore(scoresThree, agesThree) == 6;
	}

	static int bestTeamScore(int[] scores, int[] ages) {
		final int n = ages.length;
		final int[][] players = new int[n][2];
		for (int i = 0; i < n; i++)
			players[i] = new int[] { ages[i], scores[i] };
		Arrays.sort(players,
				(a, b) -> Integer.compare(a[0], b[0]) == 0 ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
		final int[] sln = new int[n];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int score = 0;
			for (int j = 0; j < i; j++) {
				if (players[j][1] <= players[i][1])
					score = Math.max(score, sln[j]);
			}
			sln[i] = score + players[i][1];
			ans = Math.max(ans, sln[i]);
		}
		return ans;
	}
}
