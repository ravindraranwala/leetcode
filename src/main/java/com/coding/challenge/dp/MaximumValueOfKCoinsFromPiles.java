package com.coding.challenge.dp;

import java.util.Arrays;
import java.util.List;

class MaximumValueOfKCoinsFromPiles {
	MaximumValueOfKCoinsFromPiles() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final List<List<Integer>> piles1 = Arrays.asList(Arrays.asList(1, 100, 3), Arrays.asList(7, 8, 9));
		assert maxValueOfCoins(piles1, 2) == 101;

		final List<List<Integer>> piles2 = Arrays.asList(Arrays.asList(100), Arrays.asList(100), Arrays.asList(100),
				Arrays.asList(100), Arrays.asList(100), Arrays.asList(100), Arrays.asList(1, 1, 1, 1, 1, 1, 700));
		assert maxValueOfCoins(piles2, 7) == 706;

		final List<List<Integer>> piles3 = Arrays.asList(Arrays.asList(1, 100, 3), Arrays.asList(7, 8, 9),
				Arrays.asList(2, 7, 25, 10));
		assert maxValueOfCoins(piles3, 4) == 116;
	}

	static int maxValueOfCoins(List<List<Integer>> piles, int k) {
		final int n = piles.size();
		final int[][] t = new int[k + 1][n + 1];

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				final List<Integer> pile = piles.get(j - 1);
				final int s = Math.min(i, pile.size());
				t[i][j] = t[i][j - 1];
				for (int a = 1, preSum = 0; a <= s; a++) {
					preSum = preSum + pile.get(a - 1);
					t[i][j] = Math.max(t[i][j], t[i - a][j - 1] + preSum);
				}
			}
		}
		return t[k][n];
	}
}
