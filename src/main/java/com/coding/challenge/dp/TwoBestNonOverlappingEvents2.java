package com.coding.challenge.dp;

import java.util.Arrays;

import com.coding.challenge.BinarySearch;

class TwoBestNonOverlappingEvents2 {
	TwoBestNonOverlappingEvents2() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] events1 = { { 1, 3, 2 }, { 4, 5, 2 }, { 2, 4, 3 } };
		assert maxTwoEvents(events1) == 4;

		final int[][] events2 = { { 1, 3, 2 }, { 4, 5, 2 }, { 1, 5, 5 } };
		assert maxTwoEvents(events2) == 5;

		final int[][] events3 = { { 1, 5, 3 }, { 1, 5, 1 }, { 6, 6, 5 } };
		assert maxTwoEvents(events3) == 8;
	}

	static int maxTwoEvents(int[][] events) {
		final int n = events.length;
		Arrays.sort(events, (e1, e2) -> Integer.compare(e1[1], e2[1]));
		final int[] maxProfit = new int[n];
		final int[] f = new int[n];

		int maxVal = 0;
		for (int i = 0, currMax = 0; i < n; i++) {
			currMax = Math.max(currMax, events[i][2]);
			maxProfit[i] = currMax;
			f[i] = events[i][1];
			final int j = BinarySearch.predecessor(f, events[i][0], 0, i - 1);
			if (j == -1)
				maxVal = Math.max(maxVal, events[i][2]);
			else
				maxVal = Math.max(maxVal, events[i][2] + maxProfit[j]);
		}
		return maxVal;
	}
}
