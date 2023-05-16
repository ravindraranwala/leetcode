package com.coding.challenge.greedy;

import java.util.Arrays;

class MatchingPlayersWithTrainers {
	MatchingPlayersWithTrainers() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] playersOne = { 4, 7, 9 };
		final int[] trainersOne = { 8, 2, 5, 8 };
		assert matchPlayersAndTrainers(playersOne, trainersOne) == 2;

		final int[] playersTwo = { 1, 1, 1 };
		final int[] trainersTwo = { 10 };
		assert matchPlayersAndTrainers(playersTwo, trainersTwo) == 1;
	}

	static int matchPlayersAndTrainers(int[] players, int[] trainers) {
		final int m = players.length;
		final int n = trainers.length;
		Arrays.sort(players);
		Arrays.sort(trainers);
		int c = 0;
		for (int i = 0, j = 0; i < n; i++) {
			if (j < m && players[j] <= trainers[i]) {
				c = c + 1;
				j = j + 1;
			}
		}
		return c;
	}
}
