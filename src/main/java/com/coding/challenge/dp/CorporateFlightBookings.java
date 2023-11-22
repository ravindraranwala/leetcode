package com.coding.challenge.dp;

import java.util.Arrays;

class CorporateFlightBookings {
	CorporateFlightBookings() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] bookingsOne = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
		final int[] expOne = { 10, 55, 45, 25, 25 };
		assert Arrays.equals(expOne, corpFlightBookings(bookingsOne, 5));

		final int[][] bookingsTwo = { { 1, 2, 10 }, { 2, 2, 15 } };
		final int[] expTwo = { 10, 25 };
		assert Arrays.equals(expTwo, corpFlightBookings(bookingsTwo, 2));
	}

	static int[] corpFlightBookings(int[][] bookings, int n) {
		final int[] s = new int[n + 1];
		final int[] f = new int[n + 1];
		for (int[] booking : bookings) {
			s[booking[0]] = s[booking[0]] + booking[2];
			f[booking[1]] = f[booking[1]] + booking[2];
		}
		final int[] r = new int[n];
		r[0] = s[1];
		for (int i = 2; i <= n; i++)
			r[i - 1] = r[i - 2] + s[i] - f[i - 1];
		return r;
	}
}
