package com.coding.challenge.sorting;

import java.util.Arrays;

class CarPooling {
	CarPooling() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] tripsOne = { { 2, 1, 5 }, { 3, 3, 7 } };
		assert !carPooling(tripsOne, 4);

		final int[][] tripTwo = { { 2, 1, 5 }, { 3, 3, 7 } };
		assert carPooling(tripTwo, 5);

		final int[][] tripThree = { { 2, 1, 5 }, { 3, 5, 7 } };
		assert carPooling(tripThree, 3);

		final int[][] tripFour = { { 9, 0, 1 }, { 3, 3, 7 } };
		assert !carPooling(tripFour, 4);
	}

	static boolean carPooling(int[][] trips, int capacity) {
		final int n = trips.length;
		final int[][] startingPoints = new int[n][2];
		final int[][] finishingPoints = new int[n][2];
		int maxFinish = 0;
		for (int i = 0; i < n; i++) {
			startingPoints[i] = new int[] { trips[i][0], trips[i][1] };
			finishingPoints[i] = new int[] { trips[i][0], trips[i][2] };
			maxFinish = Math.max(maxFinish, trips[i][2]);
		}
		Arrays.sort(startingPoints, (a, b) -> Integer.compare(a[1], b[1]));
		Arrays.sort(finishingPoints, (a, b) -> Integer.compare(a[1], b[1]));

		for (int i = 0, j = 0, k = 0, pickUp = 0, dropOff = 0; i <= maxFinish; i++) {
			while (j < n && startingPoints[j][1] <= i) {
				pickUp = pickUp + startingPoints[j][0];
				j = j + 1;
			}

			while (k < n && finishingPoints[k][1] <= i) {
				dropOff = dropOff + finishingPoints[k][0];
				k = k + 1;
			}
			if (pickUp - dropOff > capacity)
				return false;
		}
		return true;
	}
}
