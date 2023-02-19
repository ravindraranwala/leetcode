package com.coding.challenge.dp;

import java.util.Arrays;

import com.coding.challenge.BinarySearch;

class MaxTaxiEarnings {
	MaxTaxiEarnings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] rides1 = { { 2, 5, 4 }, { 1, 5, 1 } };
		assert maxTaxiEarnings(rides1) == 7;

		final int[][] rides2 = { { 1, 6, 1 }, { 3, 10, 2 }, { 10, 12, 3 }, { 11, 12, 2 }, { 12, 15, 2 },
				{ 13, 18, 1 } };
		assert maxTaxiEarnings(rides2) == 20;

		final int[][] rides3 = { { 2, 3, 4 }, { 4, 5, 1 } };
		assert maxTaxiEarnings(rides3) == 7;
	}

	static long maxTaxiEarnings(int[][] rides) {
		Arrays.sort(rides, (a, b) -> Integer.compare(a[1], b[1]));
		final int s = rides.length;
		final long[] p = new long[s];
		p[0] = rides[0][1] - rides[0][0] + rides[0][2];
		for (int i = 1; i < s; i++) {
			// Note that we need a closed interval here.
			final int c = BinarySearch.predecessor(rides, rides[i], (a, b) -> Integer.compare(a[1], b[0] + 1));
			long v = 0;
			if (c >= 0)
				v = p[c];
			p[i] = Math.max(v + rides[i][1] - rides[i][0] + rides[i][2], p[i - 1]);
		}
		return p[s - 1];
	}
}
