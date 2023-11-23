package com.coding.challenge.greedy;

import java.util.Arrays;

class EliminateMaximumNumberOfMonsters {
	EliminateMaximumNumberOfMonsters() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] distOne = { 1, 3, 4 };
		final int[] speedOne = { 1, 1, 1 };
		assert eliminateMaximum(distOne, speedOne) == 3;

		final int[] distTwo = { 1, 1, 2, 3 };
		final int[] speedTwo = { 1, 1, 1, 1 };
		assert eliminateMaximum(distTwo, speedTwo) == 1;

		final int[] distThree = { 3, 2, 4 };
		final int[] speedThree = { 5, 3, 2 };
		assert eliminateMaximum(distThree, speedThree) == 1;

		final int[] distFour = { 4, 3, 4 };
		final int[] speedFour = { 1, 1, 2 };
		assert eliminateMaximum(distFour, speedFour) == 3;
	}

	static int eliminateMaximum(int[] dist, int[] speed) {
		final int n = dist.length;
		final double[] timeToReachCity = new double[n];
		for (int i = 0; i < n; i++)
			timeToReachCity[i] = dist[i] * 1.0 / speed[i];

		int m = 0;
		Arrays.sort(timeToReachCity);
		for (int i = 0, currTime = 0; i < n; i++) {
			if (currTime < timeToReachCity[i])
				m = m + 1;
			else
				return m;
			// charging the weapon.
			currTime = currTime + 1;
		}
		return m;
	}
}
