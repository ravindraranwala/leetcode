package com.coding.challenge.radix.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinimumTimeDifference {
	MinimumTimeDifference() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<String> timePointsOne = new ArrayList<>(Arrays.asList("23:59", "00:00"));
		assert findMinDifference(timePointsOne) == 1;

		final List<String> timePointsTwo = new ArrayList<>(Arrays.asList("00:00", "23:59", "00:00"));
		assert findMinDifference(timePointsTwo) == 0;
	}

	static int findMinDifference(List<String> timePoints) {
		// sorting in linear time as we have 0 to 23 hours and 0 to 59 minutes.
		// How about using radix sort here.
		final int n = timePoints.size();
		final String[] arr = new String[n + 1];
		timePoints.toArray(arr);
		// dummy value will be replaced later.
		arr[n] = "24:00";

		final String[] points = radixSort(arr);
		final String first = points[0];
		// clock wraps.
		final int h = Integer.parseInt(first.substring(0, 2)) + 24;
		points[n] = h + first.substring(2);
		int ans = 1500;
		for (int i = 1, prevHrs = Integer.parseInt(points[0].substring(0, 2)),
				prevMins = Integer.parseInt(points[0].substring(3)); i <= n; i++) {
			final String curr = points[i];
			final int currHrs = Integer.parseInt(curr.substring(0, 2));
			final int currMins = Integer.parseInt(curr.substring(3));
			final int d = (currHrs - prevHrs) * 60 + (currMins - prevMins);
			ans = Math.min(ans, d);
			prevHrs = currHrs;
			prevMins = currMins;
		}
		return ans;
	}

	private static String[] radixSort(String[] arr) {
		final int n = arr.length;
		final String[] a1 = countingSort(arr, n, 9, 4);
		final String[] a2 = countingSort(a1, n, 5, 3);
		final String[] a3 = countingSort(a2, n, 9, 1);
		return countingSort(a3, n, 2, 0);
	}

	// stable sort.
	private static String[] countingSort(String[] a, int n, int k, int d) {
		final String[] b = new String[n];
		final int[] c = new int[k + 1];

		for (int j = 0; j < n; j++) {
			final int val = Integer.parseInt(a[j].charAt(d) + "");
			c[val] = c[val] + 1;
		}

		for (int i = 1; i <= k; i++)
			c[i] = c[i] + c[i - 1];

		for (int j = n - 1; j >= 0; j--) {
			final int val = Integer.parseInt(a[j].charAt(d) + "");
			b[c[val] - 1] = a[j];
			c[val] = c[val] - 1;
		}
		return b;
	}
}
