package com.coding.challenge.general;

public class MinDaysToMakeBouquets {

	public static void main(String[] args) {
		final int[] bloomDayOne = { 1, 10, 3, 10, 2 };
		int d = minDays(bloomDayOne, 3, 1);
		assert d == 3;

		final int[] bloomDayTwo = { 1, 10, 3, 10, 2 };
		d = minDays(bloomDayTwo, 3, 2);
		assert d == -1;

		final int[] bloomDayThree = { 7, 7, 7, 7, 12, 7, 7 };
		d = minDays(bloomDayThree, 2, 3);
		assert d == 12;
	}

	static int minDays(int[] bloomDay, int m, int k) {
		final int n = bloomDay.length;
		int l = Integer.MAX_VALUE;
		int h = 0;
		for (int i = 0; i < n; i++) {
			l = Math.min(l, bloomDay[i]);
			h = Math.max(h, bloomDay[i]);
		}

		int d = -1;
		while (l <= h) {
			final int mid = (l + h) / 2;
			final int b = bouquets(bloomDay, k, mid);
			if (b >= m) {
				d = mid;
				h = mid - 1;
			} else
				l = mid + 1;
		}
		return d;
	}

	static int bouquets(int[] bloomDay, int k, int d) {
		int b = 0;
		int i = 0;
		final int n = bloomDay.length;
		while (i < n) {
			int c = 0;
			while (i < n && bloomDay[i] <= d) {
				c = c + 1;
				i = i + 1;
			}
			b = b + c / k;
			i = i + 1;
		}
		return b;
	}
}
