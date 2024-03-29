package com.coding.challenge.dp;

import java.util.Arrays;

import com.coding.challenge.BinarySearch;

// 1751. Maximum Number of Events That Can Be Attended II
class MaxValueEvents {
	MaxValueEvents() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[][] events1 = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 1 } };
		final int k1 = 2;
		assert maxValue(events1, k1) == 7;

		final int[][] events2 = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 10 } };
		final int k2 = 2;
		assert maxValue(events2, k2) == 10;

		final int[][] events3 = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 }, { 4, 4, 4 } };
		final int k3 = 3;
		assert maxValue(events3, k3) == 9;

		final int[][] events4 = { { 11, 17, 56 }, { 24, 40, 53 }, { 5, 62, 67 }, { 66, 69, 84 }, { 56, 89, 15 } };
		final int k4 = 2;
		assert maxValue(events4, k4) == 151;

		final int[][] events5 = { { 548809287, 563205252, 445398 }, { 943815360, 944086803, 560055 },
				{ 204762011, 244293386, 806928 }, { 247251197, 308697110, 211991 }, { 835142187, 842713949, 849104 },
				{ 753209660, 794260559, 322763 }, { 463358095, 510106988, 741580 }, { 184906456, 204722462, 925177 },
				{ 359760683, 448100819, 284 }, { 596457252, 668970311, 163503 } };
		final int k5 = 5;
		assert maxValue(events5, k5) == 3882844;
	}

	static int maxValue(int[][] events, int k) {
		final int n = events.length;
		Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
		final int[][] p = new int[n + 1][k + 1];
		// trivial case of our recursion where the solution is known.
		for (int i = 0; i <= n; i++)
			p[i][0] = 0;
		for (int j = 1; j <= k; j++)
			p[0][j] = 0;

		for (int i = 1; i <= n; i++) {
			final int c = BinarySearch.predecessor(events, events[i - 1], (a, b) -> Integer.compare(a[1], b[0]));
			for (int j = 1; j <= k; j++) {
				int v = 0;
				if (c >= 0)
					v = p[c + 1][j - 1];
				p[i][j] = Math.max(v + events[i - 1][2], p[i - 1][j]);
			}
		}
		return p[n][k];
	}
}
