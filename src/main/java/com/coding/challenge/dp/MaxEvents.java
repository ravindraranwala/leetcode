package com.coding.challenge.dp;

import java.util.Arrays;

class MaxEvents {
	MaxEvents() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		// Usecase 1.
		final int[][] e1 = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 1 } };
		final int k1 = 2;
		int v = maxValue(e1, k1);
		System.out.println(v);

		// Usecase 2.
		final int[][] e2 = { { 1, 2, 4 }, { 3, 4, 3 }, { 2, 3, 10 } };
		final int k2 = 2;
		v = maxValue(e2, k2);
		System.out.println(v);

		// Usecase 3.
		final int[][] e3 = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 }, { 4, 4, 4 } };
		final int k3 = 3;
		v = maxValue(e3, k3);
		System.out.println(v);

		// Usecase 4.
		final int[][] e4 = { { 11, 17, 56 }, { 24, 40, 53 }, { 5, 62, 67 }, { 66, 69, 84 }, { 56, 89, 15 } };
		final int k4 = 2;
		v = maxValue(e4, k4);
		System.out.println(v);

		// Usecase 5.
		final int[][] e5 = { { 548809287, 563205252, 445398 }, { 943815360, 944086803, 560055 },
				{ 204762011, 244293386, 806928 }, { 247251197, 308697110, 211991 }, { 835142187, 842713949, 849104 },
				{ 753209660, 794260559, 322763 }, { 463358095, 510106988, 741580 }, { 184906456, 204722462, 925177 },
				{ 359760683, 448100819, 284 }, { 596457252, 668970311, 163503 } };
		final int k5 = 5;
		v = maxValue(e5, k5);
		System.out.println(v);
	}

	static int maxValue(int[][] events, int k) {
		final int n = events.length;
		Arrays.sort(events, (e1, e2) -> Integer.compare(e1[1], e2[1]));
		final int[][] p = new int[2][n];
		for (int i = 0; i < 2; i++)
			p[i][0] = events[0][2];
		for (int j = 1; j < n; j++)
			p[0][j] = Math.max(p[0][j - 1], events[j][2]);

		for (int i = 1; i < k; i++) {
			for (int j = 1; j < n; j++) {
				final int r = i % 2;
				final int b = (r + 1) % 2;
				if (events[j - 1][1] < events[j][0])
					p[r][j] = Math.max(p[r][j - 1], p[b][j - 1] + events[j][2]);
				else {
					final int c = predecessor(events, events[j][0]);
					int cv = 0;
					if (-1 < c)
						cv = p[b][c];
					p[r][j] = Math.max(p[r][j - 1], cv + events[j][2]);
				}
			}
		}
		return p[(k + 1) % 2][n - 1];
	}

	static int predecessor(int[][] a, int target) {
		int l = 0;
		int r = a.length;
		while (l < r) {
			final int mid = (l + r) / 2;
			if (a[mid][1] < target)
				l = mid + 1;
			else
				r = mid;
		}
		return l - 1;
	}
}
