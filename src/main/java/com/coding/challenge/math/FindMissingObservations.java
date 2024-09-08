package com.coding.challenge.math;

import java.util.Arrays;

class FindMissingObservations {
	FindMissingObservations() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] rolls1 = { 3, 2, 4, 3 };
		final int[] a1 = { 6, 6 };
		assert Arrays.equals(a1, missingRolls(rolls1, 4, 2));

		final int[] rolls2 = { 1, 5, 6 };
		final int[] a2 = { 3, 2, 2, 2 };
		assert Arrays.equals(a2, missingRolls(rolls2, 3, 4));

		final int[] rolls3 = { 1, 2, 3, 4 };
		assert Arrays.equals(new int[0], missingRolls(rolls3, 6, 4));

		final int[] rolls4 = { 6, 3, 4, 3, 5, 3 };
		assert Arrays.equals(new int[0], missingRolls(rolls4, 1, 6));

		final int[] rolls5 = { 4, 2, 2, 5, 4, 5, 4, 5, 3, 3, 6, 1, 2, 4, 2, 1, 6, 5, 4, 2, 3, 4, 2, 3, 3, 5, 4, 1, 4, 4,
				5, 3, 6, 1, 5, 2, 3, 3, 6, 1, 6, 4, 1, 3 };
		assert Arrays.equals(new int[0], missingRolls(rolls5, 2, 53));
	}

	static int[] missingRolls(int[] rolls, int mean, int n) {
		int s = (rolls.length + n) * mean;
		for (int roll : rolls)
			s = s - roll;

		// no solution exists.
		if (s < n || s > 6 * n)
			return new int[0];

		final int[] a = new int[n];
		/*
		 * Observation: we can construct the output array that satisfies the criteria
		 * using at most 2 integers.
		 */
		final int low = s / n;
		final int high = low + 1;
		final int r = s % n;
		for (int i = 0; i < r; i++)
			a[i] = high;

		for (int i = r; i < n; i++)
			a[i] = low;

		return a;
	}
}
