package com.coding.challenge.dp;

import java.util.Arrays;

class MinJobScheduleDifficulty {
	MinJobScheduleDifficulty() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] jd1 = { 6, 5, 4, 3, 2, 1 };
		final int d1 = 2;
		int md = minDifficulty(jd1, d1);
		System.out.println(md);

		md = minDifficulty(jd1, 3);
		System.out.println(md);

		final int[] jd2 = { 9, 9, 9 };
		final int d2 = 4;
		md = minDifficulty(jd2, d2);
		System.out.println(md);

		final int[] jd3 = { 1, 1, 1 };
		final int d3 = 3;
		md = minDifficulty(jd3, d3);
		System.out.println(md);

		final int[] jd4 = { 11, 111, 22, 222, 33, 333, 44, 444 };
		final int d4 = 6;
		md = minDifficulty(jd4, d4);
		assert md == 843;
	}

	static int minDifficulty(int[] jobDifficulty, int d) {
		final int n = jobDifficulty.length;
		if (d > n)
			return -1;

		final int[][] md = new int[d + 1][n];
		// initializing
		for (int i = 0; i <= d; i++)
			for (int j = 0; j < n; j++)
				md[i][j] = Integer.MAX_VALUE;

		// trivial case of the recursion
		md[1][0] = jobDifficulty[0];
		for (int i = 1; i < n; i++)
			md[1][i] = Math.max(md[1][i - 1], jobDifficulty[i]);

		final int[] a = new int[n];
		a[n - 1] = jobDifficulty[n - 1];
		for (int i = n - 2; i >= 0; i--)
			a[i] = Math.max(a[i + 1], jobDifficulty[i]);

		// non-trivial case of the recursion
		for (int i = 2; i <= d; i++)
			for (int j = i - 1; j < n; j++)
				for (int k = i - 2; k < j; k++)
					md[i][j] = Math.min(md[i][j], md[i - 1][k] + a[k + 1]);

		return md[d][n - 1];
	}
}
