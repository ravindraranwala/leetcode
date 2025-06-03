package com.coding.challenge.greedy;

import java.util.Arrays;

class Candy {
	Candy() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final int[] ratings1 = { 1, 0, 2 };
		assert candy(ratings1) == 5;

		final int[] ratings2 = { 1, 2, 2 };
		assert candy(ratings2) == 4;

		final int[] ratings3 = { 1, 2, 5, 7, 8 };
		assert candy(ratings3) == 15;

		final int[] ratings4 = { 8, 7, 5, 4, 2, 1 };
		assert candy(ratings4) == 21;

		final int[] ratings5 = { 7 };
		assert candy(ratings5) == 1;
	}

	static int candy(int[] ratings) {
		if (ratings.length == 1)
			return 1;

		final int n = ratings.length;
		final int[][] a = new int[n][2];
		for (int i = 0; i < n; i++)
			a[i] = new int[] { i, ratings[i] };

		int ans = 0;
		Arrays.sort(a, (p, q) -> Integer.compare(p[1], q[1]));
		final int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			final int j = a[i][0];
			if (j == 0) {
				c[0] = 1;
				if (ratings[1] < ratings[0])
					c[0] = c[1] + 1;
			} else if (j == n - 1) {
				c[n - 1] = 1;
				if (ratings[n - 2] < ratings[n - 1])
					c[n - 1] = c[n - 2] + 1;
			} else {
				c[j] = 1;
				if (ratings[j - 1] < ratings[j])
					c[j] = c[j - 1] + 1;
				if (ratings[j + 1] < ratings[j])
					c[j] = Math.max(c[j], c[j + 1] + 1);
			}
			ans = ans + c[j];
		}

		return ans;
	}
}
