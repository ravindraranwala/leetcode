package com.coding.challenge.dp;

import java.util.Arrays;

import com.coding.challenge.BinarySearch;

public class TwoBestNonOverlappingEvents {
	TwoBestNonOverlappingEvents() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] events1 = { { 1, 3, 2 }, { 4, 5, 2 }, { 2, 4, 3 } };
		int maxVal = maxTwoEvents(events1);
		System.out.println(maxVal);

		final int[][] events2 = { { 1, 3, 2 }, { 4, 5, 2 }, { 1, 5, 5 } };
		maxVal = maxTwoEvents(events2);
		System.out.println(maxVal);

		final int[][] events3 = { { 1, 5, 3 }, { 1, 5, 1 }, { 6, 6, 5 } };
		maxVal =  maxTwoEvents(events3);
		System.out.println(maxVal);
	}

	static int maxTwoEvents(int[][] events) {
		final int n = events.length;
		Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
		final int[][] p = new int[n + 1][3];
		// trivial case of our recursion where the solution is known.
		for (int i = 0; i <= n; i++)
			p[i][0] = 0;
		for (int j = 1; j <= 2; j++)
			p[0][j] = 0;

		for (int i = 1; i <= n; i++) {
			final int c = BinarySearch.predecessor(events, events[i - 1][0], e -> e[1]);
			for (int j = 1; j <= 2; j++) {
				int v = 0;
				if (c >= 0)
					v = p[c + 1][j - 1];
				p[i][j] = Math.max(v + events[i - 1][2], p[i - 1][j]);
			}
		}
		return p[n][2];
	}
}
