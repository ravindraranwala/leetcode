package com.coding.challenge.radix.sort;

import java.util.Arrays;
import java.util.List;

class MinimumTimeDifference {
	private static final char ZERO = '0';

	MinimumTimeDifference() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<String> timePoints1 = Arrays.asList("23:59", "00:00");
		assert findMinDifference(timePoints1) == 1;

		final List<String> timePoints2 = Arrays.asList("00:00", "23:59", "00:00");
		assert findMinDifference(timePoints2) == 0;
	}

	static int findMinDifference(List<String> timePoints) {
		// Sort time points lexicographically first.
		final String[] b = radixSort(timePoints.toArray(new String[0]));
		final int n = b.length;
		int minDiffInMinutes = 24 * 60 - convertToMins(b[n - 1]) + convertToMins(b[0]);
		for (int i = 1; i < n; i++)
			minDiffInMinutes = Math.min(minDiffInMinutes, convertToMins(b[i]) - convertToMins(b[i - 1]));

		return minDiffInMinutes;
	}

	private static int convertToMins(String timePoint) {
		final int h = (timePoint.charAt(0) - ZERO) * 10 + timePoint.charAt(1) - ZERO;
		final int m = (timePoint.charAt(3) - ZERO) * 10 + timePoint.charAt(4) - ZERO;
		return h * 60 + m;
	}

	public static String[] radixSort(String[] a) {
		String[] b = a;
		b = countingSort(b, 9, 4);
		b = countingSort(b, 9, 3);
		b = countingSort(b, 9, 1);
		b = countingSort(b, 9, 0);
		return b;
	}

	private static String[] countingSort(String[] a, int k, int d) {
		final int n = a.length;
		final String[] b = new String[n];
		final int[] c = new int[k + 1];

		for (int j = 0; j < n; j++) {
			final int digit = a[j].charAt(d) - ZERO;
			c[digit] = c[digit] + 1;
		}

		for (int i = 1; i <= k; i++)
			c[i] = c[i] + c[i - 1];

		for (int j = n - 1; j >= 0; j--) {
			final int digit = a[j].charAt(d) - ZERO;
			b[c[digit] - 1] = a[j];
			c[digit] = c[digit] - 1;
		}
		return b;
	}
}
