package com.coding.challenge.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class RelativeRanks {
	RelativeRanks() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] score1 = { 5, 4, 3, 2, 1 };
		final String[] rank1 = { "Gold Medal", "Silver Medal", "Bronze Medal", "4", "5" };
		assert Arrays.equals(rank1, findRelativeRanks(score1));

		final int[] score2 = { 10, 3, 8, 9, 4 };
		final String[] rank2 = { "Gold Medal", "5", "Bronze Medal", "Silver Medal", "4" };
		assert Arrays.equals(rank2, findRelativeRanks(score2));
	}

	static String[] findRelativeRanks(int[] score) {
		final int n = score.length;
		final Map<Integer, Integer> scoreToPosition = new HashMap<>();
		for (int i = 0; i < n; i++)
			scoreToPosition.put(score[i], i);

		Arrays.sort(score);
		final String[] ranks = new String[n];
		for (int i = 0, currRank = n; i < n - 3; i++, currRank--)
			ranks[scoreToPosition.get(score[i])] = currRank + "";

		if (n >= 3)
			ranks[scoreToPosition.get(score[n - 3])] = "Bronze Medal";
		if (n >= 2)
			ranks[scoreToPosition.get(score[n - 2])] = "Silver Medal";

		ranks[scoreToPosition.get(score[n - 1])] = "Gold Medal";
		return ranks;
	}
}
