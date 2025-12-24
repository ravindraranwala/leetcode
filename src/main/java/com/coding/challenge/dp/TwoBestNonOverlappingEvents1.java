package com.coding.challenge.dp;

import java.util.Arrays;

class TwoBestNonOverlappingEvents1 {
	TwoBestNonOverlappingEvents1() {
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
		// init.
		final int n = events.length;
		Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
		final int[] maxValue = new int[n + 1];
		for (int p = n - 1; p >= 0; p--)
			maxValue[p] = Math.max(maxValue[p + 1], events[p][2]);

		int ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			final int j = successor(events, events[i][1], i, n - 1);
			ans = Math.max(ans, events[i][2] + maxValue[j]);
		}
		return ans;
	}

	static int successor(int[][] a, int target, int i, int j) {
		int l = i;
		int r = j;
		while (l < r) {
			final int mid = (l + r) / 2;
			if (a[mid][0] > target)
				r = mid;
			else
				l = mid + 1;
		}
		if (a[l][0] > target)
			return l;
		
		return a.length;
	}
}
